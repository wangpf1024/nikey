package net.docs.design.pattern.builder;



import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 * 
 * @author arvin
 */
public class Builder {
	
	private List<Sender> list = new ArrayList<Sender>();

	public void produceMailSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new MailSender());
		}
	}

	public void produceSmsSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new SmsSender());
		}
	}
}
