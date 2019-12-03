package com.masirhh.ucmsplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.masirhh.ucmsplatform.domain.UserClub;

public interface UserClubService extends IService<UserClub> {
    boolean saveUserAndClub(UserClub userClub);
}
