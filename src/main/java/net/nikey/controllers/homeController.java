package net.nikey.controllers;




import net.nikey.annotations.CookieCheck;
import net.nikey.utils.NikeySecurity;
import net.nikey.interceptor.CookieInterceptor;
import net.nikey.redis.UserRepository;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Flash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
public class homeController {

    @Autowired
    private final UserRepository user;

    @Autowired
    public homeController(UserRepository user) {
        this.user = user;
    }

    //首页
    @Get("")
    @Post("")
    public String get(Invocation v){
        Map<String,Object> map = new HashMap<String, Object>();
        v.addModel("slogan", "Just do what you feel like");
        return "home";
    };

    @Get("/issigned")
    @CookieCheck
    public String isSigned(Invocation v,Flash flash) {
        if(NikeySecurity.isSignedIn()){
            flash.add("error",NikeySecurity.getName() +"  is signed " );
            return "r:/msg";
        }
        flash.add("error",NikeySecurity.getName() +"  is not signed " );
        return "r:/msg";
    }


}
