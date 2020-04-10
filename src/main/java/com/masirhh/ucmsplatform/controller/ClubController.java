package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masirhh.ucmsplatform.domain.Club;
import com.masirhh.ucmsplatform.domain.dto.ClubDto;
import com.masirhh.ucmsplatform.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ucms/club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    /***
     * 查询首页社团列表
     * @return 社团列表
     */
    @GetMapping
    public R<PageInfo<Club>> getClub(@RequestParam(value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List list = clubService.listClub();
        PageInfo<Club> pageInfo = new PageInfo(list);
        return R.ok(pageInfo);
    }

    @GetMapping("/getall")
    public R<List<Club>> getAllClub(){
        List<Club> list = clubService.list();
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
        List<Club> list = new ArrayList<>();
        if (cname != null) {
            list = clubService.list(new QueryWrapper<Club>().like(Club.FIELD_NAME, cname).eq(Club.FIELD_ENABLE_FLAG,1));
            PageInfo pageInfo = new PageInfo(list);
            return R.ok(pageInfo);
        }
        list = clubService.list(new QueryWrapper<Club>().eq(Club.FIELD_ENABLE_FLAG,1));
        PageInfo pageInfo = new PageInfo(list);
        return R.ok(pageInfo);
    }

    /**
     * 分页查询社团
     *
     * @param pageNum 当前页码
     * @param cname   社团名称
     * @param ctypeid 社团类型id（搜索参数）
     * @return
     */
    @GetMapping("/search-club-bytype")
    public R<PageInfo<Club>> getPageclubByType(Integer pageNum, String cname, Long ctypeid) {
        PageHelper.startPage(pageNum, 6);
        List<Club> list = new ArrayList();
        if (cname != null) {
            list = clubService.list(new QueryWrapper<Club>().like(Club.FIELD_NAME, cname).eq(Club.FIELD_TYPE, ctypeid).eq(Club.FIELD_ENABLE_FLAG,1));
            PageInfo pageInfo = new PageInfo(list);
            return R.ok(pageInfo);
        }
        list = clubService.list(new QueryWrapper<Club>().eq(Club.FIELD_TYPE, ctypeid).eq(Club.FIELD_ENABLE_FLAG,1));
        PageInfo pageInfo = new PageInfo(list);
        return R.ok(pageInfo);
    }

    /***
     * 查询社团详情
     * @param id 社团id
     * @return 社团
     */
    @GetMapping("/{id}")
    public R<ClubDto> getClubDetail(@PathVariable(value = "id") Long id) {
        Club byId = new Club();
        byId.setId(id);
        ClubDto clubDto = clubService.getClubDto(byId);
        return R.ok(clubDto);
    }


    /***
     * 查询社团详情
     * @param id 管理员id
     * @return 社团
     */
    @GetMapping("/get-club-by-admin")
    public R<Club> getClubByAdmin(@RequestParam(value = "id") Long id) {
        Club one = clubService.getOne(new QueryWrapper<Club>().eq(Club.FIELD_ADMIN, id));
        return R.ok(one);
    }

    /**
     * 新建社团
     *
     * @param club 社团
     * @return 新建的社团
     */
    @PostMapping
    public R<Club> insertClub(@RequestBody Club club) {
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
    public R<Club> updateClub(@RequestBody Club club) {
        boolean update = clubService.updateById(club);
        return update ? R.ok(club) : R.failed("Error!");
    }

    /***
     * 删除社团
     * @param club 社团
     * @return 删除的社团
     */
    @DeleteMapping
    public R<Club> deleteClub(@RequestBody Club club) {
        boolean delete = clubService.removeClubAndUser(club);
        return delete ? R.ok(club) : R.failed("Error!");
    }

}
