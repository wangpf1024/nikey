package net.docs.design.pattern.factorymethod.stati;


import net.docs.design.pattern.factorymethod.Sender;

public class FactoryTest {
	 public static void main(String[] args) {  
		 Sender sender = SendFactory.produceMail();
	     sender.send();
		 Sender sender2 = SendFactory.produceSms();
		 sender2.send();
	 } 
}
