package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.masirhh.ucmsplatform.domain.ClubType;
import com.masirhh.ucmsplatform.service.ClubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ucms/type")
public class ClubTypeController {
    @Autowired
    ClubTypeService clubTypeService;

    @GetMapping
    public R<List<ClubType>> getClubType() {
        List<ClubType> list = clubTypeService.list();
        return R.ok(list);
    }

    @GetMapping("/{id}")
    public R<ClubType> getClubTypeDetail(@PathVariable(value = "id") Long id) {
        ClubType byId = clubTypeService.getById(id);
        return R.ok(byId);
    }

    @PostMapping
    public R<ClubType> insertClubType(ClubType clubType) {
        boolean save = clubTypeService.save(clubType);
        return save ? R.ok(clubType) : R.failed("Error!");
    }
}
