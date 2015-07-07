package net.nikey.controllers;

import net.nikey.annotations.LoginRequired;
import net.nikey.redis.UserRepository;
import net.nikey.utils.CookieUtils;
import net.nikey.utils.NikeySecurity;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Flash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by arvin on 2015/7/6.
 * 用户登录控制层
 */
@Path("/signin")
@LoginRequired
public class SigninController {

    @Autowired
    private final UserRepository user;

    @Autowired
    public SigninController(UserRepository user) {
        this.user = user;
    }

    //登录页面
    @Get("")
    public String signIn(Invocation v){
        return "signin";
    };

    //登录控制层
    @Post("")
    public String signIn(Flash flash,@Param("name") String name, @Param("pass") String pass,HttpServletResponse response) {
        // add tracing cookie
        if (user.auth(name, pass)) {
            CookieUtils.addAuthCookie(user.addAuth(name), name, response, user);
            String uid = NikeySecurity.getUid();
            return "r:/module/"+uid;
        }
        else if (StringUtils.hasText(name) || StringUtils.hasText(pass)) {
            flash.add("error","Failed ");
            return "r:/msg";
        }
        // go back to sign in screen
        return "r:/";
    }

}
