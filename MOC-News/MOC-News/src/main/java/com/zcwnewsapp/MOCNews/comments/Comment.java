package com.zcwnewsapp.MOCNews.comments;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="comment_id")
    private Long id;
    private String comment;



    public Comment() {

    }



}
