package net.docs.design.pattern.chain;

/**
 * 责任链模式
 * 
 * @author arvin
 */
public abstract class AbstractHandler {
	
	private Handler handler;

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
