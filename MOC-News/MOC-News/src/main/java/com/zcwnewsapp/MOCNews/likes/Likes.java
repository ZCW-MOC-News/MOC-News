package com.zcwnewsapp.MOCNews.likes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "likes_id")
    private Long id;

    public Likes() {
    }

}
