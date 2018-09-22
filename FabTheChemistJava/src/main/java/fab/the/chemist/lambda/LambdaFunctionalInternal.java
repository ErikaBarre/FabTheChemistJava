package fab.the.chemist.lambda;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;

public class LambdaFunctionalInternal {
	
	public static void main(String[] args) {
	
		Consumer<String> afficher0 = (param) -> System.out.println(param);
		afficher0.accept("Hello");
		
		Consumer<Long> afficher1 = param -> System.out.println(param);
		afficher1.accept(45L);
		
		BiFunction<Integer, Integer, Long> additionner = (val1, val2) -> (long) val1 + val2;
		Long result = additionner.apply(2, 6);
		System.out.println(result);
		
		//Consumer<String> afficher = String param -> System.out.println(param);  //erreur compil 
		//le type d'un paramètre n'est pas obligatoire si le compilateur est capable de l'inférer 
		Consumer<String> afficher = (String param) -> System.out.println(param);  
	
		Comparator<String> comparator = (final String chaine1, final String chaine2) -> Integer.compare(chaine1.length(),chaine2.length());
		
		//Comparator<String> comparator0 = (final chaine1, final chaine2) -> Integer.compare(chaine1.length(),chaine2.length());  //erreur compil
		
		Comparator<String> comparator1 = (@NotNull String chaine1, @NotNull String chaine2) -> Integer.compare(chaine1.length(),chaine2.length());
		
		//Le bloc de code est évalué comme si c'était celui d'une méthode : il est possible de terminer son exécution en utilisant l'instruction return ou en levant une exception.
		//Si le bloc de code doit retourner une valeur, il faut utiliser le mot clé return.
		Function<Integer, Boolean> isPositif = valeur -> {
	        return valeur >= 0;
		};
		isPositif.apply(45);
		
		
		LongFunction longFunction = x -> x * 2;
		longFunction.apply(20);
		IntFunction  intFunction  = x -> x * 2;
		Callable<String> monCallable = () -> "Mon traitement";
		try {
			monCallable.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Supplier<String> monSupplier = () -> "Mon traitement"; 
		monSupplier.get();
		
		ToDoubleFunction<Integer> toDoubleFunction = x -> x * 2;
		toDoubleFunction.applyAsDouble(123456);
		
	}

}
