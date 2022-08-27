package com.zcwnewsapp.MOCNews.article;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter @Getter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="category_id")
    private Long id;
    private String category;

    public Category () {

    }

}
