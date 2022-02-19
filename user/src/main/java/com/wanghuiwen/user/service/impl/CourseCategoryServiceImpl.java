package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.dao.CourseCategoryMapper;
import com.wanghuiwen.user.model.CourseCategory;
import com.wanghuiwen.user.service.CourseCategoryService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.AppMasterCourseItemVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by wanghuiwen on 2022/02/19.
 */
@Service
@Transactional
public class CourseCategoryServiceImpl extends AbstractService<CourseCategory> implements CourseCategoryService {
    @Resource
    private CourseCategoryMapper courseCategoryMapper;

    @Override
    public List<CourseCategory> list() {

        return courseCategoryMapper.list();
    }

    @Override
    public List<AppMasterCourseItemVo> listByCourse() {

        return courseCategoryMapper.listByCourse();
    }
}
