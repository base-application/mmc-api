package com.wanghuiwen.user.service;
import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.user.model.ThankYouNote;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.vo.ThankYouAddVo;
import com.wanghuiwen.user.vo.ThankYouNoteVo;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface ThankYouNoteService extends Service<ThankYouNote> {
    List<ThankYouNoteVo> list(Map<String, Object> params);

    void add(ThankYouAddVo thankYouNote);

    Long sum(Map<String, Object> params);
}
