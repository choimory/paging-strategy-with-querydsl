package com.choimory.pagingstrategywithquerydsl.board.service;

import com.choimory.pagingstrategywithquerydsl.board.dto.request.BoardRequestDto;
import com.choimory.pagingstrategywithquerydsl.board.dto.response.BoardResponseDto;
import com.choimory.pagingstrategywithquerydsl.board.mapper.BoardMapper;
import com.choimory.pagingstrategywithquerydsl.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public List<BoardResponseDto> noOffset(final BoardRequestDto param, final Pageable pageable){
        return null;
    }

    public List<BoardResponseDto> coveringIndex(final BoardRequestDto param, final Pageable pageable){
        return null;
    }

    public List<BoardResponseDto> cachedTotalCount(final BoardRequestDto param, final Pageable pageable){
        return null;
    }
}
