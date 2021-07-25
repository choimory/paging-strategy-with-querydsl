package com.choimory.pagingstrategywithquerydsl.board.repository.querydsl;

import com.choimory.pagingstrategywithquerydsl.board.dto.request.BoardRequestDto;
import com.choimory.pagingstrategywithquerydsl.board.entity.Board;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomBoardRepositoryImpl implements CustomBoardRepository{
    private final JPAQueryFactory query;

    @Override
    public Page<Board> noOffset(BoardRequestDto param, Pageable pageable) {
        return null;
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
