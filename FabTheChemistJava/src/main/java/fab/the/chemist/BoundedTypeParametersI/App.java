package fab.the.chemist.BoundedTypeParametersI;

public class App {

	/**
	 * There may be times when you want to restrict the types that can be used 
	 * as type arguments in a parameterized type. For example, a method that operates
	 * 	 on numbers might only want to accept instances of Number or its subclasses. 
	 * This is what bounded type parameters are for.
	 * 
	 * 	bounded type parameters allow you to invoke methods defined in the bounds
	 * 		For example extends Comparable -> we can use compareTo() method to compare items !!!
	 * 
	 * Type parameter can have multiple bounds:
				<T extends B1 & B2 & B3>
				
				Important for algorithms !!!
				
						for example we cant use ' > ; < ; == ' operators on T we have to make sure they are numbers
							or compare two strings we have to make sure they are strings !!!
	 * 
	 */
	
	
	//T etends l'interface Comparable<T>, ce qui signifie que tout paramètre de type T a accès a toute les methode de l'interface
	//MAIS il faut aussi que les type qu'on envoi impléments Comparable (String Integer, Char implementent tous comparable donc cela fonctionera
	//class Character implements java.io.Serializable, Comparable<Character> {
	//public final class String implements java.io.Serializable, Comparable<String>, CharSequence
	public static <T extends Comparable<T>> T calculateMin(T t1, T t2) {
	//public static <T> T calculateMin(T t1, T t2) { //ceci entraine une erreur au niveau du compareTo, java ne reconnait pas que T peut utiliser les methodes Comparable<T>
		
		if( t1.compareTo(t2) < 0 )
			return t1;
		
		return t2;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println( calculateMin('v', 'h'));
		
		System.out.println( calculateMin("Joe", "adam"));
		
		System.out.println( calculateMin(100, 23));
			
	}
}
