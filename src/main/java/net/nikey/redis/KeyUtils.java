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
package net.nikey.redis;

/**
 * keys π§æﬂ¿‡
 */
abstract class KeyUtils {

	static final String UID = "uid:";

	public static String user(String name) {
		return "user:" + name + ":uid";
	}

	static String uid(String uid) {
		return UID + uid;
	}

	static String globalUid() {
		return "global:uid";
	}

	static String users() {
		return "users";
	}

	static String auth(String uid) {
		return UID + uid + ":auth";
	}

	static String authKey(String auth) {
		return "auth:" + auth;
	}
}