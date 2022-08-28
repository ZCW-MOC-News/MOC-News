package com.zcwnewsapp.MOCNews.user;

import com.sun.istack.NotNull;
import com.zcwnewsapp.MOCNews.likes.Likes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "Account")
public class Account {

    // Automatically generate user id, which will be unique for each user
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @Column(unique=true)
    private String username;
    @NotNull
    private String password;

    //Add annotation
    public ArrayList<String> bookmarks;

    @OneToMany (mappedBy = "account", cascade = CascadeType.ALL)
    public ArrayList<Likes> likes;

    public Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long id) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Account))
            return false;
        Account account = (Account) o;
        return Objects.equals(this.username, account.username) && Objects.equals(this.password, account.password)
                && Objects.equals(this.accountId, account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.accountId, this.username);
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + this.accountId + ", username='" + this.username +'}';
    }
}

