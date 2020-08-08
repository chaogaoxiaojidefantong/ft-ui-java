package com.ftui.articleService.service;

import com.ftui.articleService.mapper.ArticleMapper;
import com.ftui.common.pojo.Article;
import com.ftui.common.vo.BiliResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    public static Logger logger = LoggerFactory.getLogger(ArticleService.class);
    public BiliResult addArticle(Article article){
            try {
                articleMapper.insert(article);
                return BiliResult.oK();
            }catch (Exception exception){
                logger.error("插入文章失败"+exception.getMessage());
                return BiliResult.build(500,"插入文章失败");
            }
    }
}
