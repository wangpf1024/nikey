package net.docs.design.pattern.builder;

public class FactoryTest {
	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceMailSender(10);
	}
}
