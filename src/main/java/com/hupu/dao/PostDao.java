package com.hupu.dao;

import com.hupu.pojo.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (Post)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-16 17:33:28
 */
public interface PostDao {
    
    /**
     * 通过ID查询单条数据
     *
     * @param postId 主键
     * @return 实例对象
     */
    Post queryById(Integer postId);
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Post> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param post 实例对象
     * @return 对象列表
     */
    List<Post> queryAll(Post post);
    
    /**
     * 新增数据
     *
     * @param post 实例对象
     * @return 影响行数
     */
    int insert(Post post);
    
    /**
     * 修改数据
     *
     * @param post 实例对象
     * @return 影响行数
     */
    int update(Post post);
    
    /**
     * 通过主键删除数据
     *
     * @param postId 主键
     * @return 影响行数
     */
    int deleteById(Integer postId);

    int createPost(@Param("post_title") String post_title,
                   @Param("post_content") String post_content,
                   @Param("post_time") String post_time,
                   @Param("admin_id") int admin_id,
                   @Param("img_url") String img_url);
    
    List<Map<String,Object>> getHomePost();
    
    List<Integer> getTotalInfo();
}