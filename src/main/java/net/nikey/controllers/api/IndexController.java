package net.nikey.controllers.api;

import com.alibaba.fastjson.JSONObject;
import net.nikey.annotations.APIAccessCheckRequired;
import net.nikey.bean.Version;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

/**
 * Created by arvin on 2015/6/23.
 * Restful API : Version 控制层
 * 查看版本号
 * @author 王鹏飞
 * @version 0.0.1
 * @since  2015/6/23
 */

@Path("")
public class IndexController {

    @Get("")
    @Post("")
    @APIAccessCheckRequired
    public String index(Invocation invocation){
        Version v = new Version();
        v.setArtifactId("nikey");
        v.setGroupId("nikey");
        v.setModelVersion("4.0.0");
        v.setName("nikey Maven Webapp");
        v.setPackaging("war");
        v.setVersion("1.0-SNAPSHOT");
        return "@json:"+JSONObject.toJSON(v);
    };

}
