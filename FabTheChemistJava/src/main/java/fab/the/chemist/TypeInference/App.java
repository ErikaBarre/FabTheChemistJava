package fab.the.chemist.TypeInference;

import java.util.ArrayList;
import java.util.List;

public class App {

	/**
	 * - compiler's ability to look at each method invocation and corresponding declaration to 
	 * 		determine the type argument/arguments ( such as T ) that make the invocation applicable
	 * 
	 * - the inference algorithm determines: the types of the arguments 
	 * 				+ the type that the result is being assigned or returned if available !!!
	 * 
	 * - the inference algorithm tries to find the most specific type that works with all of the arguments !!!
	 * 
	 * 		public <T> T getData(T t1, T t2){
	 * 			return t2;
	 * 		}
	 * 
	 * 
	 * 		on constate que le 1er param est une string et le 2eme n'est pas une string mais array list. 
	 * 		java va alors trouver le type le plus specific qui fonction avec tous les arguments 
	 * 		ici le retour est serialiable (ce qui signfigne également que les 2 paramètres doivent également être sérialisable
	 * 
	 * 		Serializable s = getData( "Hello world" , new ArrayList<String>() );   !!!
	 * 
	 * 
	 * 	Because of the type inference algorithm, we can use instantiation like this:
	 * 
	 * 			List<String> list = new ArrayList<>();
	 * 
	 * 	Generic methods and type interference:
	 * 		 Enables us to invoke a generic method as you would an ordinary method, 
	 * 				without specifying a type between angle brackets
	 */
	
	public static <T> void addStore(T t, List<Bucket<T>> list) {
		Bucket<T> bucket = new Bucket();
		bucket.setItem(t);
		list.add(bucket);
		System.out.println(t.toString()+" has been added to the list...");
	}
	
	public static void main(String[] args) {
		
		List<Bucket<String>> list = new ArrayList();
		
		//java grace à la liste qui est definit en string, java va alors déduire que 
		//tous les paramètres T doivent être remplace par un type string
		App.addStore("Adam", list);
		
		//App.addStore(45, list); // erreur car en definissant string dans la liste , java s'attend à une string
		
		// "type witness"
		// on precice que le type infering sera un string. 
		//java ne doit pas deviner le type a remplacer (plus rapide en performence) 
		App.<String>addStore("Daniel", list);
		
		
		
	}
}

class Bucket<T> {  //on definit une classe generic pour alerter java
	
	private T item;
	
	public T getItem() {
		return this.item;
	}
	
	public void setItem(T item) {
		this.item = item;
	}
}
