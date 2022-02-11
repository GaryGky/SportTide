package com.hupu.service;

import com.hupu.pojo.Comment;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2020-05-16 17:16:02
 */
public interface CommentService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    Comment queryById(Integer commentId);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Comment> queryAllByLimit(int offset, int limit);
    
    List<Comment> queryAll(Comment comment);
    
    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    int insert(Comment comment);
    
    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    int update(Comment comment);
    
    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    int deleteById(Integer commentId);
    
    List<Comment> getCommentByTopic(Integer topicId,Integer topicType);
    
}