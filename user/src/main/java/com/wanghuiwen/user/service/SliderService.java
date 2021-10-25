package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.Slider;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.vo.SliderVo;

import java.util.List;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface SliderService extends Service<Slider> {
    void add(SliderVo slider);

    List<SliderVo> list();

    List<SliderVo> userList(Long id);
}
