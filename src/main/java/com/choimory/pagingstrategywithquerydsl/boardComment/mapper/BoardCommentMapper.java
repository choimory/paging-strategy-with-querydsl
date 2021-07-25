package com.choimory.pagingstrategywithquerydsl.boardComment.mapper;

import com.choimory.pagingstrategywithquerydsl.boardComment.dto.response.BoardCommentResponseDto;
import com.choimory.pagingstrategywithquerydsl.boardComment.entity.BoardComment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface BoardCommentMapper {
    BoardCommentResponseDto toDto (BoardComment entity);
    List<BoardCommentResponseDto> toDtos(List<BoardComment> entities);
}
