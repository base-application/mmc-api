package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.dao.*;
import com.wanghuiwen.user.model.CourseFile;
import com.wanghuiwen.user.model.CourseSchedule;
import com.wanghuiwen.user.model.CourseVideo;
import com.wanghuiwen.user.model.MasterCourse;
import com.wanghuiwen.user.service.MasterCourseService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.CourseAddVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by wanghuiwen on 2022/02/19.
 */
@Service
@Transactional
public class MasterCourseServiceImpl extends AbstractService<MasterCourse> implements MasterCourseService {
    @Resource
    private MasterCourseMapper masterCourseMapper;
    @Resource
    private CourseScheduleMapper courseScheduleMapper;
    @Resource
    private CourseFileMapper courseFileMapper;
    @Resource
    private CourseVideoMapper courseVideoMapper;

    @Override
    public void add(CourseAddVo masterCourse) {
        if(masterCourse.getId()!=null){
            update(masterCourse);
        }else {
            save(masterCourse);
        }
        if(!CollectionUtils.isEmpty(masterCourse.getFiles())){
            for (CourseFile file : masterCourse.getFiles()) {
                file.setCourseId(masterCourse.getId());
                if(file.getFileId()==null){
                    courseFileMapper.insert(file);
                }else {
                    courseFileMapper.updateByPrimaryKey(file);
                }
            }
        }
        if(!CollectionUtils.isEmpty(masterCourse.getVideos())){
            for (CourseVideo video : masterCourse.getVideos()) {
                video.setCourseId(masterCourse.getId());
                if(video.getVideoId()==null){
                    courseVideoMapper.insert(video);
                }else {
                    courseVideoMapper.updateByPrimaryKey(video);
                }
            }
        }
        if(!CollectionUtils.isEmpty(masterCourse.getSchedules())){
            for (CourseSchedule schedule : masterCourse.getSchedules()) {
                schedule.setCourseId(masterCourse.getId());
                if(schedule.getScheduleId()==null){
                   courseScheduleMapper.insert(schedule);
                }else {
                    courseScheduleMapper.updateByPrimaryKey(schedule);
                }
            }
        }
    }

    @Override
    public CourseAddVo detail(Integer id) {
        return masterCourseMapper.detail(id);
    }

    @Override
    public List<MasterCourse> list(Map<String, Object> params) {
        return masterCourseMapper.list(params);
    }
}
