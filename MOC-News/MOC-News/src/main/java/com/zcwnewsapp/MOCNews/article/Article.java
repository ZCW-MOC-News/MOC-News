package com.zcwnewsapp.MOCNews.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zcwnewsapp.MOCNews.categories.Category;
import com.zcwnewsapp.MOCNews.comments.Comment;
import com.zcwnewsapp.MOCNews.dto.ArticleDTO;
import com.zcwnewsapp.MOCNews.likes.Likes;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries({
        @NamedNativeQuery(name = "Article.findAllArticles_Named",
                query = "SELECT a.article_id AS article_id, a.author AS author, a.title AS title, " +
                        "a.source AS source, a.description AS description, a.date AS date, a.content AS content, " +
                        "COUNT(DISTINCT l.likes_id) AS likes_count, " +
                        "COUNT(DISTINCT c.comment_id) AS comments_count, " +
                        "cat.category AS category " +
                        "FROM article a " +
                        "JOIN category cat ON a.category_id = cat.category_id " +
                        "LEFT JOIN likes l ON a.article_id = l.article_id " +
                        "LEFT JOIN comment c ON a.article_id = c.article_id " +
                        "GROUP BY a.article_id " +
                        "ORDER BY a.date DESC",
                resultSetMapping = "Mapping.ArticleDTO"),
        @NamedNativeQuery(name = "Article.findArticle_Named",
                query = "SELECT a.article_id AS article_id, a.author AS author, a.title AS title, " +
                        "a.source AS source, a.description AS description, a.date AS date, a.content AS content, " +
                        "COUNT(DISTINCT l.likes_id) AS likes_count, " +
                        "COUNT(DISTINCT c.comment_id) AS comments_count, " +
                        "cat.category AS category " +
                        "FROM article a " +
                        "JOIN category cat ON a.category_id = cat.category_id " +
                        "LEFT JOIN likes l ON a.article_id = l.article_id " +
                        "LEFT JOIN comment c ON a.article_id = c.article_id " +
                        "WHERE a.article_id = ? " +
                        "GROUP BY a.article_id",
                resultSetMapping = "Mapping.ArticleDTO"),
        @NamedNativeQuery(name = "Article.findLikedArticles_Named",
                query = "SELECT a.article_id AS article_id, a.author AS author, a.title AS title, " +
                        "a.source AS source, a.description AS description, a.date AS date, a.content AS content, " +
                        "COUNT(DISTINCT l.likes_id) AS likes_count, " +
                        "COUNT(DISTINCT c.comment_id) AS comments_count, " +
                        "cat.category AS category " +
                        "FROM article a " +
                        "JOIN category cat ON a.category_id = cat.category_id " +
                        "JOIN likes l ON a.article_id = l.article_id " +
                        "LEFT JOIN comment c ON a.article_id = c.article_id " +
                        "WHERE l.account_id = ? " +
                        "GROUP BY a.article_id",
                resultSetMapping = "Mapping.ArticleDTO")
})

@SqlResultSetMapping(name = "Mapping.ArticleDTO", classes = @ConstructorResult(targetClass = ArticleDTO.class,
                columns = {@ColumnResult(name = "article_id", type = Long.class),
                        @ColumnResult(name = "author"),
                        @ColumnResult(name = "title"),
                        @ColumnResult(name = "source"),
                        @ColumnResult(name = "description"),
                        @ColumnResult(name = "date", type = LocalDate.class),
                        @ColumnResult(name = "content"),
                        @ColumnResult(name = "likes_count", type = Integer.class),
                        @ColumnResult(name = "comments_count", type = Integer.class),
                        @ColumnResult(name = "category")}))

@Getter @Setter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="article_id")
    private Long id;
    private String author;
    @Column(unique = true)
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

    @OneToMany(
            mappedBy = "article",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Likes> likes = new ArrayList<>();

    @OneToMany(
            mappedBy = "article",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments = new ArrayList<>();

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


