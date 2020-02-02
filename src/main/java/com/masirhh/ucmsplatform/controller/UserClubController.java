package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.masirhh.ucmsplatform.domain.UserClub;
import com.masirhh.ucmsplatform.service.UserClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("ucms/join")
public class UserClubController {
    @Autowired
    UserClubService userClubService;

    /***
     * 查询列表
     * @return 用户-社团关系表所有内容
     */
    @GetMapping
    public R<List<UserClub>> getUserClub() {
        List<UserClub> list = userClubService.list();
        return R.ok(list);
    }

    /**
     * 修改中间表
     *
     * @param userClub 中间表
     * @return 修改的中间表
     */
    @PutMapping
    public R<UserClub> updateUserClub(UserClub userClub) {
        boolean update = userClubService.updateById(userClub);
        return update ? R.ok(userClub) : R.failed("Error");
    }

    /**
     * 插入中间表
     *
     * @param userClub 中间表
     * @return 插入的中间表
     */
    @PostMapping
    public R<UserClub> insertUserClub(UserClub userClub) {
        boolean save = userClubService.saveUserAndClub(userClub);
        return save ? R.ok(userClub) : R.failed("Error");
    }
}
