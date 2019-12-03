package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.masirhh.ucmsplatform.domain.Club;
import com.masirhh.ucmsplatform.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ucms/club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    /***
     * 查询社团列表
     * @return 社团列表
     */
    @GetMapping
    public R<List<Club>> getClub() {
        List list = clubService.listClub();
        return R.ok(list);
    }

    /***
     * 查询社团详情
     * @param id 社团id
     * @return 社团
     */
    @GetMapping("/{id}")
    public R<Club> getClubDetail(@PathVariable(value = "id") Long id) {
        Club byId = clubService.getById(id);
        return R.ok(byId);
    }

    /**
     * 新建社团
     *
     * @param club 社团
     * @return 新建的社团
     */
    @PostMapping
    public R<Club> insertClub(Club club) {
        boolean save = clubService.save(club);
        return save ? R.ok(club) : R.failed("Error!");
    }

    /**
     * 修改社团
     *
     * @param club 社团
     * @return 修改的社团
     */
    @PutMapping
    public R<Club> updateClub(Club club) {
        boolean update = clubService.updateById(club);
        return update ? R.ok(club) : R.failed("Error!");
    }

    /***
     * 删除社团
     * @param club 社团
     * @return 删除的社团
     */
    @DeleteMapping
    public R<Club> deleteClub(Club club) {
        boolean delete = clubService.removeClubAndUser(club);
        return delete ? R.ok(club) : R.failed("Error!");
    }

}
