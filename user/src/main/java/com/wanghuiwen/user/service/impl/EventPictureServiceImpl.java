package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.EventPictureMapper;
import com.wanghuiwen.user.model.EventPicture;
import com.wanghuiwen.user.service.EventPictureService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class EventPictureServiceImpl extends AbstractService<EventPicture> implements EventPictureService {
    @Resource
    private EventPictureMapper eventPictureMapper;
}
