package com.api.controllers;




import com.api.annotations.APIAccessCheckRequired;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.portal.Pipe;
import net.paoding.rose.web.portal.Portal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arvin on 2015/6/19.
 * 首页：后台数据 ，前台VM 展示  2015/06/23。
 */

@Path("")
public class homeController {


    @Get("")
    @Post("")
    public String get(Invocation v){
        Map<String,Object> map = new HashMap<String, Object>();
        v.addModel("nikey", "Just do what you feel like");
        return "home";
    };

}
