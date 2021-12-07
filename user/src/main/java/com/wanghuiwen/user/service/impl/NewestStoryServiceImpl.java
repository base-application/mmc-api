package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.NewestStoryMapper;
import com.wanghuiwen.user.dao.NewsetStoryPictureMapper;
import com.wanghuiwen.user.dao.NewsetUserReadMapper;
import com.wanghuiwen.user.model.NewestStory;
import com.wanghuiwen.user.model.NewsetStoryPicture;
import com.wanghuiwen.user.model.NewsetUserRead;
import com.wanghuiwen.user.service.NewestStoryService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.NewestStoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class NewestStoryServiceImpl extends AbstractService<NewestStory> implements NewestStoryService {
    @Resource
    private NewestStoryMapper newestStoryMapper;
    @Resource
    private NewsetStoryPictureMapper newsetStoryPictureMapper;
    @Resource
    private NewsetUserReadMapper newsetUserReadMapper;

    @Override
    public void add(NewestStoryVo newestStoryVo) {
        NewestStory story = new NewestStory();
        BeanUtils.copyProperties(newestStoryVo,story);
        saveOrUpdate(story);

        newsetStoryPictureMapper.deleteByNew(story.getStoryId());

        if(!CollectionUtils.isEmpty(newestStoryVo.getPoster())){
            List<NewsetStoryPicture> pictureList =  newestStoryVo.getPoster().stream().map(imageVo -> {
                NewsetStoryPicture picture =  new NewsetStoryPicture();
                picture.setNewestStoryId(story.getStoryId());
                picture.setNewestStoryPicture(imageVo.getUrl());
                return picture;
            }).collect(Collectors.toList());
            newsetStoryPictureMapper.insertList(pictureList);
        }
    }

    @Override
    public List<NewestStoryVo> list(Map<String, Object> params) {
        return newestStoryMapper.list(params);
    }

    @Override
    public void detail(Long id, Long userId) {
        NewsetUserRead userRead = new NewsetUserRead();
        userRead.setNewestId(id);
        userRead.setUserId(userId);

        NewsetUserRead isRead = newsetUserReadMapper.selectOne(userRead);
        if(isRead == null){
            newsetUserReadMapper.insertSelective(userRead);
        }

    }
}
