package fab.the.chemist.Lecture3;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Store0 {
	
	//1) Technique par object
	private Object itemO;
	
	public void setItemO(Object itemO) {
		this.itemO = itemO;
	}
	
	public Object getItemO() {
		return this.itemO;
	}
	
	
	
	@Override
	public String toString() {
		return ""+this.itemO.toString();
		//return ""+this.item.toString();
	}
}



public class AppObject {
	
	public static void main(String[] args) {
		//1)
		//ceci est la technique utilisant des objects
		Store0 store0 = new Store0();
		//store.setItemO("test et retest");
		store0.setItemO(45);
		System.out.println(store0);
		//mais si on veut recupérer dans un String ou un integer, ce n'est pas possible, on doit caster 
		//(couteux en perf et entrainant des erruer au runtime si ce n'est pas un integer qui est passé)
		Integer i = (Integer) store0.getItemO();
			
	
		System.out.println(i);
	}
}
