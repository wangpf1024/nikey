# nikey ~ java webapp
Just do what i feel like.  NIKEY- 解释 ：你可以

## 开发环境

        开发工具： idea，maven
        后台框架： Rose（支持国产） ，Spring  ,Velocity ，
        数据库：Redis ，Mongodb ， Mysql 。
        服务器：jetty 
        前台框架： bootstrap 框架布局 ，AngularJs....

## Redis 用户存储介绍 ( KEY + VALUE )  仿 Twitter   

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
       
     6.参考demo 
       https://github.com/spring-projects/spring-data-keyvalue-examples
     
## 安全控制-判断是否已经登录成功

    1.用户登录时创建cookie 格式：  
      name : nikeyauth 
      value : auth (86e0c630-a919-4074-9503-6e2babe2a800)
      备注：每次用户登录成功后都会创建一个新的认证字符串
      
    2.用户请求拦截器 (net.nikey.interceptor.LoginRequiredInterceptor)
      用户发出请求进入拦截器。拦截器获取cookie值与redis中的最新认证做比较。
      判断用户是否存在权限。
      如果通过认证，则将用户的信息保存到一个由 ThreadLocal 方式 维护的对象中
      (net.nikey.utils.NikeySecurity)。
      使用ThreadLocal 的 get 方式使用用户信息
      用户请求结束后将ThreadLocal中的用户信息清除。利于垃圾回收。
      
    3.用户退出时将用户认证信息删除
      
      
    
      
      
      

