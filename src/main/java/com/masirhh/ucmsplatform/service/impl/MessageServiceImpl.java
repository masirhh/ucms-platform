package com.masirhh.ucmsplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.masirhh.ucmsplatform.domain.Message;
import com.masirhh.ucmsplatform.mapper.MessageMapper;
import com.masirhh.ucmsplatform.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
}
