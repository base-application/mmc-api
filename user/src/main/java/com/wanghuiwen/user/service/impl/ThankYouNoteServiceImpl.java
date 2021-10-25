package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.ThankYouNoteMapper;
import com.wanghuiwen.user.dao.ThankYouNotePictureMapper;
import com.wanghuiwen.user.model.ThankYouNote;
import com.wanghuiwen.user.model.ThankYouNotePicture;
import com.wanghuiwen.user.service.ThankYouNoteService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.ThankYouAddVo;
import com.wanghuiwen.user.vo.ThankYouNoteVo;
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
public class ThankYouNoteServiceImpl extends AbstractService<ThankYouNote> implements ThankYouNoteService {
    @Resource
    private ThankYouNoteMapper thankYouNoteMapper;
    @Resource
    private ThankYouNotePictureMapper thankYouNotePictureMapper;

    @Override
    public List<ThankYouNoteVo> list(Map<String, Object> params) {
        return thankYouNoteMapper.list(params);
    }

    @Override
    public void add(ThankYouAddVo thankYouNote) {
        ThankYouNote note = new ThankYouNote();
        BeanUtils.copyProperties(thankYouNote,note);
        note.setSendTime(new Date().getTime());
        saveOrUpdate(note);
        thankYouNotePictureMapper.deleteByThank(note.getThankYouNoteId());
        List<ThankYouNotePicture> pictures = thankYouNote.getPicture().stream().map(p->{
           ThankYouNotePicture picture = new ThankYouNotePicture();
           picture.setNoteId(note.getThankYouNoteId());
           picture.setUrl(p.getUrl());
           return picture;
        }).collect(Collectors.toList());
        thankYouNotePictureMapper.insertListNoAuto(pictures);
    }
}
