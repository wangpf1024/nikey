package net.nikey.controllers;




import net.nikey.bean.NikeySecurity;
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


    //登录页面
    @Get("/signin")
    public String signIn(Invocation v){
        return "signin";
    };

    //登录控制层
    @Post("/signin")
    public String signIn(Flash flash,@Param("name") String name, @Param("pass") String pass,HttpServletResponse response) {
        // add tracing cookie
        if (user.auth(name, pass)) {
            addAuthCookie(user.addAuth(name), name, response);
            flash.add("printout", "  Congratulations ! ");
            return "r:/msg";
        }
        else if (StringUtils.hasText(name) || StringUtils.hasText(pass)) {
            flash.add("printout","Failed ");
           return "r:/msg";
        }
        // go back to sign in screen
        return "r:/";
    }


    /**
     * 添加cookie
     * @param auth
     * @param name
     * @param response
     */
    private void addAuthCookie(String auth, String name, HttpServletResponse response) {
        NikeySecurity.setUser(name, user.findUid(name));
        Cookie cookie = new Cookie(CookieInterceptor.RETWIS_COOKIE, auth);
        cookie.setComment("nikey - demo");
        // cookie valid for up to 1 week
        cookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(cookie);
    }

    //注册页面
    @Get("/signup")
    public String signUp(Invocation v){
        return "signup";
    };

    //注册控制
    @Post("/signup")
    public String signUp(Flash flash,Invocation v,@Param("name")String name, @Param("pass") String pass,@Param("pass2")String pass2,HttpServletResponse response) {

        if (user.isUserValid(name)) {
            flash.add("printout", name + " has been used");
            return "r:/msg";
        }

        if (!StringUtils.hasText(pass) || !StringUtils.hasText(pass2) || !pass.equals(pass2)) {
            flash.add("printout", "passwords are not same");
            return "r:/msg";
        }

        String auth = user.addUser(name, pass);
        addAuthCookie(auth, name, response);
        flash.add("printout", " Congratulations ! auth:" +auth);
        return "r:/msg";
    }

    //消息显示页
    @Get("/msg")
    public String msg(Invocation v,Flash flash){
        String printout = "Sorry ! There is no message for you";
        if(flash.get("printout") != null ){
            printout = flash.get("printout");
        }
        v.addModel("printout", printout);
        return "msg";
    };

    @Get("/signout")
    public String logout() {
        String user2 = NikeySecurity.getName();
        // invalidate auth
        user.deleteAuth(user2);
        return "r:/";
    }


}
