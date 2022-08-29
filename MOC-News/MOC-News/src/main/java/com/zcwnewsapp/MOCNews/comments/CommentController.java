package com.zcwnewsapp.MOCNews.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping(path="/post")
    public @ResponseBody String addComment (@RequestParam String comment) {
        Comment c = new Comment();
        c.setComment(comment);
        return "Saved";
    }

}
