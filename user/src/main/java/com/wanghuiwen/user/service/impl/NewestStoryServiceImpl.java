package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.NewestStoryMapper;
import com.wanghuiwen.user.model.NewestStory;
import com.wanghuiwen.user.service.NewestStoryService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class NewestStoryServiceImpl extends AbstractService<NewestStory> implements NewestStoryService {
    @Resource
    private NewestStoryMapper newestStoryMapper;
}
