package com.masirhh.ucmsplatform.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
     * 获取首页活动列表
     *
     * @return 活动列表
     */
    @GetMapping
    public R<PageInfo<Activity>> getActivity(Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Activity> list = activityService.list(new QueryWrapper<Activity>().orderByDesc(Activity.FIELD_ORGANIZE_TIME));
        PageInfo pageActivity = new PageInfo(list);
        return R.ok(pageActivity);
    }

    /**
     * 获取所有活动列表
     *
     * @return 活动列表
     */
    @GetMapping("/getallacts")
    public R<List<Activity>> getAllAct() {
        List<Activity> list = activityService.list();
        return R.ok(list);
    }

    /***
     * 获取首页活动
     * @param pageNum
     * @return
     */
    @GetMapping("/homeact")
    public R<PageInfo<Activity>> getHomeAct(@RequestParam(value = "pageNum")Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Activity> list = activityService.list();
        PageInfo pageInfo = new PageInfo(list);
        return R.ok(pageInfo);
    }

    /***
     * 分页查询活动
     * @param pageNum 当前页码
     * @param actName 活动名称（搜索参数）
     * @return
     */

    @GetMapping("/searchact")
    public R<PageInfo<Activity>> searchActivity(Integer pageNum, String actName) {
        PageHelper.startPage(pageNum, 5);
        List<Activity> list = activityService.list(new QueryWrapper<Activity>().like(Activity.FIELD_NAME, actName).orderByDesc(Activity.FIELD_ORGANIZE_TIME));
        PageInfo pageActivity = new PageInfo(list);
        return R.ok(pageActivity);
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

    /***
     * 查询社团发布的活动
     * @param clubId
     * @return
     */
    @GetMapping("/myactivities")
    public R<List<Activity>> getMyAct(@RequestParam(value = "clubId") Long clubId) {
        List<Activity> list = activityService.list(new QueryWrapper<Activity>().eq(Activity.FIELD_CLUB_ID, clubId));
        return R.ok(list);
    }


    /**
     * 创建活动
     *
     * @param activity 活动
     * @return 活动
     */
    @PostMapping()
    public R<Boolean> insertActivity(@RequestBody Activity activity) {
        boolean save = activityService.save(activity);
        return R.ok(save);
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
    public R<Boolean> deleteActivity(@RequestBody Activity activity) {
        boolean b = activityService.removeById(activity.getId());
        return R.ok(b);
    }
}
