package com.lemon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.ResponseResult;
import com.lemon.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 22:56:39
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize);
}

