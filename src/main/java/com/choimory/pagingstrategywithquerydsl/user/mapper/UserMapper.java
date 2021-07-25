package com.choimory.pagingstrategywithquerydsl.user.mapper;

import com.choimory.pagingstrategywithquerydsl.user.dto.response.UserResponseDto;
import com.choimory.pagingstrategywithquerydsl.user.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserResponseDto toDto(User entitiy);
    List<UserResponseDto> toDtos(List<User> entities);
}
