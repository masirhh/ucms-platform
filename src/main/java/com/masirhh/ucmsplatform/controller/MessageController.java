package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.masirhh.ucmsplatform.domain.Message;
import com.masirhh.ucmsplatform.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author masirhh
 * @Date 2019/12/3 15:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/ucms/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping
    public R<List<Message>> getMessage() {
        List<Message> list = messageService.list();
        return R.ok(list);
    }

    @PostMapping
    public R<Message> insertMessage(Message message) {
        boolean save = messageService.save(message);
        return save ? R.ok(message) : R.failed("Error!");
    }

    @DeleteMapping
    public R<Message> deleteMessage(Message message) {
        boolean b = messageService.removeById(message.getId());
        return b ? R.ok(message) : R.failed("Error!");
    }
}
