package com.masirhh.ucmsplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.masirhh.ucmsplatform.domain.ClubType;
import com.masirhh.ucmsplatform.mapper.ClubTypeMapper;
import com.masirhh.ucmsplatform.service.ClubTypeService;
import org.springframework.stereotype.Service;

@Service
public class ClubTypeServiceImpl extends ServiceImpl<ClubTypeMapper, ClubType> implements ClubTypeService {
}
