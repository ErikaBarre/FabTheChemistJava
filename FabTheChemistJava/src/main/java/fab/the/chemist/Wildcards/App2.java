package fab.the.chemist.Wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class App2 {

	/**
	 * 
	 * 	  
	   2.) UPPER BOUNDED WILDCARDS	"? extends T"

		la solution pour manipuler les collections est d'étendre le wildcard
				  ? extends T
				  ? extends K
				  ? extends V
				  ? extends Item etc etc
				  
				  comme dans l' EXEMPLE 3 dans app.java

		We want to use the previous method in a generic form so for List<Rectangle> or for List<Circle>
			and want to make it work	// both of them extends Shape !!!		

		drawAll(List<? extends Shape> l)

			Now this method accepts list of any subclass of Shape so
				we can use it for List<Circle> or List<Rectangle> as well

		Shape is the upper bound of the wildcard
			We can print BUT we can not add for example Circle !!!

				l.add(new Circle()) compile time error !!! we can read but cannot add item because
						the ? extends Shape is unknown subtype of Shape 
							Compiler does not know whether it is a Circle or a Rectangle

			+ it is an upper bound

			List<? extends Number> l = new ArrayList<Integer>();
			List<? extends Number> l = new ArrayList<Double>();
			List<? extends Number> l = new ArrayList<Number>();
				All the subclasses are valid here
		
				You can READ only List<Number> cannot read List<Double> because it may be a List<Integer>
					or List<Number> as well (car java ne peut pas deviner que Number est une liste double , integer , etc )
					
					ce qui signifie qu'on DOIT boucler sur le meme type que le type étendu (voir (1) )

				You can't add anything -> can't add double because it may be a List<Integer> !!!
			YOU CANT ADD ANY OBJECT TO A '? EXTENDS T' BECAUSE YOU CAN'T GUARANTEE WHAT KIND
				OF LIST IT IS REALLY POINTING TO
	 * 
	 */
	

	public static void sum(List<? extends Number> list) {
		double sum = 0.0;
		
		//(1) on boucle sur un type Number meme si la liste passer est de type double car java ne peut pas deviner que number correspondant à des double
		//à moins de faire du casting ce qui est à éviter  
		for(Number n : list) {
			sum = sum + n.doubleValue();
		}
		
		
		
		System.out.println("The sum is: " + sum);
		
		list.get(0); //on peut lire n'importe quel endroit de la liste 
		//list.add(45); //mais on ne peut toujours pas modifier la liste
		
		double sum2 = 0.0;
		for(Number n : list) {
			sum2 = sum2 + n.intValue();
		}
		System.out.println("The sum2 is: " + sum2);
	}
	
	public static void main(String[] args) {

		sum( Arrays.asList(1.1,2.2,3.3,4.5,9L));
		
	}
	
	class app3<E>{
	
	//il ne faut pas oublier que le but est d'éviter le casting des types qui lui passe toujours à la compilation mais pas forcément au runtime
	
	public void method0(){
		
		List<? extends Object[]> objects = new ArrayList<Integer[]>();
		for (int i = 0; i < objects.size(); i++) {
			Object[] row =  objects.get(i);	
		}
		
		//fonctionne aussi mais il faut faire un casting :
		//le wildcard n'étend rien
		List<?> objects2 = new ArrayList<E>();
		for (int i = 0; i < objects2.size(); i++) {
			Object[] row =  (Object[]) objects2.get(i);
				
		}
		
	}
	
	}
	
	
}
