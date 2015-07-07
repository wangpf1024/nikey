package net.nikey.controllers.module;

import net.nikey.annotations.LoginRequired;
import net.nikey.utils.NikeySecurity;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arvin on 2015/7/6.
 * 个人空间主页
 */
@Path("")
@LoginRequired
public class IndexController {
    //首页
    @Get("/{uid:[0-9]+}")
    public String get(Invocation v,@Param("uid") int uid){
        if(!NikeySecurity.isSignedIn()){
            return "r:/e1";
        };
        Map<String,Object> map = new HashMap<String, Object>();
        v.addModel("uid",uid);
        return "module";
    };
}
