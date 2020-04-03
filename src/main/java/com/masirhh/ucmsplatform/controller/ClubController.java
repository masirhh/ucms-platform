package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masirhh.ucmsplatform.domain.Club;
import com.masirhh.ucmsplatform.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
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
     * 分页搜索社团
     * @param pageNum 当前页码
     * @param cname 社团名称（搜索参数）
     * @return
     */
    @GetMapping("/search-club")
    public R<PageInfo<Club>> getPageclubByName(Integer pageNum, String cname) {
        PageHelper.startPage(pageNum, 6);
        List list = new ArrayList();
        if (cname != null) {
            list = clubService.list(new QueryWrapper<Club>().like(Club.FIELD_NAME, cname));
            PageInfo pageInfo = new PageInfo(list);
            return R.ok(pageInfo);
        }
        list = clubService.list();
        PageInfo pageInfo = new PageInfo(list);
        return R.ok(pageInfo);
    }

    /**
     * 分页查询社团
     * @param pageNum 当前页码
     * @param cname 社团名称
     * @param ctypeid 社团类型id（搜索参数）
     * @return
     */
    @GetMapping("/search-club-bytype")
    public R<PageInfo<Club>> getPageclubByType(Integer pageNum, String cname, Long ctypeid) {
        PageHelper.startPage(pageNum, 6);
        List list = new ArrayList();
        if (cname != null) {
            list = clubService.list(new QueryWrapper<Club>().like(Club.FIELD_NAME, cname).eq(Club.FIELD_TYPE, ctypeid));
            PageInfo pageInfo = new PageInfo(list);
            return R.ok(pageInfo);
        }
        list = clubService.list(new QueryWrapper<Club>().eq(Club.FIELD_TYPE, ctypeid));
        PageInfo pageInfo = new PageInfo(list);
        return R.ok(pageInfo);
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
