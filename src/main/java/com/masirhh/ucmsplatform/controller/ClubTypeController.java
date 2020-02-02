package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.masirhh.ucmsplatform.domain.ClubType;
import com.masirhh.ucmsplatform.service.ClubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/ucms/type")
public class ClubTypeController {
    @Autowired
    ClubTypeService clubTypeService;

    /**
     * 获取社团类型列表
     *
     * @return 社团类型列表
     */
    @GetMapping
    public R<List<ClubType>> getClubType() {
        List<ClubType> list = clubTypeService.list();
        return R.ok(list);
    }

    /**
     * 根据id获取社团类型
     *
     * @param id 社团类型id
     * @return 社团类型单条记录
     */
    @GetMapping("/{id}")
    public R<ClubType> getClubTypeDetail(@PathVariable(value = "id") Long id) {
        ClubType byId = clubTypeService.getById(id);
        return R.ok(byId);
    }

    /**
     * 新建社团类型
     *
     * @param clubType 社团类型
     * @return 新建的社团类型
     */
    @PostMapping
    public R<ClubType> insertClubType(ClubType clubType) {
        boolean save = clubTypeService.save(clubType);
        return save ? R.ok(clubType) : R.failed("Error!");
    }
}
