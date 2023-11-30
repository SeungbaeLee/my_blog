package com.example.demo.tag.entity;

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
public class Tag extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tagId;

    @Column
    private String tagName;

    @OneToMany(mappedBy = "tag")
    private List<BoardTag> boards = new ArrayList<>();
//    @ManyToOne
//    @JoinColumn(name = "board_id")
//    private Board board;
}
