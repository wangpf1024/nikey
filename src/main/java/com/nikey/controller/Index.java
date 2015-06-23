package com.nikey.controller;

import oracle.jrockit.jfr.StringConstantPool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arvin on 2015/6/19.
 * This is a standard Restful Spring MVC Controller
 * 后台数据，前台VM 展示  2015/06/23。
 */

@RestController
public class Index {

    @RequestMapping(value ="index", method = RequestMethod.GET)
    public ModelAndView index(String name){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("nikey","Do what you feel like");
        return  new ModelAndView("index",map);
    };


}
