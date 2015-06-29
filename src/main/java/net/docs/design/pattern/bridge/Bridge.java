package net.docs.design.pattern.bridge;

/**
 * 
 * ге╫сдёй╫
 * 
 * @author arvin
 */
public abstract class Bridge {
	
	private Sourceable source;

	public void method() {
		source.method();
	}

	public Sourceable getSource() {
		return source;
	}

	public void setSource(Sourceable source) {
		this.source = source;
	}
}
