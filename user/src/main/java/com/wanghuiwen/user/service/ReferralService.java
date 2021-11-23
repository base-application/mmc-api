package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.Referral;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.user.vo.ReferralAddVo;
import com.wanghuiwen.user.vo.ReferralVo;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface ReferralService extends Service<Referral> {
    List<ReferralVo> list(Map<String, Object> params);

    void send(ReferralAddVo addVo, Long uid);

    void received(Long referralId, Integer status, String failMessage);

    void remark(Long referralId, String remark);
}
