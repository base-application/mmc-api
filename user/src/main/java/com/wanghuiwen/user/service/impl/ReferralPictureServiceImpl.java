package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.ReferralPictureMapper;
import com.wanghuiwen.user.model.ReferralPicture;
import com.wanghuiwen.user.service.ReferralPictureService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class ReferralPictureServiceImpl extends AbstractService<ReferralPicture> implements ReferralPictureService {
    @Resource
    private ReferralPictureMapper referralPictureMapper;
}
