package com.api.controllers;

import com.api.annotations.NotBlank;
import com.api.bean.Visitor;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;



/**
 * Created by arvin on 2015/6/19.
 * 首页：后台数据 ，前台VM 展示  2015/06/23。
 */

@Path("visitor")
public class VisitorController {


    @Get("")
    @Post("")
    public String get(@NotBlank @Param("name")String name,Visitor v){
        return "@Hello World:"+v.getName();
    };


}
