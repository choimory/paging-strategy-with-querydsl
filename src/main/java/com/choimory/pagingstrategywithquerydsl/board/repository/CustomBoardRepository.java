package com.choimory.pagingstrategywithquerydsl.board.repository;

import com.choimory.pagingstrategywithquerydsl.board.dto.request.BoardRequestDto;
import com.choimory.pagingstrategywithquerydsl.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomBoardRepository {
    List<Board> noOffset(final BoardRequestDto param, final Pageable pageable);
    Page<Board> coveringIndex(final BoardRequestDto param, final Pageable pageable);
    Page<Board> cachedTotalCount(final BoardRequestDto param, final Pageable pageable);
}
