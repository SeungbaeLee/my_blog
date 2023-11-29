package com.example.demo.board.entity;

import com.example.demo.category.entity.Category;
import com.example.demo.comment.entity.Comment;
import com.example.demo.global.Auditable;
import com.example.demo.member.entity.Member;
import com.example.demo.tag.entity.BoardTag;
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
}

