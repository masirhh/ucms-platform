package com.masirhh.ucmsplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.masirhh.ucmsplatform.domain.User;
import com.masirhh.ucmsplatform.mapper.UserMapper;
import com.masirhh.ucmsplatform.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
