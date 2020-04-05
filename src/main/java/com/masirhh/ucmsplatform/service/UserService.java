package com.masirhh.ucmsplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.masirhh.ucmsplatform.domain.User;

public interface UserService extends IService<User> {
    /**
     * 删除用户以及对应的文章和评论
     * @param user
     * @return 是否删除成功
     */
    boolean removeUser(User user);

    /**
     * 用户登陆 并将登陆信息存到redis中
     * @param user
     * @return
     */
    User loginUser(User user);

    User checkPwd(User user);
}
