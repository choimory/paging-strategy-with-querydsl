package com.choimory.pagingstrategywithquerydsl.board.mapper;

import com.choimory.pagingstrategywithquerydsl.board.dto.response.BoardResponseDto;
import com.choimory.pagingstrategywithquerydsl.board.entity.Board;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface BoardMapper {
    BoardResponseDto toDto(Board entity);
    List<BoardResponseDto> toDtos(List<Board> entities);
}
