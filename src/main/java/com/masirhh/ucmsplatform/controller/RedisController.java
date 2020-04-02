package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.masirhh.ucmsplatform.tools.redisTools;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/ucms/redis")
public class RedisController {

    @GetMapping("/getUser")
    public R<String> ifLogin(String key) {
        String s = redisTools.redisGet(key);
        return s != null ? R.ok(s) : R.failed("Error");
    }
}
