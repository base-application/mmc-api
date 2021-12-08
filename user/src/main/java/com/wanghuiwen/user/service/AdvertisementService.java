package com.wanghuiwen.user.service;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.user.model.Advertisement;
import com.wanghuiwen.core.service.Service;

/**
 * Created by wanghuiwen on 2021/10/25.
 */
public interface AdvertisementService extends Service<Advertisement> {
    Advertisement pull();
}
