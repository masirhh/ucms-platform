package com.masirhh.ucmsplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.masirhh.ucmsplatform.domain.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubMapper extends BaseMapper<Club> {
    List<Club> listClub();
}
