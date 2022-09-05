package com.zcwnewsapp.MOCNews.comments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.zcwnewsapp.MOCNews.article.Article;
import com.zcwnewsapp.MOCNews.dto.CommentDTO;
import com.zcwnewsapp.MOCNews.user.Account;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@NamedNativeQueries({
        @NamedNativeQuery(name = "Comment.findCommentsByArticleId_Named",
                query = "SELECT c.comment_id, c.comment, c.date, ac.account_id, a.article_id, ac.username AS commenter " +
                        "FROM comment c " +
                        "JOIN article a ON c.article_id = a.article_id " +
                        "JOIN account ac ON c.account_id = ac.account_id " +
                        "WHERE a.article_id = ? " +
                        "ORDER by c.date DESC",
                resultSetMapping = "Mapping.CommentDTO")
})

@SqlResultSetMapping(name = "Mapping.CommentDTO", classes = @ConstructorResult(targetClass = CommentDTO.class,
        columns = {@ColumnResult(name = "comment_id", type = Long.class),
                @ColumnResult(name = "comment"),
                @ColumnResult(name = "date", type = LocalDateTime.class),
                @ColumnResult(name = "account_id", type = Long.class),
                @ColumnResult(name = "article_id", type = Long.class),
                @ColumnResult(name = "commenter") }))

@Setter @Getter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="comment_id")
    private Long id;

    @NotNull
    @Column(columnDefinition = "text")
    private String comment;

    @NotNull
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    @JsonIgnore
    private Article article;


    public Comment() {

    }
}
