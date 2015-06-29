package net.docs.design.pattern.bridge;

/**
 * ге╫сдёй╫
 * @author arvin
 */
public class MyBridge extends Bridge {
	public void method() {
		getSource().method();
	}
}
