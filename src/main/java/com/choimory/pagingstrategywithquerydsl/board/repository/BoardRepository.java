package com.choimory.pagingstrategywithquerydsl.board.repository;

import com.choimory.pagingstrategywithquerydsl.board.entity.Board;
import com.choimory.pagingstrategywithquerydsl.board.repository.querydsl.CustomBoardRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, CustomBoardRepository {
}
