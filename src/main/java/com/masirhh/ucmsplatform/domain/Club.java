package com.masirhh.ucmsplatform.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

@Data
@TableName(value = "up_club")
public class Club {
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_MEMBERS = "members";
    public static final String FIELD_CREATETIME = "createtime";
    public static final String FIELD_ENABLE_FLAG = "enable_flag";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_ADMIN = "admin";
    public static final String FIELD_AVATAR = "avatar";

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long members;
    private Date createtime;
    private Integer enableFlag;
    private String type;
    private Long admin;
    private Long avatar;

    @Transient
    private String typeName;
}
