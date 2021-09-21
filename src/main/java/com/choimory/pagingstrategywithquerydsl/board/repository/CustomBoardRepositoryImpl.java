package com.choimory.pagingstrategywithquerydsl.board.repository;

import com.choimory.pagingstrategywithquerydsl.board.dto.request.BoardRequestDto;
import com.choimory.pagingstrategywithquerydsl.board.entity.Board;
import com.choimory.pagingstrategywithquerydsl.board.repository.querydsl.expression.BoardBooleanExpressions;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.choimory.pagingstrategywithquerydsl.board.entity.QBoard.board;

@Repository
@RequiredArgsConstructor
public class CustomBoardRepositoryImpl implements CustomBoardRepository{
    private final JPAQueryFactory query;

    @Override
    public List<Board> noOffset(BoardRequestDto param, Pageable pageable) {
        /*OFFSET부터 N개가 아닌, 마지막게시물 ID로부터 N개만큼 가져오는것으로 대체한다*/
        /*OFFSET은 처음부터 하나하나 세어가면서 N번째 레코드까지 이동하지만, no Offset은 ID 조건으로 해당위치 바로 점프하여 가져오므로 빠르다*/
        /*대신 Offset을 안쓰므로 게시물 ID 기준으로만 이동할 수 있어서, 특정 페이지로 바로 이동하는 고전적인 Pagination 방식의 페이징에서는 사용할 수 없다*/
        /*또한 정렬순을 변경할 수 없다*/

        return query.select(Projections.fields(Board.class
                , board.idx
                , board.title
                , board.user.nickname))
                .from(board)
                .where(board.idx.lt(param.getIdx())
                        , BoardBooleanExpressions.likeTitle(param.getTitle())
                        , BoardBooleanExpressions.eqNickname(param.getNickname()))
                .limit(pageable.getPageSize())
                .orderBy(board.idx.desc())
                .fetch();
    }

    @Override
    public Page<Board> coveringIndex(BoardRequestDto param, Pageable pageable) {
        /*커버링인덱스는 쿼리에 해당하는 모든 컬럼을 가지고 있는 인덱스를 의미한다*/
        /*이 커버링 인덱스를 이용하여 최대한의 카디널리티로 id만 뽑아내는 서브쿼리를 join시킨뒤 where in id로 처리하는 쿼리 전략이다*/
        /*join절 서브쿼리는 select절에 id(pk)만 해당되며, 조건 및 정렬에는 인덱스에 포함된 컬럼만 들어가서 부담이 덜하고, 메인 쿼리는 where in id로 빠르게 가져오니까 부담이 덜하다*/
        /*주의사항 - 커버링 인덱스의 첫번째 인덱스는 쿼리에 반드시 포함이 되어야 옵티마이저가 해당 인덱스를 탄다*/

        /*e.g.
        select *
        from board as main
        join (select id
                from board
                where 조건들
                order by id desc
                limit) as sq
        on main.id = sq.id*/

        //------------------------

        /*그러나 Querydsl에서는 from절 서브쿼리를 진행하지 않으므로 id만 뽑아내는 쿼리를 1차적으로 수행한뒤*/
        /*해당 결과로 where in을 처리하는 2차 쿼리를 수행한다*/

        //커버링 인덱스에 해당하는 컬럼들만 사용하여 id만을 select하는 쿼리를 1차수행
        List<Long> ids = query.select(board.idx)
                .from(board)
                .where(board.title.startsWithIgnoreCase(param.getTitle()),
                        board.user.nickname.eq(param.getNickname()))
                .fetch();

        //결과없을시 2차수행없이 리턴
        if(CollectionUtils.isEmpty(ids)){
            return new PageImpl<>(new ArrayList<>(), pageable, 0);
        }

        //1의 결과로 where in
        QueryResults<Board> queryResults = query.select(board)
                .from(board)
                .where(board.idx.in(ids))
                .fetchResults();

        return new PageImpl<>(queryResults.getResults(), pageable, queryResults.getTotal());
    }

    @Override
    public Page<Board> cachedTotalCount(BoardRequestDto param, Pageable pageable) {
        JPAQuery<Board> buildedQuery = query.select(Projections.fields(Board.class
                , board.idx
                , board.title
                , board.user.nickname))
                .from(board)
                .where(BoardBooleanExpressions.likeTitle(param.getTitle())
                        , BoardBooleanExpressions.eqNickname(param.getNickname()))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(board.idx.desc());

        List<Board> content = buildedQuery.fetch();
        long totalCount = param.getCachedTotalCount() == null ? buildedQuery.fetchCount() : param.getCachedTotalCount();

        return new PageImpl<>(content, pageable, totalCount);
    }
}
