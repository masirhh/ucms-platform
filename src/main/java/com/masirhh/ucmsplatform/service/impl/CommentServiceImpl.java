package com.masirhh.ucmsplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.masirhh.ucmsplatform.domain.Comment;
import com.masirhh.ucmsplatform.mapper.CommentMapper;
import com.masirhh.ucmsplatform.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * @Author masirhh
 * @Date 2019/12/3 17:08
 * @Version 1.0
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
