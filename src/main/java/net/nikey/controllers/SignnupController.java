package net.nikey.controllers;

import net.nikey.redis.UserRepository;
import net.nikey.utils.CookieUtils;
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
 * 用户注册控制层
 */
@Path("/signup")
public class SignnupController {

    @Autowired
    private final UserRepository user;

    @Autowired
    public SignnupController(UserRepository user) {
        this.user = user;
    }

    //注册页面
    @Get("")
    public String signUp(Invocation v){
        return "signup";
    };

    //注册控制
    @Post("")
    public String signUp(Flash flash,Invocation v,@Param("name")String name, @Param("pass") String pass,@Param("pass2")String pass2,HttpServletResponse response) {

        if (user.isUserValid(name)) {
            flash.add("error", name + " has been used");
            return "r:/msg";
        }

        if (!StringUtils.hasText(pass) || !StringUtils.hasText(pass2) || !pass.equals(pass2)) {
            flash.add("error", "passwords are not same");
            return "r:/msg";
        }

        String auth = user.addUser(name, pass);
        CookieUtils.addAuthCookie(auth, name, response, user);
        flash.add("error", " Congratulations ! auth:" +auth);
        return "r:/msg";
    }
}
