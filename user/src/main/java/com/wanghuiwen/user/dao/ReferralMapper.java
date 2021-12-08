package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.Referral;
import com.wanghuiwen.user.vo.NewestStoryVo;
import com.wanghuiwen.user.vo.ReferralVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReferralMapper extends ApiMapper<Referral> {
    List<ReferralVo> list(@Param("params") Map<String, Object> params);

    void deleteByReferral(Long referralId);

    List<Referral> findByNoThank();
}