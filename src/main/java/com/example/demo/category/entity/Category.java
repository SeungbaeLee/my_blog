package com.example.demo.category.entity;

import com.example.demo.board.entity.Board;
import com.example.demo.global.auditable.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @Column
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Board> boardList = new ArrayList<>();

    @Builder
    public Category(String categoryName, List<Board> boardList) {
        this.categoryName = categoryName;
        this.boardList = boardList;
    }

    public List<Board> getBoardList(){
        if (boardList == null) {
            boardList = new ArrayList<>();
        }
        return boardList;
    }
}
