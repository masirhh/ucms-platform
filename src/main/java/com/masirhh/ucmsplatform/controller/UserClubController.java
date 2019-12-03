package com.masirhh.ucmsplatform.controller;

import com.masirhh.ucmsplatform.domain.UserClub;
import com.masirhh.ucmsplatform.service.UserClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ucms/join")
public class UserClubController {
    @Autowired
    UserClubService userClubService;

    /***
     * 查询列表
     * @return 用户-社团关系表所有内容
     */
    @GetMapping
    public ResponseEntity<List<UserClub>> getUserClub(){
        List<UserClub> list = userClubService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * 修改中间表
     * @param userClub 中间表
     * @return 修改的中间表
     */
    @PutMapping
    public ResponseEntity<UserClub> updateUserClub(UserClub userClub){
        boolean update = userClubService.updateById(userClub);
        return update?new ResponseEntity<>(userClub,HttpStatus.OK):new ResponseEntity<>(userClub,HttpStatus.REQUEST_TIMEOUT);
    }

    /**
     * 插入中间表
     * @param userClub 中间表
     * @return 插入的中间表
     */
    @PostMapping
    public ResponseEntity<UserClub> insertUserClub(UserClub userClub){
        boolean save = userClubService.saveUserAndClub(userClub);
        return save?new ResponseEntity<>(userClub,HttpStatus.OK):new ResponseEntity<>(userClub,HttpStatus.REQUEST_TIMEOUT);
    }
}
