package com.wanghuiwen.base.service.impl;

import com.wanghuiwen.base.dao.UserGradeMapper;
import com.wanghuiwen.base.model.UserGrade;
import com.wanghuiwen.base.service.UserGradeService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/07/13.
 */
@Service
@Transactional
public class UserGradeServiceImpl extends AbstractService<UserGrade> implements UserGradeService {
    @Resource
    private UserGradeMapper userGradeMapper;
}
