package com.zcwnewsapp.MOCNews.article;

import com.zcwnewsapp.MOCNews.user.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByTitleIgnoreCaseContaining(String title);

    List<Article> findByAuthorIgnoreCaseContaining(String author);
}
