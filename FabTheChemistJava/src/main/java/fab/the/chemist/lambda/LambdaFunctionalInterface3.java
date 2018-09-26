package fab.the.chemist.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/*
Les interfaces fonctionnelles définissent des types qui pourront être implémentés sous la forme d'expressions lambda ou de références de méthodes.

Chaque interface fonctionnelle ne possède qu'une seule méthode abstraite nommée méthode fonctionnelle (functional method) pour laquelle les paramètres et la valeur de retour doivent correspondre ou pouvoir être adaptés.

Une interface fonctionnelle définit une méthode qui pourra être utilisée pour passer en paramètre :

    une référence sur une méthode d'une instance
    une référence sur une méthode statique
    une référence sur un constructeur
    une expression lambda
    une classe anonyme interne
*/
public class LambdaFunctionalInterface3 {

	public static void main(String[] args) {
		
		//Une interface fonctionnelle définit un type qui peut être utilisé dans plusieurs situations :
		//assignation:
		Predicate<String> estVide = String::isEmpty;
		
		List<Personne> people = 
				Arrays.asList(
						new Personne("Charles", "Dickens",60, 180)
						
						);
		
		people.stream().filter(e -> e.getTaille() > 100);
		
		//people.stream().map((ToIntFunction) e -> e.getTaille());
		
		String[] elements = new String[] { "aaa","zzz","fff","mmm"};
	    Arrays.sort(elements, (o1, o2) -> o1.compareTo(o2));
	    System.out.println(Arrays.toString(elements));
	    
	    //Il n'est pas possible d'assigner une expression lambda à un objet de type Object.
	    //Object tri = (o1, o2) -> o1.compareTo(o2);
	    //on fera ceci :assigner à un objet d'un type d'une interface fonctionnelle une expression lambda qui respecte la déclaration de la méthode abstraite
	    Comparator<String> tri = (o1, o2) -> o1.compareTo(o2);
	    String[] elements1 = new String[] { "aaa","zzz","fff","mmm"};
	    Arrays.sort(elements1, tri);
	    System.out.println(Arrays.toString(elements1));
	    
	    //Si une exception de type checked est levée dans le corps de l'expression lambda sans être gérée alors il est nécessaire que la méthode de 
	    //l'interface fonctionnelle correspondante déclare la levée de cette exception sinon une erreur est émise à la compilation.
	    Runnable monTraitement = () -> {
	        System.out.println("debut");
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        System.out.println("fin");
	      };
	      
	      //La méthode run() de l'interface Runnable ne déclare pas pouvoir lever une exception.
	      //solution : utiliser une autre interface fonctionnelle : dans le cas ci-dessous, Callable.
	      
	      Callable monTraitement1 = () -> {
	          System.out.println("debut");
	          Thread.sleep(1000);
	          System.out.println("fin");
	          return null;
	        };
	      
	    

	}

}
