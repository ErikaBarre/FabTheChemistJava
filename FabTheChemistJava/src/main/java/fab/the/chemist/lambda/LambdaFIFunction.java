package fab.the.chemist.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

/*
Les interfaces fonctionnelles de type Function (Function, BiFunction, DoubleFunction, DoubleToIntFunction, DoubleToLongFunction, IntFunction, IntToDoubleFunction, 
IntToLongFunction, LongFunction, LongToDoubleFunction, LongToIntFunction, ToDoubleBiFunction, ToDoubleFunction, ToIntBiFunction, ToIntFunction, ToLongBiFunction, 
ToLongFunction, BinaryOperator, DoubleBinaryOperator, DoubleUnaryOperator, IntBinaryOperator, IntUnaryOperator, LongBinaryOperator, LongUnaryOperator, UnaryOperator) 
définissent des fonctions qui attendent différents types de paramètres et renvoient une valeur.

L'interface fonctionnelle Function<T, R> définit une fonction qui effectue une opération sur un objet de type T et renvoie une valeur de type R.
Elle définit la méthode fonctionnelle apply(T t) qui renvoie une valeur de type R.
Elle définit aussi plusieurs méthodes par défaut et static :

default <V> Function<T, V> andThen(Function< ? super R, ? extends V >
Renvoyer une Function qui exécute en séquence l'instance courante et celle fournie en paramètre

default <V> Function <V, R> compose(Function< ? super V, ? extends T>
Renvoyer une Function qui exécute l'instance fournie en paramètre et applique l'instance courante sur le résultat

static <T> Function<T, T> identity()
Renvoyer une Function qui renvoie toujours la valeur fournie en paramètre

*/
public class LambdaFIFunction {

