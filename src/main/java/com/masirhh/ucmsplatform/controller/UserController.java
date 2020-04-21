package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.masirhh.ucmsplatform.domain.User;
import com.masirhh.ucmsplatform.feign.UcmsSystemFeign;
import com.masirhh.ucmsplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ucms/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UcmsSystemFeign ucmsSystemFeign;


    /***
     * 用户登陆
     * @param user
     * @return 登陆的用户信息
     */
    @GetMapping()
    public R<User> loginUser( User user) {
        User one = userService.loginUser(user);
        return one != null ? R.ok(one) : R.failed("Error");
    }

    /***
     * 检查用户密码是否正确
     * @param user
     * @return 用户信息
     */
    @GetMapping("/checkpwd")
    public R<User> checkPwd(User user){
        User one = userService.checkPwd(user);
        return one != null ? R.ok(one) : R.failed("Error");
    }


    /***
     * 查询所有用户信息
     * @return 用户列表
     */
    @GetMapping("/getUser")
    public R<List<User>> getUser() {
        List<User> users = userService.list();
        return R.ok(users);
    }


    /***
     * 查询用户详情
     * @param id 用户id
     * @return 用户详情
     */
    @GetMapping("/{id}")
    public R<User> getUserDetail(@PathVariable(value = "id") Long id) {
        User user = (User) userService.getById(id);
        return R.ok(user);
    }

    /**
     * 创建用户
     *
     * @param user 用户
     * @return 创建的用户
     */
    @PostMapping()
    public R<User> insertUser(@RequestBody User user) {
        User one = userService.getOne(new QueryWrapper<>(user));
        boolean insert=false;
        if (one ==null){
            insert = userService.save(user);
        }
        return insert ? R.ok(user) : R.failed("Error!");
    }

    /***
     * 更新用户信息
     * @param user 用户
     * @return 更新的用户
     */
    @PutMapping()
    public R<User> updateUser(@RequestBody User user) {
        boolean b = userService.updateById(user);
        return b ? R.ok(user) : R.failed("Error!");
    }

    /**
     * 删除用户
     *
     * @param user 删除的用户
     * @return 删除的用户
     */
    @DeleteMapping()
    public R<User> deleteUser(@RequestBody User user) {
        boolean b = userService.removeUser(user);
        return b ? R.ok(user) : null;
    }

}
