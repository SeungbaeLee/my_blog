package com.example.demo.member.entity;

import com.example.demo.board.entity.Board;
import com.example.demo.comment.entity.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> commentList = new ArrayList<>();
}
