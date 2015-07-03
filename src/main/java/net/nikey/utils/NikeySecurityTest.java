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
package net.nikey.utils;

import org.springframework.core.NamedThreadLocal;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 测试类：多线程
 */
public class NikeySecurityTest implements Runnable {

	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("currentThreadName : "+currentThreadName);
		//产生一个随机数并打印
		Random random = new Random();
		int age = random.nextInt(100);
		NikeySecurity.setUser(age+"",""+age);
		System.out.println("thread " + currentThreadName + " first read  name is:" + NikeySecurity.getName());
		try {
			Thread.sleep(1000);
		}catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("thread " + currentThreadName + " second  read  name is:" + NikeySecurity.getName());
		try {
			Thread.sleep(1000);
		}catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("third " + currentThreadName + " third  read  name is:" + NikeySecurity.isSignedIn());
	}

	public static void main(String[] agrs) {
		NikeySecurityTest td = new NikeySecurityTest();
		Thread t1 = new Thread(td, "001");
		Thread t2 = new Thread(td, "002");
		Thread t3 = new Thread(td, "003");
		Thread t4 = new Thread(td, "004");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		System.out.println("name is:" + NikeySecurity.isSignedIn());
	}

}
