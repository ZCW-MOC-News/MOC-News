package com.zcwnewsapp.MOCNews.article;


import com.zcwnewsapp.MOCNews.dto.ArticleDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByTitleIgnoreCaseContaining(String title);

    List<Article> findByAuthorIgnoreCaseContaining(String author);

    @Query(nativeQuery = true)
    List<ArticleDTO> findAllArticles_Named();

    @Query(nativeQuery = true)
    ArticleDTO findArticle_Named(Long id);
}
