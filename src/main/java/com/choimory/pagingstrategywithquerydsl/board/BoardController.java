package com.choimory.pagingstrategywithquerydsl.board;

import com.choimory.pagingstrategywithquerydsl.board.dto.request.BoardRequestDto;
import com.choimory.pagingstrategywithquerydsl.board.entity.Board;
import com.choimory.pagingstrategywithquerydsl.board.service.BoardService;
import com.choimory.pagingstrategywithquerydsl.common.response.dto.CommonResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/no-offset")
    public ResponseEntity<CommonResponseDto<?>> noOffset(final BoardRequestDto param, final Pageable pageable){
        return ResponseEntity.ok(CommonResponseDto.builder()
                .data(boardService.noOffset(param, pageable))
                .build());
    }

    @GetMapping("/covering-index")
    public ResponseEntity<CommonResponseDto<?>> coveringIndex(final BoardRequestDto param, final Pageable pageable){
        return ResponseEntity.ok(CommonResponseDto.builder()
                .data(boardService.coveringIndex(param, pageable))
                .build());
    }

    @GetMapping("/cached-total-count")
    public ResponseEntity<CommonResponseDto<?>> cachedTotalCount(final BoardRequestDto param, final Pageable pageable){
        return ResponseEntity.ok(CommonResponseDto.builder()
                .data(boardService.cachedTotalCount(param, pageable))
                .build());
    }
}
