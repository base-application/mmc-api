package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.ReferralPointLogMapper;
import com.wanghuiwen.user.model.ReferralPointLog;
import com.wanghuiwen.user.service.ReferralPointLogService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2022/06/14.
 */
@Service
@Transactional
public class ReferralPointLogServiceImpl extends AbstractService<ReferralPointLog> implements ReferralPointLogService {
    @Resource
    private ReferralPointLogMapper referralPointLogMapper;
}
