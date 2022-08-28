//package com.zcwnewsapp.MOCNews.likes;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@Controller
//@RequestMapping(path="/likes")
//public class LikesController {
//
//    @Autowired
//    private LikesRepository likesRepository;
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Transactional
//    @PostMapping(path="/add")
//    public @ResponseBody String addLikes(@RequestParam String likes) {
//        Likes like = new Likes();
////        like.setLikes(likes);
//        entityManager.persist(like);
//        likesRepository.save(like);
//        return "Saved";
//    }
//
////    @GetMapping(path="/retrieve_account")
////    public @ResponseBody Optional<Likes> retrieveAccount(@RequestParam Long id) {
////        return likesRepository.retrieveAccount(id);
////    }
//
//}
