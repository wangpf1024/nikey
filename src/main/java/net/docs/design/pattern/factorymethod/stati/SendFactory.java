package net.docs.design.pattern.factorymethod.stati;


import net.docs.design.pattern.factorymethod.MailSender;
import net.docs.design.pattern.factorymethod.Sender;
import net.docs.design.pattern.factorymethod.SmsSender;

/**
 * 静态工厂方法模式
 * 
 * @author arvin
 */
public class SendFactory {
	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender produceSms() {
		return new SmsSender();
	}
}
