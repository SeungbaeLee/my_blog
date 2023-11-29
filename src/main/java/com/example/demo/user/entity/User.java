package com.example.demo.user.entity;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany
    private List<Board> boardList = new ArrayList<>();

    @OneToMany
    private List<Comment> commentList = new ArrayList<>();
}
