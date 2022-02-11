package com.hupu.service.Impl;


import com.hupu.dao.PostDao;
import com.hupu.pojo.Post;
import com.hupu.service.PostService;
import com.hupu.utils.Jpush;
import com.hupu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Post)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 12:33:06
 */
@Service("postService")
@Transactional

public class PostServiceImpl implements PostService {
    
    @Autowired
    @Qualifier("postDao")
    private PostDao postDao;
    
    @Autowired
    private UserServiceImpl userService;
    
    
    @Override
    public Post queryById(Integer postId) {
        return postDao.queryById(postId);
    }
    
    @Override
    public List<Post> queryAllByLimit(int offset, int limit) {
        return postDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<Post> queryAll(Post post) {
        return postDao.queryAll(post);
    }
    
    @Override
    public int insert(Post post) {
        return postDao.insert(post);
    }
    
    @Override
    public int update(Post post) {
        return postDao.update(post);
    }
    
    @Override
    public int deleteById(Integer postId) {
        return postDao.deleteById(postId);
    }
    
    private void pushPost(Post post) {
        Jpush jpush = new Jpush();
        List<String> userNameList = userService.getAllUserName();
        for (String name : userNameList) {
            jpush.jiguangPush(name, post.getPostTitle());
        }
    }
    
    @Override
    public int createPost(String post_title, String post_content, String post_time, int admin_id, String img_url) {
        Post post = new Post(1, post_title, post_content, post_time, 0, admin_id
                , img_url);
        pushPost(post); // 调用极光推送
        return postDao.createPost(post_title, post_content, post_time, admin_id, img_url);
    }
    
    @Override
    public List<Map<String, Object>> queryAllPost() {
        ArrayList<Map<String, Object>> postInfo = new ArrayList<>();
        List<Post> postList = postDao.queryAllByLimit(0, 2000); // 得到所有球队
        for (Post post : postList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("post_id", post.getPostId());
            map.put("post_title", post.getPostTitle());
            map.put("post_content", post.getPostContent());
            map.put("post_time", post.getPostTime());
            map.put("post_commentnum", post.getPostCommentnum());
            map.put("admin_id", post.getAdminId());
            map.put("img_url", post.getImgUrl());
            postInfo.add(map);
        }
        return postInfo;
    }
    
    
    @Override
    public List<Map<String, Object>> getHomePost() {
        return postDao.getHomePost();
    }
    
    public List<Integer> getTotalInfo() {
        return postDao.getTotalInfo();
    }
}