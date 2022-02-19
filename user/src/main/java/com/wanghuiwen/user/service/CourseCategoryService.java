package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.CourseCategory;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.vo.AppMasterCourseItemVo;

import java.util.List;

/**
 * Created by wanghuiwen on 2022/02/19.
 */
public interface CourseCategoryService extends Service<CourseCategory> {
    List<CourseCategory> list();

    List<AppMasterCourseItemVo> listByCourse();
}
