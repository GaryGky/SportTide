package com.hupu.dao;

import com.hupu.pojo.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreMapper {
    // 对比赛数据的增删改查
    public void insertScore(Score score); // 增加一条比赛数据
    
    public List<Score> queryScoreByTeam(@Param("Team") String team); //
    // 按照队伍名称查询比赛数据
    
    public List<Score> queryScoreByDate(@Param("Date") String date); //
    // 按照日期查找比赛数据
}
