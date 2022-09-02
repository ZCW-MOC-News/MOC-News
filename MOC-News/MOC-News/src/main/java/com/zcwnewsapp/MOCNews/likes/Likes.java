package com.zcwnewsapp.MOCNews.likes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zcwnewsapp.MOCNews.article.Article;
import com.zcwnewsapp.MOCNews.user.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(uniqueConstraints= @UniqueConstraint(columnNames = {"article_id", "account_id"}) )
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

    public Likes() {
    }

}
