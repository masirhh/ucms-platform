package com.masirhh.ucmsplatform.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author masirhh
 * @Date 2019/12/3 17:04
 * @Version 1.0
 */
@Data
@TableName(value = "up_comment")
public class Comment {

    public static final String FIELD_ID="id";
    public static final String FIELD_CONTENT="content";
    public static final String FIELD_CREATE_TIME="create_time";
    public static final String FIELD_USER_ID="user_id";
    public static final String FIELD_ARTICLE_ID="article_id";

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String content;
    private Date createTime;
    private Long userId;
    private Long articleId;
}