	public static void main(String[] args) {
	
		  Function<Integer,Long> doubler0 = (i) -> (long) i * 2;
		  System.out.println(doubler0.apply(2));
	      
		  
		  Function<Long, Long> doubler = (i) -> {
		      long resultat = (long) i * 2;
		      System.out.println("doubler=" + resultat);
		      return resultat;
		    };

		    Function<Long, Long> laMoitie = (i) -> {
		      long resultat = i / 2;
		      System.out.println("laMoitie=" + resultat);
		      return resultat;
		    };

		    System.out.println(doubler.andThen(laMoitie).apply(3L));
		    System.out.println(doubler.compose(laMoitie).apply(3L));
		    
		    
		    //La méthode identity() renvoie une instance de Function dont le but est simplement de renvoyer la valeur fournie en paramètre.
		    Function<Long, Long> identite = Function.identity();
		    System.out.println(identite.apply(3L));
		    
		    /*
		  L'interface fonctionnelle BiFunction définit une opération qui attend deux paramètres et renvoie une valeur. C'est une spécialisation de l'interface fonctionnelle Function qui attend deux paramètres.
L'interface BiFunction<T,U,R> est typée avec trois generics qui précisent respectivement les types des deux arguments de l'opération de la fonction et le type de la valeur de retour.
Elle définit la méthode fonctionnelle accept(T t, U u) et renvoie une valeur de type R.
Elle définit aussi une méthode par défaut :

Méthode
default <V> BiFunction<T, U, V> andThen(Function< ? super R, ? extends V>

Rôle
Renvoyer une BiFunction qui exécute en séquence l'instance courante et celle fournie en paramètre  
	    */
		    
		    BiFunction<String, String, String> concatener = (x, y) -> x + y;
		    System.out.println(concatener.apply("Bonjour", " Java"));
		    
/*
L'interface fonctionnelle DoubleFunction<R> définit une opération qui attend en paramètre une valeur de type double et renvoie un résultat. 
C'est une spécialisation de l'interface fonctionnelle Function qui attend une valeur flottante.
L'interface DoubleFunction<R> est typée avec un generic qui précise le type de la valeur de retour.
Elle définit la méthode fonctionnelle apply(double valeur) qui renvoie une valeur de type R.
*/
		    DoubleFunction<String> formater = (x) -> String.format("%.2f", x);
		    System.out.println(formater.apply(3.14116D));
		    
/*
L'interface fonctionnelle DoubleToIntFunction définit une opération qui attend en paramètre une valeur de type double et renvoie un entier. 
C'est une spécialisation de l'interface fonctionnelle Function qui attend une valeur flottante et retourne un entier.
Elle définit la méthode fonctionnelle applyAsInt(double valeur) qui renvoie une valeur de type int.
*/
		    DoubleToIntFunction dtif = (x) -> {return (int) x;};
		    System.out.println(dtif.applyAsInt(3.14));
/*		    
		    L'interface fonctionnelle IntFunction définit une opération qui attend en paramètre une valeur de type int et renvoie un résultat. C'est une spécialisation de l'interface fonctionnelle Function qui attend une valeur entière.

L'interface IntFunction<R> est typée avec un generic qui précise le type de la valeur de retour.

Elle définit la méthode fonctionnelle apply(int valeur) qui renvoie une valeur de type R.
	
		  */
		    
		    IntFunction<String> formater1 = (x) -> String.format("%d m", x);
		    System.out.println(formater1.apply(3));
		    
		    /*
		    L'interface fonctionnelle IntToDoubleFunction définit une opération qui attend en paramètre une valeur entière et renvoie une valeur flottante. C'est une spécialisation de l'interface fonctionnelle Function qui attend un entier et retourne une valeur flottante.

Elle définit la méthode fonctionnelle applyAsDouble(int valeur) qui renvoie une valeur de type double.
		    */
		    
		    IntToDoubleFunction cos = (x) -> Math.cos(x);
		    System.out.println(cos.applyAsDouble(5));
		    
		    /*
		    L'interface fonctionnelle IntToLongFunction définit une opération qui attend en paramètre une valeur entière et renvoie une valeur entière longue. C'est une spécialisation de l'interface fonctionnelle Function qui attend une valeur entière et retourne un entier long.

Elle définit la méthode fonctionnelle applyAsLong(int valeur) qui renvoie une valeur de type long.
		    
		    */
		    
		    IntToLongFunction doubler1 = (x) -> (long) x * 2;
		    System.out.println(doubler1.applyAsLong(Integer.MAX_VALUE));
		    
		    
		    /*
		    L'interface fonctionnelle LongFunction définit une opération qui attend en paramètre une valeur de type long et renvoie un résultat. C'est une spécialisation de l'interface fonctionnelle Function qui attend une valeur entière longue.

L'interface LongFunction<R> est typée avec un generic qui précise le type de la valeur de retour.

Elle définit la méthode fonctionnelle apply(long valeur) qui renvoie une valeur de type R.
		    
		    */
		    LongFunction<String> formater3 = (x) -> String.format("%d m", x);
		    System.out.println(formater3.apply(123456789012345L));
		    
		    /*
		    L'interface fonctionnelle LongToDoubleFunction définit une opération qui attend en paramètre une valeur entière longue et renvoie une valeur flottante. C'est une spécialisation de l'interface fonctionnelle Function qui attend une valeur entière longue et retourne une valeur flottante.

Elle définit la méthode fonctionnelle applyAsDouble(long valeur) qui renvoie une valeur de type double.
		    */
		    LongToDoubleFunction sin = (x) -> Math.sin(x);
		    System.out.println(sin.applyAsDouble(123456789012345L));
		    
		    /*
		    L'interface fonctionnelle LongToIntFunction définit une opération qui attend en paramètre une valeur entière longue et renvoie une valeur entière. C'est une spécialisation de l'interface fonctionnelle Function qui attend une valeur entière longue et retourne une valeur entière.

Elle définit la méthode fonctionnelle applyAsInt(long valeur) qui renvoie une valeur de type int.

L'interface fonctionnelle ToDoubleBiFunction définit une opération qui attend en paramètre deux valeurs et renvoie un résultat. C'est une spécialisation de l'interface fonctionnelle BiFunction qui renvoie une valeur de type double.

L'interface ToDoubleBiFunction<T, U> est typée avec deux generic qui précisent le type de chacun des deux paramètres.

Elle définit la méthode fonctionnelle applyAsDouble(T t, U u) qui renvoie une valeur de type double.
		    */
		    ToDoubleBiFunction<Integer, Integer> trigo = 
		    	      (x, y) -> Math.sin(x) + Math.cos(y);
		    	    System.out.println(trigo.applyAsDouble(3, 5));
		    
		    /*
	L'interface fonctionnelle ToDoubleFunction définit une opération qui attend en paramètre une valeur et renvoie une valeur flottante. C'est une spécialisation de l'interface fonctionnelle Function qui renvoie une valeur flottante.

L'interface ToDoubleFunction<T> est typée avec un generic qui précise le type du paramètre.

Elle définit la méthode fonctionnelle applyAsDouble(T t) qui renvoie une valeur de type double.
			*/
		    	    ToDoubleFunction<Integer> calculCosinus = (x) -> Math.cos(x);
		    	    System.out.println(calculCosinus.applyAsDouble(10));
		    	    /*
		    	    L'interface fonctionnelle ToIntBiFunction définit une opération qui attend en paramètre deux valeurs et renvoie un résultat. C'est une spécialisation de l'interface fonctionnelle BiFunction qui renvoie un entier.

L'interface ToIntBiFunction<T, U> est typée avec deux generic qui précisent le type de chacun des deux paramètres.

Elle définit la méthode fonctionnelle applyAsInt(T t, U u) qui renvoie une valeur de type int.
		    	    
		    	    */
		    	    ToIntBiFunction<String, String> somme = (x, y) -> 
		    	      Integer.parseInt(x) + Integer.parseInt(y);
		    	    System.out.println(somme.applyAsInt("123", "456"));
		    	    
/*
		L'interface fonctionnelle ToIntFunction définit une opération qui attend en paramètre une valeur et renvoie une valeur entière. C'est une spécialisation de l'interface fonctionnelle Function qui renvoie un entier.

L'interface ToIntFunction<T> est typée avec un generic qui précise le type du paramètre.

Elle définit la méthode fonctionnelle applyAsInt(T t) qui renvoie une valeur de type int.    	    
	*/	    	    
		    	    
		    	    ToIntFunction<String> convertEnInt = (x) -> Integer.parseInt(x);
		    	    System.out.println(convertEnInt.applyAsInt("123"));
		    	    
		    	    /*
		    	    L'interface fonctionnelle ToLongBiFunction définit une opération qui attend en paramètre deux valeurs et renvoie un résultat. C'est une spécialisation de l'interface fonctionnelle BiFunction qui renvoie un entier long.

L'interface ToLongBiFunction<T, U> est typée avec deux generic qui précisent le type de chacun des deux paramètres.

Elle définit la méthode fonctionnelle applyAsLong(T t, U u) qui renvoie une valeur de type long.
		    	    */
		    	    ToLongBiFunction<String, String> somme1 = 
		    	    	      (x, y) -> Long.parseLong(x) + Long.parseLong(y);
		    	    	    System.out.println(somme1.applyAsLong("123", "456"));
		    	    	    
		    	    	    /*
		    	    	    L'interface fonctionnelle ToLongFunction définit une opération qui attend en paramètre une valeur et renvoie une valeur entière longue. C'est une spécialisation de l'interface fonctionnelle Function qui renvoie un entier long.

L'interface ToLongFunction<T> est typée avec un generic qui précise le type du paramètre.

Elle définit la méthode fonctionnelle applyAsLong(T t) qui renvoie une valeur de type long.
		    	    	    
		    	    	    */
		    	    	    ToLongFunction<String> convertEnLong = (x) -> Long.parseLong(x);
		    	    	    System.out.println(convertEnLong.applyAsLong("1234567890123456"));
		    	    	    
		    	    	    /*
		    	    L'interface fonctionnelle BinaryOperator définit une opération qui attend deux paramètres et renvoie une valeur, ces éléments étant tous du même type.

L'interface BinaryOperator<T> est typée avec un generic qui précise le type des paramètres et de la valeur de retour. Elle hérite de l'interface fonctionnelle BiFunction<T, T, T>.

Elle définit la méthode fonctionnelle apply(T t, T u) qui renvoie une valeur de type T.
		    	    
		    	    */
		    	    	    BinaryOperator<Integer> ajout = (a, b) -> a + b;
		    	    	    System.out.println(ajout.apply(10, 20));
		    	    	    
		    	    	    //static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator)
		    	    	    //Renvoyer une BinaryOperator qui renverra le plus grand des deux objets selon le Comparator fourni en paramètre
		    	    	    
		    	    	    //static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator)
		    	    	    //Renvoyer une BinaryOperator qui renverra le plus petit des deux objets selon le Comparator fourni en paramètre
		    	    	    
		    	    	    Comparator<Integer> comparateur = (a, b) -> b - a;
		    	    	    
		    	    	    BinaryOperator<Integer> biMin = BinaryOperator.minBy(comparateur);
		    	    	    System.out.println(biMin.apply(2, 3));
		    	    	    
		    	    	    BinaryOperator<Integer> biMax = BinaryOperator.maxBy(comparateur);
		    	    	    System.out.println(biMax.apply(2, 3));
		    	    	    /*
		    	    	    L'interface fonctionnelle DoubleBinaryOperator définit une opération qui attend deux paramètres et renvoie une valeur, tous ces éléments étant de type double. C'est une spécialisation de l'interface fonctionnelle BinaryOperator pour le type double.
		    	    	    Elle définit la méthode fonctionnelle applyAsDouble(double left, double rigth) qui renvoie une valeur de type double.
*/
		    	    	    DoubleBinaryOperator surfaceRectangle =
		    	    	    	      (longueur, largeur) -> longueur * largeur;
		    	    	    	    System.out.println(surfaceRectangle.applyAsDouble(10.5, 20.2));
		    	    	    	    
		    	    	    	    /*
		    	    	    
		    	    	    L'interface fonctionnelle DoubleUnaryOperator définit une opération qui attend un paramètre et renvoie une valeur, ces deux éléments étant de type double. C'est une spécialisation de l'interface fonctionnelle UnaryOperator pour le type double.

Elle définit la méthode fonctionnelle applyAsDouble(double operand) qui renvoie une valeur de type double.
		    	    	    */
		    	    	    	    
		    	    	    	    DoubleUnaryOperator surfaceCarre = (cote) -> cote * cote;
		    	    	    	    System.out.println(surfaceCarre.applyAsDouble(10.5));
		    	    	    	    /*
		    	    	    	    default DoubleUnaryOperator andThen( DoubleUnaryOperator)
	

Renvoyer une DoubleUnaryOperator qui exécute en séquence l'instance courante et celle fournie en paramètre

default DoubleUnaryOperator compose(DoubleUnaryOperator)
	

Renvoyer une DoubleUnaryOperator qui exécute l'instance fournie en paramètre et applique l'instance courante sur le résultat

static DoubleUnaryOperator identity()
	

Renvoyer un DoubleUnaryOperator qui renvoie toujours la valeur fournie en paramètre
		    	    	    	    
		    	    	    	    */
/*
L'interface fonctionnelle IntBinaryOperator définit une opération qui attend deux paramètres et renvoie une valeur, ces deux éléments étant de type int. C'est une spécialisation de l'interface fonctionnelle BinaryOperator pour le type int.
Elle définit la méthode fonctionnelle applyAsInt(int left, int rigth) qui renvoie une valeur de type int.
*/
		    	    	    	    IntBinaryOperator surfaceRectangle1 = (longueur, largeur) -> longueur * largeur;
		    	    	    	    System.out.println(surfaceRectangle1.applyAsInt(10, 20));
		    	    	    	    /*
		    	    	    	    L'interface fonctionnelle IntUnaryOperator définit une opération qui attend un paramètre et renvoie une valeur, ces deux éléments étant de type int. C'est une spécialisation de l'interface fonctionnelle UnaryOperator pour le type int.

		    	    	    	    Elle définit la méthode fonctionnelle applyAsInt(int operand) qui renvoie une valeur de type int.
		    	    	    	    */
		    	    	    	    IntUnaryOperator surfaceCarre1 = (cote) -> cote * cote;
		    	    	    	    System.out.println(surfaceCarre1.applyAsInt(10));
		    	    	    	    /*
		    	    	    	    default IntUnaryOperator andThen(IntUnaryOperator)
	

Renvoyer une IntUnaryOperator qui exécute en séquence l'instance courante et celle fournie en paramètre

default IntUnaryOperator compose(IntUnaryOperator)
	

Renvoyer une IntUnaryOperator qui exécute l'instance fournie en paramètre et applique l'instance courante sur le résultat

static IntUnaryOperator identity()
	

Renvoyer une IntUnaryOperator qui renvoie toujours la valeur fournie en paramètre
		    	    	    	    
		    	    	    	    */
		    	    	    	    /*
		    	    	    	    L'interface fonctionnelle LongBinaryOperator définit une opération qui attend deux paramètres et renvoie une valeur, tous ces éléments étant de type long. C'est une spécialisation de l'interface fonctionnelle BinaryOperator pour le type long.

		    	    	    	    Elle définit la méthode fonctionnelle applyAsLong(long left, long right) qui renvoie une valeur de type entière longue.
		    	    	    	    */
		    	    	    	    
		    	    	    	    LongBinaryOperator surfaceRectangle2 = (longueur, largeur) -> longueur * largeur;
		    	    	    	    System.out.println(surfaceRectangle2.applyAsLong(10L, 20L));
		    	    	    	    
		    	    	    	    /*
		    	    	    	    L'interface fonctionnelle LongUnaryOperator définit une opération qui attend un paramètre et renvoie une valeur, tous ces éléments étant de type long. C'est une spécialisation de l'interface fonctionnelle UnaryOperator pour le type long.

Elle définit la méthode fonctionnelle applyAsLong(long operand) qui renvoie une valeur de type entière longue.
		    	    	    	    
		    	    	    	    */
		    	    	    	    LongUnaryOperator surfaceCarre2 = (cote) -> cote * cote;
		    	    	    	    System.out.println(surfaceCarre2.applyAsLong(10L));
		    	    	    	    
		    	    	    	    /*
		    	    	    	    default LongUnaryOperator andThen(LongUnaryOperator)
	

Renvoyer une LongUnaryOperator qui exécute en séquence l'instance courante et celle fournie en paramètre

default LongUnaryOperator compose(LongUnaryOperator)
	

Renvoyer une LongUnaryOperator qui exécute l'instance fournie en paramètre et applique l'instance courante sur le résultat

static LongUnaryOperator identity()
	

Renvoyer une LongUnaryOperator qui renvoie toujours la valeur fournie en paramètre
		    	    	    	    
		    	    	    	    */
		    	    	    	    
		    	    	    	    /*
		    	    	    	    L'interface fonctionnelle UnaryOperator définit une opération qui attend un paramètre et renvoie une valeur, tous ces éléments étant de même type.

L'interface UnaryOperator<T> est typée avec un generic qui précise le type du paramètre et de la valeur de retour. Elle hérite de l'interface fonctionnelle Function<T, T>.

Elle définit la méthode fonctionnelle apply(T t, T u) qui renvoie une valeur de type T.
		    	    	    	    
		    	    	    	    */
		    	    	    	    UnaryOperator<String> minuscule  = (c)-> c.toLowerCase();
		    	    	    	    System.out.println(minuscule.apply("TEST"));
		    	    	    	    /*
		    	    	    	    static <T> UnaryOperator<T> identity()
		    	    	    		Renvoyer une UnaryOperator qui renvoie toujours la valeur fournie en paramètre
		    	    	    		*/
		    	    	    	    
		    	    	    	    
	}
	
	
	
	

}
