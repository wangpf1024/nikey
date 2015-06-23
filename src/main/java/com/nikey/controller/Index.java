package com.nikey.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arvin on 2015/6/19.
 * This is a standard Restful Spring MVC Controller
 */

@RestController
public class Index {

    @RequestMapping(value ="index", method = RequestMethod.GET)
    public String index(String name){
      return  "index";
    };

}
