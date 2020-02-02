package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.masirhh.ucmsplatform.domain.Activity;
import com.masirhh.ucmsplatform.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ucms/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    /**
     * 获取所有活动列表
     *
     * @return 活动列表
     */
    @GetMapping
    public R<List<Activity>> getActivity() {
        List<Activity> list = activityService.list();
        return R.ok(list);
    }

    /**
     * 查询活动详情
     *
     * @param id 活动id
     * @return 活动详情
     */
    @GetMapping(value = "/{id}")
    public R<Activity> getActivityDetail(@PathVariable(value = "id") Long id) {
        Activity byId = activityService.getById(id);
        return R.ok(byId);
    }

    /**
     * 创建活动
     *
     * @param activity 活动
     * @return 活动
     */
    @PostMapping()
    public R<Activity> insertActivity(Activity activity) {
        boolean save = activityService.save(activity);
        return save ? R.ok(activity) : R.failed("Error!");
    }

    /**
     * 修改活动
     *
     * @param activity 活动
     * @return 活动
     */
    @PutMapping
    public R<Activity> upodateActivity(Activity activity) {
        boolean b = activityService.updateById(activity);
        return b ? R.ok(activity) : R.failed("Error!");
    }

    /**
     * 删除活动
     *
     * @param activity 活动
     * @return 活动
     */
    @DeleteMapping
    public R<Activity> deleteActivity(Activity activity) {
        boolean b = activityService.removeById(activity.getId());
        return b ? R.ok(activity) : R.failed("Error!");
    }
}
