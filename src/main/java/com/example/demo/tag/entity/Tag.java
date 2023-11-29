package com.example.demo.tag.entity;

import com.example.demo.board.entity.Board;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tagId;

    @Column
    private String tagName;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
