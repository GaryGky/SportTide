package com.hupu.service.Impl;


import com.hupu.dao.CommentDao;
import com.hupu.pojo.Comment;
import com.hupu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2020-05-16 17:16:02
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    @Qualifier("commentDao")
    private CommentDao commentDao;
    
    @Override
    public Comment queryById(Integer commentId) {
        return commentDao.queryById(commentId);
    }
    
    @Override
    public List<Comment> queryAllByLimit(int offset, int limit) {
        return commentDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<Comment> queryAll(Comment comment) {
        return commentDao.queryAll(comment);
    }
    
    @Override
    public int insert(Comment comment) {
        return commentDao.insert(comment);
    }
    
    @Override
    public int update(Comment comment) {
        return commentDao.update(comment);
    }
    
    @Override
    public int deleteById(Integer commentId) {
        return commentDao.deleteById(commentId);
    }
    
    @Override
    public List<Comment> getCommentByTopic(Integer topicId, Integer topicType) {
        return commentDao.getCommentByTopic(topicId,topicType);
    }
}