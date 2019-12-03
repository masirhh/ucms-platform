package com.masirhh.ucmsplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.masirhh.ucmsplatform.domain.Article;
import com.masirhh.ucmsplatform.mapper.ArticleMapper;
import com.masirhh.ucmsplatform.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @Author masirhh
 * @Date 2019/12/3 17:13
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
