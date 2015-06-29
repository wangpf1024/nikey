package net.docs.design.pattern.abstractfactory;



/**
 * 抽象工程模式
 * @author arvin
 */
public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		 return new SmsSender();  
	}

}
