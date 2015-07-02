package net.nikey.controllers.api;

import com.alibaba.fastjson.JSONObject;
import net.nikey.annotations.APIAccessCheckRequired;
import net.nikey.annotations.CookieCheck;
import net.nikey.annotations.NotBlank;
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

    @Post("/{id:[0-9]+}")
    @Get("/{id:[0-9]+}")
    @CookieCheck
    public String get(Invocation invocation,@Param("id")Integer id){
        Version v = new Version();
        v.setId(id);
        v.setArtifactId("nikey");
        v.setGroupId("nikey");
        v.setModelVersion("4.0.0");
        v.setName("nikey Maven Webapp");
        v.setPackaging("war");
        v.setVersion("1.0-SNAPSHOT");
        return "@json:"+JSONObject.toJSON(v);
    };


    @Post("/add")
    @Get("/add")
    @APIAccessCheckRequired
    public String add(Invocation invocation,Version v){
        return "@"+v.getId();
    };


}
