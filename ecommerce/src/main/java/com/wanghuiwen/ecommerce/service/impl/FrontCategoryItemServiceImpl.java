package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.FrontCategoryItemMapper;
import com.wanghuiwen.ecommerce.model.FrontCategoryItem;
import com.wanghuiwen.ecommerce.service.FrontCategoryItemService;
import com.wanghuiwen.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wanghuiwen on 2021/08/11.
 */
@Service
@Transactional
public class FrontCategoryItemServiceImpl extends AbstractService<FrontCategoryItem> implements FrontCategoryItemService {
    @Resource
    private FrontCategoryItemMapper frontCategoryItemMapper;
}
