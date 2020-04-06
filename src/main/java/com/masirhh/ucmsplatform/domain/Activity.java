package com.masirhh.ucmsplatform.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "up_activity")
public class Activity {
    public static final String FIELD_ID="id";
    public static final String FIELD_NAME="name";
    public static final String FIELD_DESCRIPTION="description";
    public static final String FIELD_ORGANIZE_TIME="organize_time";
    public static final String FIELD_ORGANIZE_LOCATION="organize_location";
    public static final String FIELD_USER_ID="user_id";
    public static final String FIELD_CLUB_ID="club_id";

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Date organizeTime;
    private String organizeLocation;
    private Long userId;
    private Long clubId;
    private Long article;
    private Long Avatar;
}
