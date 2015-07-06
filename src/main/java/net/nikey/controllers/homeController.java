package net.nikey.controllers;




import net.nikey.annotations.LoginRequired;
import net.nikey.redis.UserRepository;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arvin on 2015/6/19.
 * 首页：后台数据 ，前台VM 展示  2015/06/23。
 * @author 王鹏飞
 * @version 0.0.1
 * @since  2015/6/19
 */

@Path("")
@LoginRequired
public class homeController {

    //首页
    @Get("")
    @Post("")
    public String get(Invocation v){
        Map<String,Object> map = new HashMap<String, Object>();
        v.addModel("slogan", "Just do what you feel like");
        return "home";
    };


}
