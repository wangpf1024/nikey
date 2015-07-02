package net.nikey.controllers.blog;

import net.nikey.annotations.APIAccessCheckRequired;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

/**
 * Created by arvin on 2015/6/29.
 * 博客
 * @author 王鹏飞
 * @version 0.0.1
 * @since  2015/6/29
 */
@Path("")
public class IndexController {
    @Get("")
    @Post("")
    @APIAccessCheckRequired
    public String index(Invocation invocation){
        return "blog";
    };
}
