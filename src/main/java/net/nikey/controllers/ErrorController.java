package net.nikey.controllers;


import net.nikey.annotations.CookieCheck;
import net.nikey.interceptor.CookieInterceptor;
import net.nikey.redis.UserRepository;
import net.nikey.utils.NikeySecurity;
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
 * Created by arvin on 2015/7/13
 * 处理自定义异常
 * @author 王鹏飞
 * @version 0.0.1
 * @since  2015/7/3
 */

@Path("")
public class ErrorController {

    @Get("e1")
    @Post("e1")
    public String error_login(Invocation v){
        return "error_login";
    };

}
