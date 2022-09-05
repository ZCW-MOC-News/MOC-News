package com.zcwnewsapp.MOCNews.comments;

import com.zcwnewsapp.MOCNews.article.Article;
import com.zcwnewsapp.MOCNews.dto.CommentDTO;
import com.zcwnewsapp.MOCNews.user.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
@RequestMapping(path="/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path="/add")
    public @ResponseBody String addComment(@RequestParam Long account_id, @RequestParam Long article_id, @RequestParam String comment, @RequestParam String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime datetime = LocalDateTime.parse(date, formatter);
        Comment com = new Comment();
        Account acc = entityManager.getReference(Account.class, account_id);
        Article art = entityManager.getReference(Article.class, article_id);
        com.setAccount(acc);
        com.setArticle(art);
        com.setComment(comment);
        com.setDate(datetime);
        entityManager.persist(com);
        commentRepository.save(com);
        return "Saved";
    }

//    @Transactional
//    @PostMapping(path="/add_json")
//    public @ResponseBody String addCommentJson(@RequestParam Map<String, Object> data) {
//        String date = (String)data.get("date");
//        Long account_id = Long.parseLong((String)data.get("account_id"));
//        Long article_id = Long.parseLong((String)data.get("article_id"));
//        String comment = (String)data.get("comment");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime datetime = LocalDateTime.parse(date, formatter);
//        Comment com = new Comment();
//        Account acc = entityManager.getReference(Account.class, account_id);
//        Article art = entityManager.getReference(Article.class, article_id);
//        com.setAccount(acc);
//        com.setArticle(art);
//        com.setComment(comment);
//        com.setDate(datetime);
//        entityManager.persist(com);
//        commentRepository.save(com);
//        return "Saved";
//    }
    @Transactional
    @PostMapping(value="/form-data")
    public @ResponseBody String addCommentJson(@RequestParam(value="account_id") Long account_id, @RequestParam(value="article_id") Long article_id,
                                               @RequestParam(value="comment") String comment, @RequestParam(value="date") String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime datetime = LocalDateTime.parse(date, formatter);
        Comment com = new Comment();
        Account acc = entityManager.getReference(Account.class, account_id);
        Article art = entityManager.getReference(Article.class, article_id);
        com.setAccount(acc);
        com.setArticle(art);
        com.setComment(comment);
        com.setDate(datetime);
        entityManager.persist(com);
        commentRepository.save(com);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping(path="/find")
    public @ResponseBody Iterable<CommentDTO> getAllCommentsByArticleId(@RequestParam Long article_id) {
        return commentRepository.findCommentsByArticleId_Named(article_id);
    }


}
