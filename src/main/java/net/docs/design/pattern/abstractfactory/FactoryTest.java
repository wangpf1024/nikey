package net.docs.design.pattern.abstractfactory;

public class FactoryTest {
	 public static void main(String[] args) {  
		 Provider provider = new SendMailFactory();  
	     Sender sender = provider.produce();  
	     sender.send();
		 Provider provider2 = new SendSmsFactory();
		 Sender sender2 = provider2.produce();
		 sender2.send();
	 } 
}
