package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.MediaResourceMapper;
import com.wanghuiwen.user.model.MediaResource;
import com.wanghuiwen.user.service.MediaResourceService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/08/13.
 */
@Service
@Transactional
public class MediaResourceServiceImpl extends AbstractService<MediaResource> implements MediaResourceService {
    @Resource
    private MediaResourceMapper mediaResourceMapper;
}
