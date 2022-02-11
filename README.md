# 体育赛事咨询平台

### 项目目标：

本项目计划**面向某类竞赛项目**（**NBA**），基于目前可公开访问的赛事数据资讯源头，开发一款体育赛事资讯平台。本项目应实现数据采集，赛事列表查看，赛事数据详情查看，发表评论，比赛结果预测等功能。

### Content

### Game:

MySQL中按照队名对表进行排序

1. Team：队伍(30支队伍的数据)
2. Game：Team的比赛编号
3. Date：比赛日期
4. Home：主场球队
5. Opponent：客场球队
6. Win or Loss：输赢

### Team and Opponent:

1. Team Points：队伍得分
2. Field Goals：总的投篮得分
3. Field Goals Attempted：出手次数
4. Field Goals Percentage：命中率
5. 3 Point Shots：三分球得分
6. 3 Point Shots Attempted：三分球出手
7. 3 Point Shots Percentage：三分命中率
8. Free Throws：罚球得分
9. Free Throws Attempted：罚球次数
10. Free Throws Percentage：罚球命中率
11. Offensive Rebounds：进攻篮板
12. Total Rebounds：总篮板
13. Assists：助攻
14. Steals：抢断
15. Blocks：盖帽
16. Turnovers：失误
17. Total Fouls：犯规次数

### 主要功能和需求如下

- 数据准备

  请根据现有的可靠数据源头，爬取该类赛事的相关数据。为丰富平台内容，数据内容应包含赛事的基本信息，如时间、参与双方详情、比赛结果、相关比赛数据以及相关精彩瞬间图片等。同时应提供录入新赛事信息的功能（手动或自动）。

- 管理端需求

  需要实现管理员登录、赛事数据库管理、赛事内容管理、录入新赛事信息、用户管理以及留言管理。

- 用户端需求

  需要实现用户浏览赛事列表（已结束赛事与未来赛事）、赛事战报信息与相关图片查看、未来赛事预告提醒、针对某场赛事评论留言与回复评论以及查看系统提供的赛事结果预测。

- AI预测

  系统根据自己的预测算法结合过往比赛数据，对未来的比赛进行胜率（或比分）预测，为用户提供参考。



### 数据库设计

- #### score表

  | 比赛信息表 |               |             |
  | ---------- | ------------- | ----------- |
  | 描述       | 字段名        | 类型        |
  | 球队1      | Team          | varchar 255 |
  | 球队2      | Opponent      | varchar 255 |
  | 主场or客场 | Home          | varchar 255 |
  | 球队1得分  | TeamPoints    | int         |
  | 球队2得分  | OpponentPoint | int         |
  |            |               |             |

  说明：

  1. 对分数添加了check约束，每支球队单场得分的范围(0,300)
  2. 

- #### user表

  | Users用户注册信息表 |               |             |      |         |
  | ------------------- | ------------- | ----------- | ---- | ------- |
  | 描述                | 字段名        | 类型        | 空值 | 其他    |
  | 用户ID              | user_id       | number(8)   | 否   | 主键    |
  | 用户邮箱            | user_email    | varchar(40) | 否   |         |
  | 用户密码            | user_password | varchar(80) | 否   |         |
  | 用户昵称            | user_nikename | varchar(60) | 否   |         |
  | 注册时间            | user_time     | timestamp   | 否   |         |
  | 验证状态            | user_status   | Number(1)   |      | 默认(0) |

- #### Post 帖子表（系统内无特殊说明post代表帖子的意思）

  加粗的字段表示暂未加入表中

  | 描述           | 字段名             | 类型            | 空值   | 其他     |
  | -------------- | ------------------ | --------------- | ------ | -------- |
  | 普通消息ID     | post_id            | number(8)       | 否     | 主键     |
  | 消息类型       | post_type          | varchar(20)     |        |          |
  | 消息内容       | post_info          | varchar(400)    |        |          |
  | 发表时间       | post_time          | timestamp       |        |          |
  | 收藏次数       | post_collectnum    | number(8)       |        |          |
  | 评论次数       | post_commentnum    | number(8)       |        |          |
  | 转发次数       | post_ transpondnum | number(8)       |        |          |
  | **赞同次数**   | **post_agreenum**  | **number(8)**   |        |          |
  | **阅读次数**   | **post_readnum**   | **number(8)**   |        |          |
  | **消息标签**   | **post_label**     | **varchar(80)** |        |          |
  | **消息图片ID** | **picture_id**     | **number(8)**   | **否** | **外键** |
  | 发表用户ID     | user_id            | number(8)       | 否     | 外键     |

  

