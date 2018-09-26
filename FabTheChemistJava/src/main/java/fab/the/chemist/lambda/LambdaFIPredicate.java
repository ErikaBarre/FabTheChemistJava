package fab.the.chemist.lambda;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

/*
Les interfaces fonctionnelles de type Predicate (Predicate, BiPredicate, DoublePredicate, IntPredicate, LongPredicate) définissent des fonctions 
qui attendent différents types de paramètres et renvoient une valeur booléenne.
L'interface fonctionnelle Predicate<T> définit une fonction qui effectue une opération sur un objet et renvoie une valeur booléenne.
Elle définit la méthode fonctionnelle test(T t) qui renvoie un booléen.
Elle définit aussi plusieurs méthodes par défaut ou static :

default Predicate<T> and(Predicate< ? super T>)
Renvoyer un Predicate qui exécute en séquence l'instance courante et celle fournie en paramètre en effectuant un ET logique sur leurs résultats. 
Si le prédicat courant est false alors celui fourni en paramètre n'est pas évalué. Une exception levée par l'un des deux est propagée à l'appelant. 
Si une exception est levée lors de l'exécution du premier prédicat, le second n'est pas évalué.

static <T> Predicate<T> isEqual(Object)
Renvoyer un Predicate qui teste l'égalité de l'objet fourni en paramètre et de celui passé en paramètre de la méthode test() en utilisant la méthode Objects.equals()

default Predicate<t> negate()
Renvoyer un Predicate qui exécute l'instance courante en effectuant un NOT logique sur son résultat

default Predicate<T> or(Predicate< ? super T>)
Renvoyer un Precidate qui exécute en séquence l'instance courante et celle fournie en paramètre en effectuant un OU logique sur leurs résultats. 
Si le prédicat courant est true alors celui fourni en paramètre n'est pas évalué. Une exception levée par l'un des deux est propagée à l'appelant. 
Si une exception est levée lors de l'exécution du premier prédicat, le second n'est pas évalué.

*/
public class LambdaFIPredicate {

	private static final long DIX_MILLE = 10000;

