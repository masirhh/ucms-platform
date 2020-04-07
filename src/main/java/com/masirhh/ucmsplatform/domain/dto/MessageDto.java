package com.masirhh.ucmsplatform.domain.dto;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

@Data
public class MessageDto {
    private Long id;
    private Long fromUserId;
    private Long toUserId;
    private String content;
    private Date createTime;
    private Integer checked;
    private Integer opreated;

    @Transient
    private String fromName;
    @Transient
    private String toName;
}
