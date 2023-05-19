package com.lemon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.ResponseResult;
import com.lemon.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 17:57:43
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

