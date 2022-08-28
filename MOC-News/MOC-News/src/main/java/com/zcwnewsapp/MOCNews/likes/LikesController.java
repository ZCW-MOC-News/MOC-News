package com.zcwnewsapp.MOCNews.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Controller
@RequestMapping(path="/likes")
public class LikesController {

    @Autowired
    private LikesRepository likesRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path="/add")
    public @ResponseBody Likes addLikes(@RequestParam Long accountId, Long articleId) {
        Likes like = new Likes(accountId, articleId);
        entityManager.persist(like);
      return likesRepository.save(like);
      // On front-end, set to not null
    }

//    @GetMapping(path="/retrieve_account")
//    public @ResponseBody Optional<Likes> retrieveAccount(@RequestParam Long id) {
//        return likesRepository.retrieveAccount(id);
//    }

}
