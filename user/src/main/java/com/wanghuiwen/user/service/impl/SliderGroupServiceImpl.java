package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.SliderGroupMapper;
import com.wanghuiwen.user.model.SliderGroup;
import com.wanghuiwen.user.service.SliderGroupService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class SliderGroupServiceImpl extends AbstractService<SliderGroup> implements SliderGroupService {
    @Resource
    private SliderGroupMapper sliderGroupMapper;
}
