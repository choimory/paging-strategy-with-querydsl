package com.choimory.pagingstrategywithquerydsl.board.dto.response;

import com.choimory.pagingstrategywithquerydsl.boardComment.dto.response.BoardCommentResponseDto;
import com.choimory.pagingstrategywithquerydsl.user.dto.response.UserResponseDto;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {
    private Long idx;
    private String title;
    private String content;
    private UserResponseDto user;
    private List<BoardCommentResponseDto> boardComments;
}
