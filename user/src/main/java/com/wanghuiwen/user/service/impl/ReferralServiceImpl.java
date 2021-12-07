package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.ReferralMapper;
import com.wanghuiwen.user.dao.ReferralPictureMapper;
import com.wanghuiwen.user.model.Referral;
import com.wanghuiwen.user.model.ReferralPicture;
import com.wanghuiwen.user.service.ReferralService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.ReferralAddVo;
import com.wanghuiwen.user.vo.ReferralVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class ReferralServiceImpl extends AbstractService<Referral> implements ReferralService {
    @Resource
    private ReferralMapper referralMapper;
    @Resource
    private ReferralPictureMapper referralPictureMapper;

    @Override
    public List<ReferralVo> list(Map<String, Object> params) {
        return referralMapper.list(params);
    }

    @Override
    public void send(ReferralAddVo addVo, Long uid) {
        Referral referral = new Referral();
        BeanUtils.copyProperties(addVo,referral);
        referral.setSendUser(uid);
        referral.setSendTime(new Date().getTime());
        saveOrUpdate(referral);
        referralMapper.deleteByReferral(referral.getReferralId());


        List<ReferralPicture> pictureList =  addVo.getPicture().stream().map(imageVo -> {
            ReferralPicture picture =  new ReferralPicture();
            picture.setReferralId(referral.getReferralId());
            picture.setUrl(imageVo.getUrl());
            return picture;
        }).collect(Collectors.toList());

        referralPictureMapper.insertList(pictureList);
    }

    @Override
    public void received(Long referralId, Integer status, String failMessage) {
        Referral referral = findById(referralId);
        referral.setStatus(status);
        referral.setFailMessage(failMessage);
        referral.setReceivedTime(new Date().getTime());
        update(referral);
    }

    @Override
    public void remark(Long referralId, String remark) {
       Referral referral =  findById(referralId);
       referral.setRemark(remark);
       update(referral);
    }
}
