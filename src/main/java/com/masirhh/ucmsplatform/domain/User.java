package com.masirhh.ucmsplatform.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "up_user")
public class User {
    public static final String FIELD_ID="id";
    public static final String FIELD_NAME="name";
    public static final String FIELD_NICKNAME="nickname";
    public static final String FIELD_PASSWORD="password";
    public static final String FIELD_SEX="sex";
    public static final String FIELD_TELEPHONE="telephone";
    public static final String FIELD_EMAIL="email";
    public static final String FIELD_USER_TYPE="user_type";
    public static final String FIELD_AVATAR="avatar";
    public static final String FIELD_DESCRIPTION="description";

    @TableId(type = IdType.AUTO,value = "id")
    private Long id;
    private String name;
    private String nickname;
    private String password;
    private Integer sex;
    private String telephone;
    private String email;
    private Integer userType;
    private Long avatar;
    private String description;
}