	public static void main(String[] args) {
		 Predicate<String> possedeTailleTrois = s -> s.length() == 3;
		    Predicate<String> contientX = s -> s.contains("X");
		    Predicate<String> estNonNull = Objects::nonNull;
		    Predicate<String> contientXOuTaille3 = contientX.or(possedeTailleTrois);
		    Predicate<String> estSMS = Predicate.isEqual("SMS");

		    System.out.println("1 "+contientX.negate().test("WXYZ"));
		    System.out.println("2 "+contientX.or(possedeTailleTrois).test("WWW"));
		    System.out.println("2 "+contientX.or(possedeTailleTrois).test("WX"));
		    System.out.println("3 "+contientX.and(possedeTailleTrois).test("WXY"));
		    System.out.println("3 "+contientX.and(possedeTailleTrois).test("WWW"));
		    System.out.println("4 "+estNonNull.test(null));
		    System.out.println("5 "+estNonNull.and(contientX).and(possedeTailleTrois)
		    .test("WWW"));
		    System.out.println("5 "+estNonNull.and(contientX).and(possedeTailleTrois)
		    .test("XX"));
		    System.out.println("5 "+estNonNull.and(contientX).and(possedeTailleTrois)
		    .test(null));
		    System.out.println("6 "+estNonNull.and(contientXOuTaille3).test("WWW"));
		    System.out.println("6 "+estNonNull.and(contientXOuTaille3).test("XX"));
		    System.out.println("6 "+estNonNull.and(contientXOuTaille3).test(null));
		    System.out.println("7 "+estNonNull.and(contientX.or(possedeTailleTrois))
		    .test("WWW"));
		    System.out.println("7 "+estNonNull.and(contientX.or(possedeTailleTrois))
		    .test("XX"));
		    System.out.println("7 "+estNonNull.and(contientX.or(possedeTailleTrois))
		    .test(null));
		    System.out.println("8 "+estSMS.test("SMS"));
		    System.out.println("8 "+estSMS.test("ABC"));
		    System.out.println("8 "+estSMS.test(null));
		    
		    /*
		    L'interface fonctionnelle BiPredicate définit une opération qui attend deux paramètres et renvoie une valeur booléenne. 
		    C'est une spécialisation de l'interface fonctionnelle Predicate qui attend deux paramètres.
		    L'interface BiPredicate<T,U> est typé avec deux generic qui précisent respectivement le type du premier et du second argument de l'opération de la fonction.
		    Elle définit la méthode fonctionnelle test(T t, U u) qui renvoie un booléen.
		    Elle définit aussi plusieurs méthodes par défaut :

		    default BiPredicate<T, U> and(BiPredicate< ? super T, ? super U>)
		    Renvoyer un BiPredicate qui exécute en séquence l'instance courante et celle fournie en paramètre en effectuant un ET logique sur leurs résultats. 
		    Si le prédicat courant est false alors celui fourni en paramètre n'est pas évalué. Une exception levée par l'un des deux est propagée à l'appelant. 
		    Si une exception est levée lors de l'exécution du premier prédicat, le second n'est pas évalué.

		    default BiPredicate<T, U> negate()
		    Renvoyer un BiPredicate qui exécute l'instance courante en effectuant un NOT logique sur son résultat

		    default BiPredicate<T, U> or(BiPredicate< ? super T, ? super U>)
		    Renvoyer un BiPrecidate qui exécute en séquence l'instance courante et celle fournie en paramètre en effectuant un OU logique sur leurs résultats. 
		    Si le prédicat courant est true alors celui fourni en paramètre n'est pas évalué. Une exception levée par l'un des deux est propagée à l'appelant. 
		    Si une exception est levée lors de l'exécution du premier prédicat, le second n'est pas évalué.
		    */
		        BiPredicate<Integer, Integer> estSupOuEgal = (x, y) -> x >= y;
		        BiPredicate<Integer, Integer> estLaMoitie = (x, y) -> x == y * 2;

		        System.out.println("1 " + estSupOuEgal.test(2, 3));
		        System.out.println("1 " + estSupOuEgal.test(3, 2));

		        System.out.println("2 " + estSupOuEgal.and(estLaMoitie).test(4, 2));
		        System.out.println("2 " + estSupOuEgal.and(estLaMoitie).test(3, 2));

		        System.out.println("3 " + estSupOuEgal.negate().test(3, 2));

		        System.out.println("4 " + estSupOuEgal.or(estLaMoitie).test(1, 1));
		        System.out.println("4 " + estSupOuEgal.or(estLaMoitie).test(4, 2));
		        System.out.println("4 " + estSupOuEgal.or(estLaMoitie).test(2, 4));

		    /*
		    L'interface fonctionnelle DoublePredicate définit une opération qui attend un nombre flottant et renvoie une valeur booléenne. 
		    C'est une spécialisation de l'interface fonctionnelle Predicate pour un nombre flottant.
		    Elle définit la méthode fonctionnelle test(double) qui renvoie un booléen.
		    Elle définit aussi des méthodes par défaut :

		    default DoublePredicate and(DoublePredicate)
		    Renvoyer un DoublePredicate qui exécute en séquence l'instance courante et celle fournie en paramètre en effectuant un ET logique sur leurs résultats. 
		    Si le prédicat courant est false alors celui fourni en paramètre n'est pas évalué. Une exception levée par l'un des deux est propagée à l'appelant. 
		    Si une exception est levée lors de l'exécution du premier prédicat, le second n'est pas évalué.

		    default DoublePredicate negate()
		    Renvoyer un DoublePredicate qui exécute l'instance courante en effectuant un NOT logique sur son résultat

		    default DoublePredicate or(DoublePredicate)
		    Renvoyer un DoublePredicate qui exécute en séquence l'instance courante et celle fournie en paramètre en effectuant un OU logique sur leurs résultats. 
		    Si le prédicat courant est true alors celui fourni en paramètre n'est pas évalué. Une exception levée par l'un des deux est propagée à l'appelant. 
		    Si une exception est levée lors de l'exécution du premier prédicat, le second n'est pas évalué.
		    */

		        DoublePredicate estPositif = valeur -> valeur >= 0;
		        DoublePredicate vautDixMille = valeur -> valeur == DIX_MILLE;

		        System.out.println(estPositif.test(DIX_MILLE));
		        System.out.println(estPositif.and(vautDixMille).test(DIX_MILLE));
		        System.out.println(estPositif.negate().test(DIX_MILLE));
		        System.out.println(estPositif.or(vautDixMille).test(100L));

		    /*
		    L'interface fonctionnelle LongPredicate définit une opération qui attend un entier et renvoie une valeur booléenne. 
		    C'est une spécialisation de l'interface fonctionnelle Predicate pour un entier long.
		    Elle définit la méthode fonctionnelle test(long) qui renvoie un booléen.
		    Elle définit aussi des méthodes par défaut :

		    default LongPredicate and(LongPredicate)
		    Renvoyer un LongPredicate qui exécute en séquence l'instance courante et celle fournie en paramètre en effectuant un ET logique sur leurs résultats. 
		    Si le prédicat courant est false alors celui fourni en paramètre n'est pas évalué. Une exception levée par l'un des deux est propagée à l'appelant. 
		    Si une exception est levée lors de l'exécution du premier prédicat, le second n'est pas évalué.

		    default LongPredicate negate()
		    Renvoyer un LongPredicate qui exécute l'instance courante en effectuant un NOT logique sur son résultat

		    default LongPredicate or(DoublePredicate)
		    Renvoyer un LongPredicate qui exécute en séquence l'instance courante et celle fournie en paramètre en effectuant un OU logique sur leurs résultats. 
		    Si le prédicat courant est true alors celui fourni en paramètre n'est pas évalué. Une exception levée par l'un des deux est propagée à l'appelant. 
		    Si une exception est levée lors de l'exécution du premier prédicat, le second n'est pas évalué.
		    */
		        LongPredicate estPositif1 = valeur -> valeur >= 0;
		        LongPredicate vautDixMille1 = valeur -> valeur == DIX_MILLE;

		        System.out.println(estPositif1.test(DIX_MILLE));
		        System.out.println(estPositif1.and(vautDixMille1).test(DIX_MILLE));
		        System.out.println(estPositif1.negate().test(DIX_MILLE));
		        System.out.println(estPositif1.or(vautDixMille1).test(100L));

		
		
	}
	
}
