package net.docs.design.pattern.factorymethod.multiple;


import net.docs.design.pattern.factorymethod.Sender;

public class FactoryTest {
	 public static void main(String[] args) {  
	        SendFactory factory = new SendFactory();  
	        Sender sender = factory.produceMail();
	        sender.send();
		     Sender sender2 = factory.produceSms();
		    sender2.send();
	 } 
}
