package com.example.demo.member.entity;

import com.example.demo.board.entity.Board;
import com.example.demo.comment.entity.Comment;
import com.example.demo.global.auditable.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends Auditable {

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

    @Enumerated(EnumType.STRING)
    private Role role;//ROLE_USER, ROLE_ADMIN

    @Enumerated(EnumType.STRING)
    private SocialType socialType;//GOOGLE,NAVER,KAKAO

    private String refreshToken; // 리프레시 토큰

    public void setRole(Role role) { //삭제예정
        this.role = role;
    }

    @Builder
    public Member(String name, String email, String password, List<Board> boardList, List<Comment> commentList,Role role) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.boardList = boardList;
        this.commentList = commentList;
        this.role = role;
    }

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }
}
