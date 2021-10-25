package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.user.dao.AdvertisementMapper;
import com.wanghuiwen.user.model.Advertisement;
import com.wanghuiwen.user.service.AdvertisementService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/25.
 */
@Service
@Transactional
public class AdvertisementServiceImpl extends AbstractService<Advertisement> implements AdvertisementService {
    @Resource
    private AdvertisementMapper advertisementMapper;

    @Override
    public Advertisement pull(AuthUser authUser) {

        return advertisementMapper.pull(authUser.getId());
    }
}
