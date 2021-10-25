package com.wanghuiwen.user.service;
import com.wanghuiwen.user.model.Notification;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.vo.NotificationUserListVo;
import com.wanghuiwen.user.vo.NotificationVo;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/10/18.
 */
public interface NotificationService extends Service<Notification> {
    void add(NotificationVo notification);

    List<NotificationVo> list(Map<String, Object> params);

    List<NotificationUserListVo> userList(Map<String, Object> params);

    void read(Integer notificationId, Long id);

    void userDelete(Integer notificationId, Long id);
}
