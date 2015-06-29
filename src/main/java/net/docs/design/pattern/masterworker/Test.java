package net.docs.design.pattern.masterworker;

import java.util.Map;
import java.util.Set;

/**
 * 并行模式
 * @author arvin
 *
 */
public class Test {

	public static void main(String[] args) {
          //固定使用5个worker
		  Master m = new Master(new PlusWorker(), 5);
		  
          for (int i = 0; i < 100; i++) {
			 m.submit(i);
		  }
          
          m.execute();
          
          int re = 0;
          Map<String,Object> resultMap = m.getResultMap();
          
          while (resultMap.size() > 0 || !m.isComplete()) {
			Set<String> keys = resultMap.keySet();
			String key = null;
			for (String k : keys) {
				key = k;
				break;
			}
			Integer i = null;
			if(key !=null){
				i = (Integer)resultMap.get(key);
			}
			if(i!=null){
				re += i;
			}
			if(key!=null){
				resultMap.remove(key);
			}
		  }
         
          System.out.println(re);
	}

}
