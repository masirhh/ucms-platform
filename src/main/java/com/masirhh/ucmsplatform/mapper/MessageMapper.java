package com.masirhh.ucmsplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.masirhh.ucmsplatform.domain.Message;
import com.masirhh.ucmsplatform.domain.dto.MessageDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper extends BaseMapper<Message> {
    List<MessageDto> list();

}
