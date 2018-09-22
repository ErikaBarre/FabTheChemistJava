package fab.the.chemist.TypeErasure;

import java.io.Serializable;
import java.nio.file.FileStore;

public class App {

	/**
	 * c'est ce qui se passe dans la virtual machine de java
	 * 
	 * In order to implement generics, Java uses type erasure
	 * 		This is how generic Java code is handled !!!
	 * 
	 * 		- replace all type parameters in generic types with their bounds or Object 
	 * 			if the type parameters are unbounded
	 * 				So the final bytecode will contain plain java objects/classes
	 * 
	 * 		- uses type casts if necessary
	 * 
	 * 		- sometimes it generates extra methods: the so called bridge methods
	 * 				in order to maintain polymorphism with generics types
	 * 
	 * 		In the bytecode the following code is equivalent
	 * 
	 * 
	 * on ecrit ceci 
	 * 			List<Integer> list = new ArrayList<>();
	 * 			list.add(3);
	 * 			Integer num = list.get(0);
	 * 			----------------------------
	 *la virtual machine genere ceci
	 * 			List list = new ArrayList();
	 * 			list.add(3);
	 * 			Integer num = (Integer) list.get(0) 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
	
		FirstStore fs = new FirstStore();
		fs.setItem(new String("Hello world"));
		
		FirstStore2 fs2 = new FirstStore2();
		fs2.setItem(new String("Hello world"));
		
	}
}

//la machine virtual va remplacer T par object
class FirstStore {
	
	private Object item;
	
	public Object getItem() {
		return this.item;
	}
	
	public void setItem(Object item) {
		this.item = item;
	}
}

class FirstStore2<T> {
	
	private T item;
	
	public T getItem() {
		return this.item;
	}
	
	public void setItem(T item) {
		this.item = item;
	}
}
