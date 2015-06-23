package com.api.controllers;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.api.bean.Version;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import sun.org.mozilla.javascript.internal.json.JsonParser;

/**
 * Created by arvin on 2015/6/23.
 * Restful API : Version 控制层
 */

@Path("api/version")
public class VersionController {

    @Get("")
    @Post("")
    public String get(Invocation invocation){
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
