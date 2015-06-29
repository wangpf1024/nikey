package net.docs.design.pattern.abstractfactory;



/**
 * 抽象工程模式
 * @author arvin
 */
public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender();  
	}

}
