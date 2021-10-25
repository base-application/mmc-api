package com.wanghuiwen.user.dao;

import com.wanghuiwen.core.ApiMapper;
import com.wanghuiwen.user.model.ThankYouNote;
import com.wanghuiwen.user.vo.ThankYouNoteVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ThankYouNoteMapper extends ApiMapper<ThankYouNote> {
    List<ThankYouNoteVo> list(@Param("params") Map<String, Object> params);
}