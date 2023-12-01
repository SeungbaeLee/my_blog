package com.example.demo.tag.entity;

import com.example.demo.board.entity.Board;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long boardTagId;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    private String tagName;

    @Builder
    public BoardTag(Board board, Tag tag, String tagName) {
        this.board = board;
        this.tag = tag;
        this.tagName = tagName;
    }

    @Builder
    public BoardTag(Tag tag) {
        this.tag = tag;
    }
}
