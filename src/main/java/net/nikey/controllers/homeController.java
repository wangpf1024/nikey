package net.nikey.controllers;




import net.nikey.bean.RetwisSecurity;
import net.nikey.interceptor.CookieInterceptor;
import net.nikey.redis.RetwisRepository;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
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
    private final RetwisRepository retwis;

    @Autowired
    public homeController(RetwisRepository twitter) {
        this.retwis = twitter;
    }

    @Get("")
    @Post("")
    public String get(Invocation v){
        Map<String,Object> map = new HashMap<String, Object>();
        v.addModel("slogan", "Just do what you feel like");
        return "home";
    };



    @Get("/signIn")
    public String signIn(Invocation v){
        return "signin";
    };

    @Post("/signIn")
    public String signIn(@Param("name") String name, @Param("pass") String pass,HttpServletResponse response) {
        // add tracing cookie
        if (retwis.auth(name, pass)) {
            addAuthCookie(retwis.addAuth(name), name, response);
            return "@ successful";
        }
        else if (StringUtils.hasText(name) || StringUtils.hasText(pass)) {
           return "@ failed";
        }
        // go back to sign in screen
        return "r:/signIn";
    }


    private void addAuthCookie(String auth, String name, HttpServletResponse response) {
        RetwisSecurity.setUser(name, retwis.findUid(name));

        Cookie cookie = new Cookie(CookieInterceptor.RETWIS_COOKIE, auth);
        cookie.setComment("Retwis-J demo");
        // cookie valid for up to 1 week
        cookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(cookie);
    }


    @Get("/signUp")
    public String signUp(Invocation v){
        return "signup";
    };

    @Post("/signUp")
    public String signUp( @Param("name")String name, @Param("pass") String pass,@Param("pass2")String pass2,HttpServletResponse response) {

        if (retwis.isUserValid(name)) {
            return "@ user is already existed";
        }

        if (!StringUtils.hasText(pass) || !StringUtils.hasText(pass2) || !pass.equals(pass2)) {
            return "@ these passwords are not equal";
        }

        String auth = retwis.addUser(name, pass);
        addAuthCookie(auth, name, response);

        return "r:/signIn";
    }

}
