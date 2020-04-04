package com.masirhh.ucmsplatform.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

@Data
public class ClubDto {
    private Long id;
    private String name;
    private String description;
    private Long members;
    private Date createTime;
    private Integer enableFlag;
    private String type;
    private Long admin;
    private Long avatar;

    @Transient
    private String typeName;

    @Transient
    private String managerName;

}
