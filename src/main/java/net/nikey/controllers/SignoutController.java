package net.nikey.controllers;

import net.nikey.annotations.LoginRequired;
import net.nikey.redis.UserRepository;
import net.nikey.utils.NikeySecurity;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by arvin on 2015/7/6.
 * 用户退出控制层
 */
@Path("/signout")
@LoginRequired
public class SignoutController {


    @Autowired
    private final UserRepository user;

    @Autowired
    public SignoutController(UserRepository user) {
        this.user = user;
    }

    @Get("")
    public String logout() {
        String user2 = NikeySecurity.getName();
        // invalidate auth
        user.deleteAuth(user2);
        return "r:/";
    }
}
