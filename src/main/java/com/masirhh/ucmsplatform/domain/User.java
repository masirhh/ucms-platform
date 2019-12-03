package com.masirhh.ucmsplatform.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "up_user")
public class User {
    @TableId(type = IdType.AUTO,value = "id")
    private Long id;
    private String name;
    private String nickname;
    private String password;
    private Integer sex;
    private String telephone;
    private String email;
    private Integer usertype;
    private Long avatar;
    private String description;
}
