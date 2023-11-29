package com.example.demo.comment.entity;

import com.example.demo.board.entity.Board;
import com.example.demo.global.Auditable;
import com.example.demo.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Comment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column
    private String content;

    @ManyToOne(targetEntity = Board.class)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "member_id")
    private Member member;


}
