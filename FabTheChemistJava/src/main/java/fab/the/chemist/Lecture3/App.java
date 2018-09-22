package fab.the.chemist.Lecture3;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Store<T> {  // NE PAS OUBLIER DE SIGNALER QUE LA CLASSE EST GENERIC CAR JAVA A LA COMPIL ACCOMPLI DES VERIFICATION DE TYPE (T pour single type parameter : c'est une convention)
					//en definissant Store<String> stringStore = new Store(); , java remplace tout les T par des String

	//2) Technique par generic 
	private T item;
	
	public void setStoreItem(T item) {
		this.item = item;
	}
	
	public T getItem() {
		return this.item;
	}
	
	@Override
	public String toString() {
		return ""+this.item.toString();
	}
}

class Hashtable<K, V> { //pareil si on definit Hashtable<String, Integer> , java remplace tous les K par des string et des V par des integer
	
	private K key;
	private V value;
	
	public Hashtable(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return key.toString()+"-"+value.toString();
	}
}

public class App {
	
	public static void main(String[] args) {
				
		// raw type AVOID IT !!!
		Store<String> stringStore = new Store();// "diamond operator"
		//A LA COMPILATION java indique directement qu'il y a une erreur de type. Alors qu'au classcast c'est au runtime
		//stringStore.setStoreItem(45); //DECOMMENTER ET L'ERREUR EST VISIBLE
		stringStore.setStoreItem("Hello");
		String s = stringStore.getItem();
		
		Store<Integer> integerStore = new Store();// "diamond operator"
		integerStore.setStoreItem(45);
		
		Integer item =  integerStore.getItem();
		
		System.out.println(item);
		
		Hashtable<String, Integer> hashtable = new Hashtable("Hello world!", 55);
		System.out.println(hashtable);
		
	}
}
