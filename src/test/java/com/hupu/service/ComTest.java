package com.hupu.service;


import com.alibaba.fastjson.JSON;
import com.hupu.config.HupuEnum;
import com.hupu.pojo.Comment;
import com.hupu.service.Impl.CommentServiceImpl;
import com.hupu.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})
public class ComTest {
    @Autowired
    private CommentServiceImpl commentService;
    
    
    @Test
    public void testInsert() throws InterruptedException {
        
        for (int i = 2; i < 13; i++) {
            commentService.insert(new Comment(i*999, i, 1,
                    HupuEnum.TopicType.COMMENT.getTopicType(), 156542,
                    "comment info" + i, "2020-05-" + i));
        }
    }
    
    @Test
    public void testDelete() {
        commentService.deleteById(1);
    }
    
    @Test
    public void testGetBase() {
        Comment comment = commentService.getCommentByTopic(156542,
                HupuEnum.TopicType.GAME.getTopicType()).get(0);
        System.out.println(JSON.toJSON(comment));
        System.out.println(JSON.toJSON(commentService.queryById(1)));
    }
    
    @Test
    public void testGetByTopic() {
        for (Comment comment : commentService.getCommentByTopic(156542,
                HupuEnum.TopicType.GAME.getTopicType())) {
            System.out.println(comment.getFromUsr());
        }
    }
}
