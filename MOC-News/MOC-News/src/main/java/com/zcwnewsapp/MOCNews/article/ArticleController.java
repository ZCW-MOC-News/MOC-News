package com.zcwnewsapp.MOCNews.article;

import com.zcwnewsapp.MOCNews.user.Account;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping(path="/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping(path="/post")
    public @ResponseBody String postArticle (@RequestParam String author
            , @RequestParam String title, @RequestParam String source, @RequestParam String description, @RequestParam String content, @RequestParam String date) {

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
        articleRepository.save(a);

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Article> getAllArticles() {
        //     This returns a JSON or XML with the users
        return articleRepository.findAll();
    }





}
