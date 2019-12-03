package com.masirhh.ucmsplatform.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author masirhh
 * @Date 2019/12/3 17:10
 * @Version 1.0
 */
@Data
@TableName(value = "up_article")
public class Article {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String content;
    private Long userId;
    private Long clubId;
    private Date createTime;
}
