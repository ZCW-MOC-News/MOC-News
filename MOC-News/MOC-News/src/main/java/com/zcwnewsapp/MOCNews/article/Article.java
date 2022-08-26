package com.zcwnewsapp.MOCNews.article;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime date;

    public Article () {
    }

    public Article(Long id, String author, String title, String source, String description, String content, LocalDateTime date) {
        this.author = author;
        this.title = title;
        this.source = source;
        this.description = description;
        this.content = content;
        this.date = date;
    }

}
