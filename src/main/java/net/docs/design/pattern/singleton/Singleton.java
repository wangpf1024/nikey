package net.docs.design.pattern.singleton;

/**
 * 单例模式
 * @author arvin
 */
public class Singleton {

	private static Singleton instance = null;

	/* 私有构造方法，防止被实例化 */
	private Singleton() {
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new Singleton();
		}
	}

	public static Singleton getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}
}
