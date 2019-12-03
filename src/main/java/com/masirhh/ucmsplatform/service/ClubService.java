package com.masirhh.ucmsplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.masirhh.ucmsplatform.domain.Club;

import java.util.List;

public interface ClubService extends IService<Club> {
    /**
     * 删除社团以及人员-社团关联表
     * @param club
     * @return
     */
    boolean removeClubAndUser(Club club);

    /***
     * 查询社团列表
     * @return 社团列表
     */
    List<Club> listClub();
}
