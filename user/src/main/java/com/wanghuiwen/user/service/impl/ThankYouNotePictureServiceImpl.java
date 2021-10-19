package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.ThankYouNotePictureMapper;
import com.wanghuiwen.user.model.ThankYouNotePicture;
import com.wanghuiwen.user.service.ThankYouNotePictureService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class ThankYouNotePictureServiceImpl extends AbstractService<ThankYouNotePicture> implements ThankYouNotePictureService {
    @Resource
    private ThankYouNotePictureMapper thankYouNotePictureMapper;
}
