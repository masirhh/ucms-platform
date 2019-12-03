package com.masirhh.ucmsplatform.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName(value = "up_user_club")
public class UserClub {
    public static final String FIELD_ID="id";
    public static final String FIELD_USER_ID="user_id";
    public static final String FIELD_CLUB_ID="club_id";
    public static final String FIELD_JOINTIME="jointime";
    public static final String FIELD_QUITTIME="quittime";

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long clubId;
    private Date jointime;
    private Date quittime;
}
