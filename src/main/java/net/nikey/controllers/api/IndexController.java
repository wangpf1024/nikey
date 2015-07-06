package net.nikey.controllers.api;

import net.nikey.annotations.LoginRequired;
import net.nikey.utils.NikeySecurity;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

/**
 * Created by arvin on 2015/6/23.
 * 系统API
 * @author 王鹏飞
 * @version 0.0.2
 * @since  2015/6/23
 */

@Path("")
@LoginRequired
public class IndexController {

    @Get("")
    public String index(Invocation invocation){
        if(!NikeySecurity.isSignedIn()){
            return "r:/e1";
        }
        return "api";
    };

}
