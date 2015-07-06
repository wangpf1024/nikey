package net.nikey.utils;

import net.nikey.interceptor.CookieInterceptor;
import net.nikey.redis.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by arvin on 2015/7/6.
 * Cookie 工具类
 */
public class CookieUtils {

    /**
     * 添加cookie
     * @param auth
     * @param name
     * @param response
     */
    public static void addAuthCookie(String auth, String name, HttpServletResponse response,UserRepository user) {
        NikeySecurity.setUser(name, user.findUid(name));
        Cookie cookie = new Cookie(CookieInterceptor.RETWIS_COOKIE, auth);
        cookie.setComment("nikey - demo");
        // cookie valid for up to 1 week
        cookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(cookie);
    }
}
