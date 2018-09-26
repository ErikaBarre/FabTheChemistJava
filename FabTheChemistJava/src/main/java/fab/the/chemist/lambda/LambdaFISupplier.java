package fab.the.chemist.lambda;

import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class LambdaFISupplier {

	private static final double DIX_MILLE = 10000;

	public static void main(String[] args) {
		/*
		L'interface fonctionnelle Supplier définit une fonction qui renvoie une valeur dont le type correspond au type générique.
		Elle définit la méthode fonctionnelle get() qui renvoie un objet de type T.
		*/
		 Supplier<String> message = () -> "Bienvenue";
		    System.out.println(message.get());

		/*
		L'interface Supplier ne permet de renvoyer que des objets. Plusieurs interfaces fonctionnelles la spécialisent pour retourner des valeurs primitives : 
		BooleanSupplier, DoubleSupplier, IntSupplier et LongSupplier.
		L'interface fonctionnelle BooleanSupplier est une spécialisation de l'interface Supplier pour une valeur primitive de type booléenne.
		Elle définit la méthode fonctionnelle getAsBoolean() qui renvoie une valeur de type boolean.
		*/
		 int a = 10;
		    int b = 12;
		    BooleanSupplier aInferieurAB = () -> a <= b;
		    System.out.println(aInferieurAB.getAsBoolean());

		/*
		L'interface fonctionnelle DoubleSupplier est une spécialisation de l'interface Supplier pour une valeur de type double.
		Elle définit la méthode fonctionnelle getAsDouble() qui renvoie une valeur flottante de type double.
		*/

		DoubleSupplier pi = () -> 3.14116;
		    System.out.println(pi.getAsDouble());

		/*
		L'interface fonctionnelle IntSupplier est une spécialisation de l'interface Supplier pour une valeur de type int.
		Elle définit la méthode fonctionnelle getAsInt() qui renvoie un entier de type int
		*/

		    IntSupplier aPlusB = () -> a + b;
		    System.out.println(aPlusB.getAsInt());
		/*
		L'interface fonctionnelle LongSupplier est une spécialisation de l'interface Supplier pour une valeur de type long.
		Elle définit la méthode fonctionnelle getAsLong() qui renvoie un entier de type long.
		*/

		    int a1 = 100000000;
		    LongSupplier aAuCarre = () -> (long) a1 * a1;
		    System.out.println(aAuCarre.getAsLong());

		
		
	}
	
}
