package com.choimory.pagingstrategywithquerydsl.boardComment.entity;

import com.choimory.pagingstrategywithquerydsl.board.entity.Board;
import com.choimory.pagingstrategywithquerydsl.common.entity.CommonTimeEntity;
import com.choimory.pagingstrategywithquerydsl.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@SuperBuilder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardComment extends CommonTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @OneToOne
    @JoinColumn(name = "USER_IDX")
    private User user;
    @ManyToOne
    @JoinColumn(name = "BOARD_IDX")
    private Board board;
    private String comment;
}
