package com.masirhh.ucmsplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.masirhh.ucmsplatform.domain.Activity;
import com.masirhh.ucmsplatform.domain.Club;
import com.masirhh.ucmsplatform.domain.UserClub;
import com.masirhh.ucmsplatform.domain.dto.ClubDto;
import com.masirhh.ucmsplatform.mapper.ClubMapper;
import com.masirhh.ucmsplatform.service.ActivityService;
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
    ActivityService activityService;
    @Autowired
    ClubMapper clubMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeClubAndUser(Club club) {
        boolean b = this.removeById(club.getId());
        boolean b1 = userClubService.remove(new QueryWrapper<UserClub>().eq(UserClub.FIELD_CLUB_ID, club.getId()));
        boolean b2 = activityService.remove(new QueryWrapper<Activity>().eq(Activity.FIELD_CLUB_ID, club.getId()));
        return b == b1 == b2 ? true : false;
    }

    @Override
    public List<Club> listClub() {
        List<Club> clubs = clubMapper.listClub();
        return clubs;
    }

    @Override
    public ClubDto getClubDto(Club club) {
        ClubDto clubDto = clubMapper.getClubDto(club);
        return clubDto;
    }
}
