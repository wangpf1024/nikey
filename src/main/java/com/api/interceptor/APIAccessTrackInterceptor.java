package com.api.interceptor;

import com.api.annotations.APIAccessCheckRequired;
import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

import java.lang.annotation.Annotation;

/**
 * Created by arvin on 2015/6/24.
 * 访问拦截器拦截器
 */
public class APIAccessTrackInterceptor extends ControllerInterceptorAdapter {

    public APIAccessTrackInterceptor(){
        setPriority(29600);
    }

    @Override
    public Class<? extends Annotation> getRequiredAnnotationClass() {
        return APIAccessCheckRequired.class; // 这是一个注解，只有标过的controller才会接受这个拦截器的洗礼。
    }

    @Override
    public Object before(Invocation inv) throws Exception {
        /* TODO .... */
        return super.before(inv);
    }

    @Override
    public void afterCompletion(final Invocation inv, Throwable ex) throws Exception {
        /* TODO .... */
    }
}
