package com.masirhh.ucmsplatform.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "up_message")
public class Message {
    public static final String FIELD_ID = "id";
    public static final String FIELD_FROM_USER_ID = "from_user_id";
    public static final String FIELD_TO_USER_ID = "to_user_id";
    public static final String FIELD_CONTENT = "content";
    public static final String FIELD_CREATE_TIME = "create_time";

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long fromUserId;
    private Long toUserId;
    private String content;
    private Date createTime;
    private Integer checked;
    private Integer opreated;
}
