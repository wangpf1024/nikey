package net.docs.design.pattern.iterator;


/**
 * 迭代子模式
 * @author arvin
 */
public interface Collection {

	public Iterator iterator();

	/* 取得集合元素 */
	public Object get(int i);

	/* 取得集合大小 */
	public int size();
}
