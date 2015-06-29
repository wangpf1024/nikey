package net.docs.design.pattern.adapterclass;


/**
 * 类的适配器模式
 * 
 * @author arvin
 */
public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is the targetable method!");  
	}

}
