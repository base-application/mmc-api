package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.user.dao.ReferralMapper;
import com.wanghuiwen.user.dao.ThankYouNoteMapper;
import com.wanghuiwen.user.dao.ThankYouNotePictureMapper;
import com.wanghuiwen.user.model.Referral;
import com.wanghuiwen.user.model.ThankYouNote;
import com.wanghuiwen.user.model.ThankYouNotePicture;
import com.wanghuiwen.user.service.ThankYouNoteService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.ThankYouAddVo;
import com.wanghuiwen.user.vo.ThankYouNoteVo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class ThankYouNoteServiceImpl extends AbstractService<ThankYouNote> implements ThankYouNoteService {
    @Resource
    private ThankYouNoteMapper thankYouNoteMapper;
    @Resource
    private ThankYouNotePictureMapper thankYouNotePictureMapper;
    @Resource
    private ReferralMapper referralMapper;

    @Override
    public List<ThankYouNoteVo> list(Map<String, Object> params) {
        return thankYouNoteMapper.list(params);
    }

    @Override
    public void add(ThankYouAddVo thankYouNote) {
        Referral referral = referralMapper.selectByPrimaryKey(thankYouNote.getReferralId());
        ThankYouNote note = new ThankYouNote();
        BeanUtils.copyProperties(thankYouNote,note);

        note.setReceivedUser(referral.getSendUser());
        note.setSendUser(thankYouNote.getSender());
        note.setValue(BigDecimal.valueOf(thankYouNote.getValue()));
        note.setSendTime(new Date().getTime());
        note.setReceivedTime(new Date().getTime());

        saveOrUpdate(note);
        thankYouNotePictureMapper.deleteByThank(note.getThankYouNoteId());
        if(!CollectionUtils.isEmpty(thankYouNote.getPicture())){
            List<ThankYouNotePicture> pictures = thankYouNote.getPicture().stream().map(p->{
                ThankYouNotePicture picture = new ThankYouNotePicture();
                picture.setNoteId(note.getThankYouNoteId());
                picture.setUrl(p.getUrl());
                return picture;
            }).collect(Collectors.toList());
            thankYouNotePictureMapper.insertListNoAuto(pictures);
        }

        referral.setThank(true);
        referralMapper.updateByPrimaryKeySelective(referral);
    }

    @Override
    public Long sum(Map<String, Object> params) {
        return thankYouNoteMapper.sum(params);
    }
}