- #### comments 评论表

  删除的时候采用级联模式：即：如果外键被删除了，那么该条消息也应该被删除。现实场景：如果一个人删除了某条帖子，那么与该帖子相关的评论也应该被删除。
  
  | 描述       | 字段名              | 类型         | 空值 | 其他 |
  | ---------- | ------------------- | ------------ | ---- | ---- |
  | 评论ID     | comments_id         | number(8)    | 否   | 主键 |
  | 评论内容   | comments_info       | varchar(200) |      |      |
  | 内容状态   | comments_infostatus | varchar(10)  |      |      |
  | 评论时间   | comments_time       | timestamp    |      |      |
  | 普通消息ID | post_id             | number(8)    | 否   | 外键 |
  | 用户ID     | user_id             | number(8)    | 否   | 外键 |



- #### admins 管理员表

  | Admins管理员表 |             |             |      |      |
  | -------------- | ----------- | ----------- | ---- | ---- |
  | 描述           | 字段名      | 类型        | 空值 | 其他 |
  | 管理员ID       | admins_id   | number(8)   | 否   | 主键 |
  | 管理员名称     | admins_name | varchar(20) | 否   |      |
  | 管理员密码     | admins_pass | varchar(20) | 否   |      |

### 软工进度

- #### 第一周 4.10

  贺行健：周报、需求规格和概要设计
  张佳一：数据实时获取
  毛豫新：管理端前端
  甘凯元：管理端后端
  
  - #### 4/10 21:12更新：代码部署说明
  
    - For ALL
  
      `IDEA2018.3+ `
  
      `MAVEN3.6+ `
  
      `TomCAT9+`
  
    - For 前端
  
      前端的界面主要是在web/WEB-INF/jsp文件夹下新建jsp文件
  
      前端请求后端需要用到Servlet的request和response
  
      `com.hupu.controller`文件夹下用来连接前后端数据，数据交换形式为json
  
    - For 后端
  
      DAO层进行SQL操作
  
      POJO层是对数据库元素的封装
  
      SERVICE层是业务层，未来的业务逻辑可能要在这层实现
  
    emmm我个人作业的文档对spring层次描写的比较清楚，可以看看~
  
    连接：<https://github.com/GaryGky/SE-Peroject1>
  



### 数据库实现细节

**所有在数据库中的密码都加密存储。统一密钥为:**`hupu`

在修改密码时要求输入旧密码。

修改密码时，需要重复输入新密码以确认。【使用Ajax】

- #### user表

  - user_time： 应该自动生成
  - user_status：用来标识用户是否处于登录状态

  ##### 实现操作：

  1. 用户创建
  2. 用户销毁
  3. 用户更新信息：
     1. 更新昵称
     2. 更新密码
     3. 更新状态
  4. 用户查询：
     1. 按照id查询
     2. 按照姓名模糊查询
     3. 按照邮箱查询

  注意点：

  email用正则表达式进行格式验证，通过ajax返回结果。

- #### 管理员表

  ##### 实现操作：

  1. 创建一个管理员
  2. 管理员修改密码
  3. 管理员修改名称
  4. 查询所有管理员
  5. 删除一个管理员

- #### Post表（帖子）

  ##### 实现操作：

  1. 创建一个帖子
  2. 收藏更新（更新包括加和减）
  3. 评论更新
  4. 转发更新
  5. 删除一个帖子
  6. 按类型查询帖子
  7. 查询某人发布的帖子
  8. 
  
  team表：队伍英文简称作为Id
  
  game表：6位gameId
  
  team_stats：7位id，是由gameId + 0/1组成的，0表示客场，1 表示主场
  
  player_stats：9位id，是由 team_stats:id + 两位数字 组成的，两位的数字是将球员从1开始编号的，且保证了1~5为首发球员
  
  recap：以gameId作为主键