package net.nikey.controllers.api;

import com.alibaba.fastjson.JSONObject;
import net.nikey.annotations.CookieCheck;
import net.nikey.bean.Version;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

/**
 * Created by arvin on 2015/6/23.
 * 系统API
 * @author 王鹏飞
 * @version 0.0.2
 * @since  2015/6/23
 */

@Path("")
public class IndexController {

    @Get("")
    @Post("")
    @CookieCheck
    public String index(Invocation invocation){
        return "api";
    };

}
