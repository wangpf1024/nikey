package com.api.controllers;

import com.api.annotations.NotBlank;
import com.api.bean.Visitor;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;



/**
 * Created by arvin on 2015/6/24
 * 游客访问控制层
 * @author 王鹏飞
 * @since  2015/6/24
 */

@Path("visitor")
public class VisitorController {


    @Get("")
    @Post("")
    public String get(@NotBlank @Param("name")String name,Visitor v){
        return "@Hello World:"+v.getName();
    };


}
