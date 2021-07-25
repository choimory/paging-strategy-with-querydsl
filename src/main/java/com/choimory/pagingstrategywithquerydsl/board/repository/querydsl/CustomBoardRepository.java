package com.choimory.pagingstrategywithquerydsl.board.repository.querydsl;

import com.choimory.pagingstrategywithquerydsl.board.dto.request.BoardRequestDto;
import com.choimory.pagingstrategywithquerydsl.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomBoardRepository {
    Page<Board> noOffset(final BoardRequestDto param, final Pageable pageable);
    Page<Board> coveringIndex(final BoardRequestDto param, final Pageable pageable);
    Page<Board> cachedTotalCount(final BoardRequestDto param, final Pageable pageable);
}
