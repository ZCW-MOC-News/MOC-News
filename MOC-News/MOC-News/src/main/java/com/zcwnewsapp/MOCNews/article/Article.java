package com.zcwnewsapp.MOCNews.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zcwnewsapp.MOCNews.likes.Likes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="article_id")
    private Long id;
    private String author;
    private String title;
    private String source;
    @Column(length = 512)
    private String description;
    @Column(columnDefinition = "text")
    private String content;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Likes> likes = new ArrayList<>();

    public Article () {
    }

    public Article(Long id, String author, String title, String source, String description, String content, LocalDate date) {
        this.author = author;
        this.title = title;
        this.source = source;
        this.description = description;
        this.content = content;
        this.date = date;
    }

}
