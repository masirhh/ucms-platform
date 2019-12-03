package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.masirhh.ucmsplatform.domain.Activity;
import com.masirhh.ucmsplatform.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ucms/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @GetMapping
    public R<List<Activity>> getActivity() {
        List<Activity> list = activityService.list();
        return R.ok(list);
    }

    @GetMapping(value = "/{id}")
    public R<Activity> getActivityDetail(@PathVariable(value = "id")Long id){
        Activity byId = activityService.getById(id);
        return R.ok(byId);
    }
}
