package com.choimory.pagingstrategywithquerydsl.board.repository;

import com.choimory.pagingstrategywithquerydsl.board.dto.request.BoardRequestDto;
import com.choimory.pagingstrategywithquerydsl.board.entity.Board;
import com.choimory.pagingstrategywithquerydsl.board.util.BoardBooleanExpressions;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

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

        return query.select(Projections.fields(Board.class
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
        return null;
    }

    @Override
    public Page<Board> cachedTotalCount(BoardRequestDto param, Pageable pageable) {
        return null;
    }
}
