package com.zcwnewsapp.MOCNews.likes;
import com.zcwnewsapp.MOCNews.article.Article;
import com.zcwnewsapp.MOCNews.user.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "Likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likesId;

    private Long accountId;
    private Long articleId;

    @ManyToOne
    @JoinColumn(name = "accountId", insertable = false, updatable = false, nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "articleId", insertable = false, updatable = false, nullable = false)
    private Article article;

    public List<Article> articles = new ArrayList<>();

    public Likes () {
    }

}
