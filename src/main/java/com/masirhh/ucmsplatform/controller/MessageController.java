package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
@CrossOrigin
@RequestMapping("/ucms/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    /***
     * 获取消息列表
     * @return 消息列表
     */
    @GetMapping
    public R<List<Message>> getMessage() {
        List<Message> list = messageService.list();
        return R.ok(list);
    }

    /***
     * 获取我的消息列表
     * @return
     */
    @GetMapping("/mymessage")
    public R<PageInfo<Message> > getMyMessage(Message message,@RequestParam(value = "pageNum")Integer pageNum) {
        PageHelper.startPage(pageNum,4);
        List<Message> list = messageService.list(new QueryWrapper<>(message));
        PageInfo<Message> messagePageInfo = new PageInfo(list);
        return R.ok(messagePageInfo);
    }

    /***
     * 新建消息
     * @param message 消息
     * @return 新建的消息
     */
    @PostMapping
    public R<Boolean> insertMessage(@RequestBody Message message) {
        boolean save = messageService.save(message);
        return save ? R.ok(save) : R.failed("Error!");
    }

    /**
     * 删除消息
     *
     * @param message 消息
     * @return 删除的消息
     */
    @DeleteMapping
    public R<Message> deleteMessage(@RequestBody Message message) {
        boolean b = messageService.removeById(message.getId());
        return b ? R.ok(message) : R.failed("Error!");
    }

    @PutMapping
    public R<Message> updateMessage(@RequestBody Message message){
        boolean b = messageService.updateById(message);
        return b ? R.ok(message) : R.failed("Error!");
    }
}
