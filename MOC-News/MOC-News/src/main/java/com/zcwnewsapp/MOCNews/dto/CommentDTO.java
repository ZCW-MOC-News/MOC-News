package com.zcwnewsapp.MOCNews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentDTO {

    private Long comment_id;
    private String comment;
    private LocalDateTime date;
    private long account_id;
    private long article_id;
    private String commenter;
}
