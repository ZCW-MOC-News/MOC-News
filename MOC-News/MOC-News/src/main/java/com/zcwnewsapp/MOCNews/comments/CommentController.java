package com.zcwnewsapp.MOCNews.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

}
