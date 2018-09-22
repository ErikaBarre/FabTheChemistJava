package fab.the.chemist.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JButton;

public class SyntaxLambda {
	
	public static void main(String[] args) {

		Consumer<String> afficher0 = (param) -> System.out.println(param);
		afficher0.accept("Hello");
		
		Consumer<Long> afficher1 = param -> System.out.println(param);
		afficher1.accept(45L);
		
		BiFunction<Integer, Integer, Long> additionner = (val1, val2) -> (long) val1 + val2;
		Long result = additionner.apply(2, 6);
		System.out.println(result);
		
		
		
		Comparator<String> comparator = (final String chaine1, final String chaine2) -> Integer.compare(chaine1.length(),chaine2.length());
		System.out.println(comparator.compare("cchaine1", "chaine2"));
		
		//Comparator<String> comparator1 = (@NotNull String chaine1, @NotNull String chaine2) -> Integer.compare(chaine1.length(),chaine2.length());
		
		//Si le bloc de code doit retourner une valeur, il faut utiliser le mot clé return
		Function<Integer, Boolean> isPositif = valeur -> {
	        return valeur >= 0;
		};
		Boolean b = isPositif.apply(45);
		    
	    Integer compteur2 = 0;
	    compteur2++;
	    //erreur à la compilation,
	    //bouton.addActionListener(event -> System.out.println(compteur2));
	    
	    //alors pour passer une variable
	    JButton bouton = new JButton("Incrementer");
	    int[] compteur = new int[1];
	    bouton.addActionListener(event -> compteur[0]++);
	    //ceci n'est pas recommandé pas thread-safe
	    
	    AtomicInteger compteur3 = new AtomicInteger(0);
	    bouton.addActionListener(event -> compteur3.incrementAndGet());
	    /*
	    LongFunction longFunction = x -> x * 2;
	    IntFunction  intFunction  = x -> x * 2;
	    Callable<String> monCallable = () -> "Mon traitement";
	    Supplier<String> monSupplier = () -> "Mon traitement"; 
	    */
	    
	    String[] elements = new String[] { "aaa","zzz","fff","mmm"};
	    Arrays.sort(elements, (o1, o2) -> o1.compareTo(o2));
	    System.out.println(Arrays.toString(elements));
	    
	   
	    Comparator<String> tri = (o1, o2) -> o1.compareTo(o2);
	   
	    String[] elements2 = new String[] { "aaa","zzz","fff","mmm"};
	   	    Arrays.sort(elements, tri);
	   
	    System.out.println(Arrays.toString(elements));
	}
	
	
}
