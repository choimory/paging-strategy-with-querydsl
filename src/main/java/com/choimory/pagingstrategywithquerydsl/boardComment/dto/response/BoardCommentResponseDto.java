package com.choimory.pagingstrategywithquerydsl.boardComment.dto.response;

import com.choimory.pagingstrategywithquerydsl.board.dto.response.BoardResponseDto;
import com.choimory.pagingstrategywithquerydsl.user.dto.response.UserResponseDto;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardCommentResponseDto {
    private Long idx;
    private UserResponseDto user;
    private BoardResponseDto board;
    private String comment;
}
