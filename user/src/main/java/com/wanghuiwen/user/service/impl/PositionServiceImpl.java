package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.PositionMapper;
import com.wanghuiwen.user.model.Position;
import com.wanghuiwen.user.service.PositionService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/21.
 */
@Service
@Transactional
public class PositionServiceImpl extends AbstractService<Position> implements PositionService {
    @Resource
    private PositionMapper positionMapper;
}
