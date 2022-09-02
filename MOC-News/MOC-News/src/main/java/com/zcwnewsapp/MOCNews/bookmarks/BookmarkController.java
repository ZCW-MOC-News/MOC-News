package com.zcwnewsapp.MOCNews.bookmarks;

import com.zcwnewsapp.MOCNews.article.Article;
import com.zcwnewsapp.MOCNews.user.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Controller
@RequestMapping(path="/bookmark")
public class BookmarkController {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path="/add")
    public @ResponseBody String addBookmark(@RequestParam Long account_id, @RequestParam Long article_id) {
        Bookmark bookmark = new Bookmark();
        Account acc = entityManager.getReference(Account.class, account_id);
        Article art = entityManager.getReference(Article.class, article_id);
        bookmark.setAccount(acc);
        bookmark.setArticle(art);
        entityManager.persist(bookmark);
        bookmarkRepository.save(bookmark);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Bookmark> getAllBookmarks() {

        return bookmarkRepository.findAll();
    }

}