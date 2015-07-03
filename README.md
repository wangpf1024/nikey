# nikey ~ java webapp
Just do what i feel like.  NIKEY- 解释 ：你可以

## 开发环境

        开发工具： idea，maven
        后台框架： Rose（支持国产） ，Spring  ,Velocity ，
        数据库：Redis ，Mongodb ， Mysql 。
        服务器：jetty 
        前台框架： bootstrap 框架布局 ，AngularJs....

## Redis 用户存储介绍 ( KEY + VALUE )

     1. Hash 结构保存用户信息(save user as hash)
        Key : "uid:id(变量)"
        Value : hash(key-value) 如："name":"arvin"

     2.String 结构保存用户ID
        Key ："user:name(变量):uid"
        Value : id(变量)

     3.List 结构保存用户集合
       Key ："users"
       Value :["name"....](变量)

     4.String 结构保存Auth (String auth = UUID.randomUUID().toString())
       Key: "uid:id(变量):auth"
       Value : auth(变量)

     5.String 结构Auth与用户关联
       Key: "auth:auth(变量)"
       Value : uid(变量)


## 用户安全控制
