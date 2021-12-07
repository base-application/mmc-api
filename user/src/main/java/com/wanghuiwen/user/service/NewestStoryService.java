package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.NewestStory;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.vo.NewestStoryVo;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface NewestStoryService extends Service<NewestStory> {
    void add(NewestStoryVo newestStoryVo);

    List<NewestStoryVo> list(Map<String, Object> params);

    void detail(Long id, Long userId);
}
