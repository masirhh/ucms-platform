package com.masirhh.ucmsplatform.controller;

import com.masirhh.ucmsplatform.domain.Club;
import com.masirhh.ucmsplatform.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Club>> getClub() {
        List list = clubService.listClub();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /***
     * 查询社团详情
     * @param id 社团id
     * @return 社团
     */
    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubDetail(@PathVariable(value = "id") Long id) {
        Club byId = clubService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    /**
     * 新建社团
     * @param club 社团
     * @return 新建的社团
     */
    @PostMapping
    public ResponseEntity<Club> insertClub(Club club) {
        boolean save = clubService.save(club);
        return save ? new ResponseEntity<>(club, HttpStatus.OK) : new ResponseEntity<>(club, HttpStatus.REQUEST_TIMEOUT);
    }

    /**
     * 修改社团
     * @param club 社团
     * @return 修改的社团
     */
    @PutMapping
    public ResponseEntity<Club> updateClub(Club club) {
        boolean update = clubService.updateById(club);
        return update ? new ResponseEntity<>(club, HttpStatus.OK) : new ResponseEntity<>(club, HttpStatus.REQUEST_TIMEOUT);
    }

    /***
     * 删除社团
     * @param club 社团
     * @return 删除的社团
     */
    @DeleteMapping
    public ResponseEntity<Club> deleteClub(Club club) {
        boolean delete = clubService.removeClubAndUser(club);
        return delete ? new ResponseEntity<>(club, HttpStatus.OK) : new ResponseEntity<>(club, HttpStatus.REQUEST_TIMEOUT);
    }

}
