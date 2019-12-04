package com.masirhh.ucmsplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.masirhh.ucmsplatform.domain.Article;

/**
 * @Author masirhh
 * @Date 2019/12/3 17:13
 * @Version 1.0
 */
public interface ArticleService extends IService<Article> {
    /***
     * 删除文章的同时删除对应文章的评论
     * @param article 文章
     * @return 是否删除成功
     */
    boolean removeArticleAndComments(Article article);
}
