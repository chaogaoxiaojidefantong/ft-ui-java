package com.ftui.articleService.controller;

import com.ftui.articleService.service.ArticleService;
import com.ftui.common.pojo.Article;
import com.ftui.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping("/addArticle")
    public BiliResult addArticle(Article article){
          return articleService.addArticle(article);
    }
}
