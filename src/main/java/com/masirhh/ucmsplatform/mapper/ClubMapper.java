package com.masirhh.ucmsplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.masirhh.ucmsplatform.domain.Club;

import java.util.List;

public interface ClubMapper extends BaseMapper<Club> {
    List<Club> listClub();
}
