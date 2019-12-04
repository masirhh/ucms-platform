package com.masirhh.ucmsplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.masirhh.ucmsplatform.domain.Article;
import com.masirhh.ucmsplatform.domain.Comment;
import com.masirhh.ucmsplatform.domain.User;
import com.masirhh.ucmsplatform.mapper.UserMapper;
import com.masirhh.ucmsplatform.service.ArticleService;
import com.masirhh.ucmsplatform.service.CommentService;
import com.masirhh.ucmsplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeUser(User user) {
        boolean b = this.removeById(user.getId());
        boolean b1 = articleService.remove(new QueryWrapper<Article>().eq(Article.FIELD_USER_ID, user.getId()));
        boolean b2 = commentService.remove(new QueryWrapper<Comment>().eq(Comment.FIELD_USER_ID, user.getId()));
        return b == b1 == b2 ? true : false;
    }
}
