package net.nikey.controllers;


import net.nikey.annotations.LoginRequired;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Flash;

/**
 * Created by arvin on 2015/7/13
 * 处理自定义异常
 * @author 王鹏飞
 * @version 0.0.1
 * @since  2015/7/3
 */

@Path("")
@LoginRequired
public class ErrorController {

    //消息显示页
    @Get("/msg")
    public String msg(Invocation v,Flash flash){
        String error = "Sorry ! There is no message for you";
        if(flash.get("error") != null ){
            error = flash.get("error");
        }
        v.addModel("errorMsg", error);
        return "msg";
    };


    @Get("e1")
    @Post("e1")
    public String error_login(Invocation v){
        return "error_login";
    };

}
