package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masirhh.ucmsplatform.domain.User;
import com.masirhh.ucmsplatform.domain.UserClub;
import com.masirhh.ucmsplatform.service.UserClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    /***
     * 查询加入社团的成员
     * @param clubId 社团id
     * @return
     */
    @GetMapping("get-user-by-club")
    public R<List<User>> getUserByClub(@RequestParam(value = "clubId")Long clubId){
        List<User> users=userClubService.getUserByClubId(clubId);
        return R.ok(users);
    }


    /***
     * 查询我加入的社团
     * @return 用户-社团关系表所有内容
     */
    @GetMapping("/myclub")
    public R<PageInfo<UserClub>> getMyClub(@RequestParam(value = "userId") Long userId, @RequestParam(value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<UserClub> list = userClubService.list(new QueryWrapper<UserClub>().eq(UserClub.FIELD_USER_ID, userId));
        PageInfo<UserClub> userClubPageInfo = new PageInfo<>(list);
        return R.ok(userClubPageInfo);
    }

    /**
     * 修改中间表
     *
     * @param userClub 中间表
     * @return 修改的中间表
     */
    @PutMapping
    public R<UserClub> updateUserClub(@RequestBody UserClub userClub) {
        System.out.println(userClub);
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
    public R<UserClub> insertUserClub(@RequestBody UserClub userClub) {
        boolean save = userClubService.saveUserAndClub(userClub);
        return save ? R.ok(userClub) : R.failed("Error");
    }

    /***
     * 删除中间表
     * @param userClub 要删除的实体
     * @return 是否删除成功
     */
    @DeleteMapping()
    public R<Boolean> deleteUserClub(@RequestBody UserClub userClub){
        boolean remove = userClubService.remove(new QueryWrapper<UserClub>().eq(UserClub.FIELD_USER_ID, userClub.getUserId()).eq(UserClub.FIELD_CLUB_ID, userClub.getClubId()));
        return R.ok(remove);
    }
}
