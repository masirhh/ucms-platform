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

    User loginUser(User user);
}
