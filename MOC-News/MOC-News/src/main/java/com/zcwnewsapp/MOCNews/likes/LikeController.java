package com.zcwnewsapp.MOCNews.likes;

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
public class LikeController {

    @Autowired
    private LikeRepository likesRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path="/add")
    public @ResponseBody String addLikes(@RequestParam Long account_id, @RequestParam Long article_id) {
        Like like = new Like();
        Account acc = entityManager.getReference(Account.class, account_id);
        Article art = entityManager.getReference(Article.class, article_id);
        like.setAccount(acc);
        like.setArticle(art);
        entityManager.persist(like);
        likesRepository.save(like);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Like> getAllLikes() {
        return likesRepository.findAll();
    }

}
