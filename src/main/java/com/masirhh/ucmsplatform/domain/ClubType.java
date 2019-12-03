package com.masirhh.ucmsplatform.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "up_club_type")
public class ClubType {
    public static final String FIELD_ID="id";
    public static final String FIELD_NAME="name";
    public static final String FIELD_DESCRIPTION="description";


    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private String description;
}
