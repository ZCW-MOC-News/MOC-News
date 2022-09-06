package com.zcwnewsapp.MOCNews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ArticleDTO {

    private Long article_id;
    private String author;
    private String title;
    private String source;
    private String description;
    private LocalDate date;
    private String content;
    private Integer likes_count;
    private Integer comments_count;
    private String category;

}
