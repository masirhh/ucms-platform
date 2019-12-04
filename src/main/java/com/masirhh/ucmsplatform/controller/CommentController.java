package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.extension.api.R;
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
    public R<Comment> insertComment(Comment comment) {
        boolean save = commentService.save(comment);
        return save ? R.ok(comment) : R.failed("Error!");
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
