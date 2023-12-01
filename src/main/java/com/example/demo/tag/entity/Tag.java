package com.example.demo.tag.entity;

import com.example.demo.global.auditable.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tagId;

    @Column
    private String tagName;

    @OneToMany(mappedBy = "tag")
    private List<BoardTag> boards = new ArrayList<>();

    @Builder
    public Tag(String tagName, List<BoardTag> boards) {
        this.tagName = tagName;
        this.boards = boards;
    }

    @Builder
    public Tag(String tagName) {
        this.tagName = tagName;
    }
}
