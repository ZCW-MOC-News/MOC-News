package com.zcwnewsapp.MOCNews.categories;

import com.sun.istack.NotNull;
import com.zcwnewsapp.MOCNews.article.Article;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="category_id")
    private Long id;
    @Column(unique=true)
    private String category;
    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Article> articles = new ArrayList<>();

    public Category () {

    }

}
