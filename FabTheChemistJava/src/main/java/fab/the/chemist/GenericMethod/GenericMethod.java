package fab.the.chemist.GenericMethod;

public class GenericMethod {

	//devant le void on place <T> pour signaler à java q'uol s'agit bien d'une methode de type generic, cela n'a rien à voir avec le retour de le methode
	public <T> void showArray(T[] array) {
		
		for(T item : array)
			System.out.print(item.toString()+" -> ");
	}
	
	public <T> T showItem(T t) {
		System.out.println("The item is: " + t.toString());
		return t;
	}
}
