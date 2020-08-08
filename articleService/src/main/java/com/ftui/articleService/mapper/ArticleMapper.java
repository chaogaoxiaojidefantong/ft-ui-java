package com.ftui.articleService.mapper;

import com.ftui.common.pojo.Article;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ArticleMapper extends Mapper<Article> {
}
