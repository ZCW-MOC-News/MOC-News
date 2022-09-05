package com.zcwnewsapp.MOCNews.comments;

import com.zcwnewsapp.MOCNews.dto.CommentDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Query(nativeQuery = true)
    List<CommentDTO> findCommentsByArticleId_Named(Long id);

}
