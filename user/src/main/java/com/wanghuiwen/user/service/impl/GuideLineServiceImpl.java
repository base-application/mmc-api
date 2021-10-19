package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.GuideLineMapper;
import com.wanghuiwen.user.model.GuideLine;
import com.wanghuiwen.user.service.GuideLineService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class GuideLineServiceImpl extends AbstractService<GuideLine> implements GuideLineService {
    @Resource
    private GuideLineMapper guideLineMapper;
}
