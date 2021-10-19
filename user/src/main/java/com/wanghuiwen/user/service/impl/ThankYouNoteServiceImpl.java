package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.ThankYouNoteMapper;
import com.wanghuiwen.user.model.ThankYouNote;
import com.wanghuiwen.user.service.ThankYouNoteService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class ThankYouNoteServiceImpl extends AbstractService<ThankYouNote> implements ThankYouNoteService {
    @Resource
    private ThankYouNoteMapper thankYouNoteMapper;
}
