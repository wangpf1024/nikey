package net.docs.design.pattern.observer;

public class ObserverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());

		sub.operation();
	}

}
