package com.hupu.controller;


import com.hupu.pojo.Comment;
import com.hupu.service.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class ComController {
    @Autowired
    private CommentServiceImpl commentService;
    
    @RequestMapping("/addComment")
    public int addComment(@RequestBody Comment comment) {
        return commentService.insert(comment);
    }
    
    @RequestMapping("/getCommentByTopic")
    public List<Comment> getCommentByTopic(int topicId, int topicType) {
        return commentService.getCommentByTopic(topicId, topicType);
    }
    
    @RequestMapping("/getAllComment")
    public List<Comment> getAllComment(HttpServletRequest request) {
        List<Comment> comments = commentService.queryAllByLimit(0, 100);
        request.getSession().setAttribute("comMap", comments);
        return comments;
    }
    
    @RequestMapping("/delComment")
    public int delComment(int commentId){
        return commentService.deleteById(commentId);
    }
    
}
