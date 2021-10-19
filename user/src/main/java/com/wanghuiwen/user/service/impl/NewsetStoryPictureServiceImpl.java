package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.NewsetStoryPictureMapper;
import com.wanghuiwen.user.model.NewsetStoryPicture;
import com.wanghuiwen.user.service.NewsetStoryPictureService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class NewsetStoryPictureServiceImpl extends AbstractService<NewsetStoryPicture> implements NewsetStoryPictureService {
    @Resource
    private NewsetStoryPictureMapper newsetStoryPictureMapper;
}
