package com.masirhh.ucmsplatform.controller;

import com.masirhh.ucmsplatform.domain.User;
import com.masirhh.ucmsplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ucms/user")
public class UserController {
    @Autowired
    UserService userService;

    /***
     * 查询所有用户信息
     * @return 用户列表
     */
    @GetMapping()
    public ResponseEntity<List<User>> getUser() {
        List<User> Users = userService.list();
        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    /***
     * 查询用户详情
     * @param id 用户id
     * @return 用户详情
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserDetail(@PathVariable(value = "id") Long id) {
        User user = (User) userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * 创建用户
     *
     * @param user 用户
     * @return 创建的用户
     */
    @PostMapping()
    public ResponseEntity<User> insertUser(User user) {
        boolean insert = userService.save(user);
        return insert ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(user, HttpStatus.REQUEST_TIMEOUT);
    }

    /***
     * 更新用户信息
     * @param user 用户
     * @return 更新的用户
     */
    @PutMapping()
    public ResponseEntity<User> updateUser(User user) {
        userService.updateById(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * 删除用户
     *
     * @param user 删除的用户
     * @return 删除的用户
     */
    @DeleteMapping()
    public ResponseEntity<User> deleteUser(User user) {
        userService.removeById(user.getId());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
