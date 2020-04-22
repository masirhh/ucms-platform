package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masirhh.ucmsplatform.domain.Comment;
import com.masirhh.ucmsplatform.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author masirhh
 * @Date 2019/12/3 17:08
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/ucms/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    /**
     * 获取评论列表
     *
     * @return 评论列表
     */
    @GetMapping
    public R<List<Comment>> getComment() {
        List<Comment> list = commentService.list();
        return R.ok(list);
    }

    /***
     * 新建评论
     * @param comment 评论
     * @return 新建的评论
     */
    @PostMapping
    public R<Comment> insertComment(@RequestBody Comment comment) {
        boolean save = commentService.save(comment);
        return save ? R.ok(comment) : R.failed("Error!");
    }

    /***
     * 获得评论列表
     * @param articleId 文章id
     * @param pageNum 当前页
     * @return 评论列表
     */
    @GetMapping("/articleid")
    public R<PageInfo<Comment>> getCommentById(@RequestParam(value = "articleId") Integer articleId, @RequestParam(value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Comment> list = commentService.list(new QueryWrapper<Comment>().eq(Comment.FIELD_ARTICLE_ID, articleId).orderByDesc(Comment.FIELD_CREATE_TIME));
        PageInfo<Comment> commentPageInfo = new PageInfo<Comment>(list);
        return R.ok(commentPageInfo);
    }


    /***
     * 删除评论
     * @param comment 评论
     * @return 删除的评论
     */
    @DeleteMapping
    public R<Comment> deleteComment(Comment comment) {
        boolean b = commentService.removeById(comment.getId());
        return b ? R.ok(comment) : R.failed("Error!");
    }

}
