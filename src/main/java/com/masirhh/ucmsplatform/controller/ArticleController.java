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
@CrossOrigin
@RequestMapping(value = "/ucms/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    /***
     * 获取文章列表
     * @return 文章列表
     */
    @GetMapping
    public R<List<Article>> getArticle() {
        List<Article> list = articleService.list();
        return R.ok(list);
    }

    /***
     * 获取文章详情
     * @param id 文章id
     * @return 文章
     */
    @GetMapping("/{id}")
    public R<Article> getArticleDetail(@PathVariable(value = "id") Long id) {
        Article byId = articleService.getById(id);
        return R.ok(byId);
    }

    /**
     * 新建文章
     *
     * @param article 文章
     * @return 文章
     */
    @PostMapping()
    public R<Article> insertArticle(@RequestBody Article article) {
        boolean save = articleService.save(article);
        return save ? R.ok(article) : R.failed("Error");
    }

    /***
     * 更新文章
     * @param article 文章
     * @return 文章
     */
    @PutMapping
    public R<Article> updateArticle(Article article) {
        boolean b = articleService.updateById(article);
        return b ? R.ok(article) : R.failed("Error!");
    }

    /**
     * 删除文章
     *
     * @param article 文章
     * @return 删除的文章
     */
    @DeleteMapping
    public R<Article> deleteArticle(Article article) {
        boolean b = articleService.removeArticleAndComments(article);
        return b ? R.ok(article) : R.failed("Error!");
    }
}
