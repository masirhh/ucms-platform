package com.masirhh.ucmsplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.masirhh.ucmsplatform.domain.Article;
import com.masirhh.ucmsplatform.domain.Comment;
import com.masirhh.ucmsplatform.mapper.ArticleMapper;
import com.masirhh.ucmsplatform.service.ArticleService;
import com.masirhh.ucmsplatform.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author masirhh
 * @Date 2019/12/3 17:13
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    CommentService commentService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeArticleAndComments(Article article) {
        boolean b = this.removeById(article.getId());
        boolean remove = commentService.remove(new QueryWrapper<Comment>().eq(Comment.FIELD_ARTICLE_ID, article.getId()));
        return remove == b ? true : false;
    }
}
