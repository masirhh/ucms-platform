package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.masirhh.ucmsplatform.domain.Article;
import com.masirhh.ucmsplatform.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author masirhh
 * @Date 2019/12/3 17:14
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/ucms/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping
    public R<List<Article>> getArticle() {
        List<Article> list = articleService.list();
        return R.ok(list);
    }

    @GetMapping("/{id}")
    public R<Article> getArticleDetail(@PathVariable(value = "id") Long id) {
        Article byId = articleService.getById(id);
        return R.ok(byId);
    }

    @PostMapping()
    public R<Article> insertArticle(Article article) {
        boolean save = articleService.save(article);
        return save ? R.ok(article) : R.failed("Error");
    }

    @PutMapping
    public R<Article> updateArticle(Article article) {
        boolean b = articleService.updateById(article);
        return b ? R.ok(article) : R.failed("Error!");
    }

    @DeleteMapping
    public R<Article> deleteArticle(Article article) {
        boolean b = articleService.removeById(article.getId());
        return b ? R.ok(article) : R.failed("Error!");
    }
}
