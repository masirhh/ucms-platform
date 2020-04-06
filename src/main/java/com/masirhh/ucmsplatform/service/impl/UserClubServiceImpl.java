package com.masirhh.ucmsplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.masirhh.ucmsplatform.domain.Club;
import com.masirhh.ucmsplatform.domain.User;
import com.masirhh.ucmsplatform.domain.UserClub;
import com.masirhh.ucmsplatform.mapper.ClubMapper;
import com.masirhh.ucmsplatform.mapper.UserClubMapper;
import com.masirhh.ucmsplatform.service.ClubService;
import com.masirhh.ucmsplatform.service.UserClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserClubServiceImpl extends ServiceImpl<UserClubMapper, UserClub> implements UserClubService {
    @Autowired
    ClubService clubService;
    @Autowired
    ClubMapper clubMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveUserAndClub(UserClub userClub) {
        boolean b = this.save(userClub);
        boolean b1 = clubService.update(new UpdateWrapper<Club>().setSql("members=members+1 where id =" + userClub.getClubId()));
        return b == b1 ? true : false;
    }

    @Override
    public List<User> getUserByClubId(Long clubId) {
        List<User> users= clubMapper.getUserByClubId(clubId);
        return users;
    }
}
