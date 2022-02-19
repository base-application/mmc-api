package com.wanghuiwen.user.vo;

import com.wanghuiwen.user.model.CourseFile;
import com.wanghuiwen.user.model.CourseSchedule;
import com.wanghuiwen.user.model.CourseVideo;

import java.util.List;

public class CourseAddVo extends CourseItemVo {
    private List<CourseVideo> videos;
    private List<CourseFile> files;
    private List<CourseSchedule> schedules;

    public List<CourseVideo> getVideos() {
        return videos;
    }

    public void setVideos(List<CourseVideo> videos) {
        this.videos = videos;
    }

    public List<CourseFile> getFiles() {
        return files;
    }

    public void setFiles(List<CourseFile> files) {
        this.files = files;
    }

    public List<CourseSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<CourseSchedule> schedules) {
        this.schedules = schedules;
    }
}
