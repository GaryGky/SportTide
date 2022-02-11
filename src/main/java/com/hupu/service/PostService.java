package com.hupu.service;

import com.hupu.pojo.Post;

import java.util.List;
import java.util.Map;

/**
 * (Post)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 12:33:06
 */
public interface PostService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param postId 主键
     * @return 实例对象
     */
    Post queryById(Integer postId);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Post> queryAllByLimit(int offset, int limit);
    
    List<Post> queryAll(Post post);
    
    /**
     * 新增数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    int insert(Post post);
    
    /**
     * 修改数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    int update(Post post);
    
    /**
     * 通过主键删除数据
     *
     * @param postId 主键
     * @return 是否成功
     */
    int deleteById(Integer postId);

    int createPost(String post_title, String post_content, String post_time,
                   int admin_id, String img_url);

    List<Map<String, Object>> queryAllPost();
    
    List<Map<String ,Object>> getHomePost();
    
    List<Integer> getTotalInfo();
}