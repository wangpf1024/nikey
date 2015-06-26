package net.nikey.controllers.resume;

/**
 * Created by arvin on 2015/6/26.
 * 应用拥有者
 * @author 王鹏飞
 * @version 0.0.1
 * @since  2015/6/26
 */

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

@Path("")
public class IndexController {

    @Get("")
    @Post("")
    public String index(Invocation v){
      return "index";
    };

}
