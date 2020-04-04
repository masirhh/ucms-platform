package com.masirhh.ucmsplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.masirhh.ucmsplatform.domain.Club;
import com.masirhh.ucmsplatform.domain.dto.ClubDto;

import java.util.List;

public interface ClubService extends IService<Club> {
    /**
     * 删除社团以及对应的社团成员
     * @param club
     * @return 是否删除成功
     */
    boolean removeClubAndUser(Club club);

    /***
     * 查询社团列表
     * @return 社团列表
     */
    List<Club> listClub();


    /***
     * 查询社团详细信息
     * @param club
     * @return ClubDto
     */
    ClubDto getClubDto(Club club);
}
