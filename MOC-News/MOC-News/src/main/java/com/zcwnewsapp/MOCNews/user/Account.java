package com.zcwnewsapp.MOCNews.user;

import com.sun.istack.NotNull;
import com.zcwnewsapp.MOCNews.bookmarks.Bookmarks;
import com.zcwnewsapp.MOCNews.likes.Likes;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter @Setter
@Entity
public class Account {

    // Automatically generate user id, which will be unique for each user
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long id;
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;

//    @OneToMany (mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
//
//    public List<Bookmarks> bookmarks = new ArrayList<>();

    @OneToMany (mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Likes> likes = new ArrayList<>();

    public Account() {}
    }


