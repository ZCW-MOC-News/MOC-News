package com.zcwnewsapp.MOCNews.comments;

import com.zcwnewsapp.MOCNews.article.Article;
import com.zcwnewsapp.MOCNews.user.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Controller
@RequestMapping(path="/likes")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path="/add")
    public @ResponseBody String addComment(@RequestParam Long account_id, @RequestParam Long article_id) {
        Comment comment = new Comment();
        Account acc = entityManager.getReference(Account.class, account_id);
        Article art = entityManager.getReference(Article.class, article_id);
        comment.setAccount(acc);
        comment.setArticle(art);
        entityManager.persist(comment);
        commentRepository.save(comment);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

}
