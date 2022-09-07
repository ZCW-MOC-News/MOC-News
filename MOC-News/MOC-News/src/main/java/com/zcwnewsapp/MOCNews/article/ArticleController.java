package com.zcwnewsapp.MOCNews.article;

import com.zcwnewsapp.MOCNews.categories.Category;
import com.zcwnewsapp.MOCNews.dto.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
@RequestMapping(path="/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path="/post")
    public @ResponseBody String postArticle(@RequestParam String author,
                                            @RequestParam String title,
                                            @RequestParam String source,
                                            @RequestParam String description,
                                            @RequestParam String content,
                                            @RequestParam String date,
                                            @RequestParam String category) {

        // Formats a String into a Java date object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datetime = LocalDate.parse(date, formatter);
        Article a = new Article();
        a.setAuthor(author);
        a.setDate(datetime);
        a.setTitle(title);
        a.setSource(source);
        a.setDescription(description);
        a.setContent(content);
        Category c = entityManager.getReference(Category.class, Long.parseLong(category));
        a.setCategory(c);
        articleRepository.save(a);
        entityManager.persist(a);

        return "Saved";
    }

    @Transactional
    @PostMapping(path="/post_story")
    public @ResponseBody String postArticleForm(@RequestParam(value="author") String author,
                                                @RequestParam(value="title") String title,
                                                @RequestParam(value="source") String source,
                                                @RequestParam(value="description") String description,
                                                @RequestParam(value="content") String content,
                                                @RequestParam(value="date") String date,
                                                @RequestParam(value="category") String category) {

        // Formats a String into a Java date object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datetime = LocalDate.parse(date, formatter);
        Article a = new Article();
        a.setAuthor(author);
        a.setDate(datetime);
        a.setTitle(title);
        a.setSource(source);
        a.setDescription(description);
        content = content.replaceAll("(\r\n|\n)", "<br />");
        a.setContent(content);
        Category c = entityManager.getReference(Category.class, Long.parseLong(category));
        a.setCategory(c);
        articleRepository.save(a);
        entityManager.persist(a);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Article> getAllArticles() {
        //     This returns a JSON or XML with the users
        return articleRepository.findAll();
    }

    @GetMapping(path="/find_id")
    public @ResponseBody ArticleDTO getArticle(@RequestParam Long id) {
        return articleRepository.findArticle_Named(id);
    }

    @GetMapping(path="/find_author")
    public @ResponseBody Iterable<Article> getAuthor(@RequestParam String author) {
        return articleRepository.findByAuthorIgnoreCaseContaining(author);
    }

    @GetMapping(path="/find_title")
    public @ResponseBody Iterable<Article> getTitle(@RequestParam String title) {
        return articleRepository.findByTitleIgnoreCaseContaining(title);
    }

    @GetMapping(path="/all_ordered")
    public @ResponseBody Iterable<ArticleDTO> getAllOrdered() {
        return articleRepository.findAllArticles_Named();
    }

    @GetMapping(path="/liked")
    public @ResponseBody Iterable<ArticleDTO> getAllLiked(@RequestParam Long account_id) {
        return articleRepository.findLikedArticles_Named(account_id);
    }

    @GetMapping(path="/get_by_category")
    public @ResponseBody Iterable<ArticleDTO>  getArticleByCategory(@RequestParam Long category_id) {
        return articleRepository.findArticlesByCategory_Named(category_id);
    }

    @DeleteMapping(path="/delete_by_id")
    public @ResponseBody void deleteArticle(@RequestParam Long article_id) {
        //     This returns a JSON or XML with the users
         articleRepository.deleteById(article_id);
    }


}