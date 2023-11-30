package com.example.demo.category.entity;

import com.example.demo.board.entity.Board;
import com.example.demo.global.auditable.Auditable;
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
public class Category extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @Column
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Board> boardList = new ArrayList<>();
}
