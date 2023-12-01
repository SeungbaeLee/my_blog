package com.example.demo.board.entity;

import com.example.demo.category.entity.Category;
import com.example.demo.comment.entity.Comment;
import com.example.demo.global.auditable.Auditable;
import com.example.demo.member.entity.Member;
import com.example.demo.tag.entity.BoardTag;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long boardId;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private long viewCount;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "board")
    private List<Comment> commentList = new ArrayList<>();

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "board")
    private List<BoardTag> tags = new ArrayList<>();

    @Builder
    public Board(String title, String content, long viewCount, Member member, List<Comment> commentList, Category category, List<BoardTag> tags) {
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.member = member;
        this.commentList = commentList;
        this.category = category;
        this.tags = tags;
    }
}

