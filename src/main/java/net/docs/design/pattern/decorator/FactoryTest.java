package net.docs.design.pattern.decorator;

public class FactoryTest {
	public static void main(String[] args) {
		Sourceable source = new Source();
		Sourceable obj = new Decorator(source);
		obj.method();
	}
}
