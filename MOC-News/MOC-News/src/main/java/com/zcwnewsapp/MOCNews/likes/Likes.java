package com.zcwnewsapp.MOCNews.likes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zcwnewsapp.MOCNews.article.Article;
import com.zcwnewsapp.MOCNews.article.Category;
import com.zcwnewsapp.MOCNews.user.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "likes_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    @JsonIgnore
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    public Likes () {
    }

}
