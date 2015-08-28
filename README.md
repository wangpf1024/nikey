# nikey ~ java webapp
仿 Twitter 用户登录管理

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

        1.用户登录时创建 cookie 格式：  
        name : nikeyauth 
        value : auth (86e0c630-a919-4074-9503-6e2babe2a800)
        备注：每次用户登录成功后都会创建一个新的认证字符串
        
        2.使用Rose拦截器的方式对用户请求拦截(net.nikey.interceptor.LoginRequiredInterceptor)
        
        3.创建用户信息临时记录类(net.nikey.utils.NikeySecurity ).用户信息的使用在此类中获取。
        
        4.拦截器的使用，从cookie 中获取登录信息与redis中的最新认证做比较。判断用户cookie是否有效。
        如果有效将用户信息保存到 NikeySecurity 中。Controller 中可以直接使用NikeySecurity获取用户信息。
        每一次请求过后，将NikeySecurity中的用户信息清空，利与垃圾回收。
        
        5.用户退出时将用户认证信息删除
        
        6.存在问题，手机端无法使用 cookie
              
      
    
      
      
      

