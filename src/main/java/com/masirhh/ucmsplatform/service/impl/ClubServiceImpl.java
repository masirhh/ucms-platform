package com.masirhh.ucmsplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.masirhh.ucmsplatform.domain.Club;
import com.masirhh.ucmsplatform.domain.UserClub;
import com.masirhh.ucmsplatform.mapper.ClubMapper;
import com.masirhh.ucmsplatform.service.ClubService;
import com.masirhh.ucmsplatform.service.ClubTypeService;
import com.masirhh.ucmsplatform.service.UserClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClubServiceImpl extends ServiceImpl<ClubMapper, Club> implements ClubService {
    @Autowired
    UserClubService userClubService;
    @Autowired
    ClubTypeService clubTypeService;
    @Autowired
    ClubMapper clubMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeClubAndUser(Club club) {
        boolean b = this.removeById(club.getId());
        boolean b2 = userClubService.remove(new QueryWrapper<UserClub>().eq(UserClub.FIELD_CLUB_ID, club.getId()));
        return b == b2 ? true : false;
    }

    @Override
    public List<Club> listClub() {
        List<Club> clubs = clubMapper.listClub();
        return clubs;
    }
}
