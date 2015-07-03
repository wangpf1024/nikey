/*
 * Copyright 2011 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.nikey.interceptor;


import net.nikey.annotations.CookieCheck;
import net.nikey.utils.NikeySecurity;
import net.nikey.redis.UserRepository;
import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import java.lang.annotation.Annotation;


/**
 * Cookie 拦截器
 */
public class CookieInterceptor extends ControllerInterceptorAdapter {

	public static final String RETWIS_COOKIE = "nikeyauth";

	@Inject
	protected UserRepository user;

	@Override
	public Class<? extends Annotation> getRequiredAnnotationClass() {
		return CookieCheck.class;
	}

	@Override
	public Object before(Invocation inv) throws Exception {

		// all non-root requests get analyzed
		Cookie[] cookies = inv.getRequest().getCookies();
		if (!ObjectUtils.isEmpty(cookies)) {
			for (Cookie cookie : cookies) {
				if (RETWIS_COOKIE.equals(cookie.getName())) {
					String auth = cookie.getValue();
					String name = user.findNameForAuth(auth);
					if (StringUtils.hasText(name)) {
						String uid = user.findUid(name);
						if (StringUtils.hasText(uid)) {
							NikeySecurity.setUser(name, uid);
							return super.before(inv);
						}
					}
				}
			}
		}
		inv.addFlash("printout", " Cookie has expired" );
		return "r:/msg";
	}

	@Override
	public void afterCompletion(final Invocation inv, Throwable ex) throws Exception {
		NikeySecurity.clean();
	}

}