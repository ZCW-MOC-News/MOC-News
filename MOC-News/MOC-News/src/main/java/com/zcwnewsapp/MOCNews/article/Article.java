package com.zcwnewsapp.MOCNews.article;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
