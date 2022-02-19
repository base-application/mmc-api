package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.MasterCourse;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.vo.AppMasterCourseItemVo;
import com.wanghuiwen.user.vo.CourseAddVo;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2022/02/19.
 */
public interface MasterCourseService extends Service<MasterCourse> {
    void add(CourseAddVo masterCourse);

    CourseAddVo detail(Integer id);

    List<MasterCourse> list(Map<String, Object> params);

    List<MasterCourse> listByCourse(Long courseId);
}
