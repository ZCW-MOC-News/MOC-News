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
    @Column
    private Long accountId;
    @Column
    private Long articleId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long likesId;

    @ManyToOne
    @JoinColumn(name = "accountId", insertable = false, updatable = false, nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "articleId", insertable = false, updatable = false, nullable = false)
    private Article article;

    public List<Article> articles = new ArrayList<>();
   public Likes() {

   }
    public Likes (Long accountId, Long articleId) {
        this.accountId = accountId;
        this.articleId = articleId;
    }

}
