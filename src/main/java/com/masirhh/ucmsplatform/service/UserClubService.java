package com.masirhh.ucmsplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.masirhh.ucmsplatform.domain.User;
import com.masirhh.ucmsplatform.domain.UserClub;

import java.util.List;

public interface UserClubService extends IService<UserClub> {
    boolean saveUserAndClub(UserClub userClub);

    List<User> getUserByClubId(Long clubId);
}
