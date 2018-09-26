package fab.the.chemist.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
Les interfaces fonctionnelles de type Consumer (Consumer, BiConsumer, DoubleConsumer, IntConsumer, LongConsumer, ObjDoubleConsumer, ObjIntConsumer, 
ObjLongConsumer) définissent des fonctions qui attendent différents types de paramètres et ne renvoient aucune valeur. Ne renvoyant aucune valeur, 
elles peuvent induire des effets de bords lors de l'exécution de leur traitement.
L'interface fonctionnelle Consumer<T> définit une fonction qui effectue une opération sur un objet et ne renvoie aucune valeur. Son exécution engendre 
généralement des effets de bord.
Elle définit la méthode fonctionnelle accept(T t) qui ne renvoie aucune valeur.
Elle définit aussi une méthode par défaut :

Méthode
default Consumer andThen(Consumer< ? super T>

Rôle
Renvoyer un Consumer qui exécute en séquence l'instance courante et celle fournie en paramètre

*/
public class LambdaFIConsumer {

	public static void main(String[] args) {
		
		Consumer<String> c0 = System.out::print;
	    c0.andThen(c0).accept("bonjour ");
	      
	    
	    AtomicInteger i = new AtomicInteger(0);
	    Consumer<String> c1 = (x) -> {
	      i.addAndGet(1);
	      System.out.println(x);
	      if (i.get() == 2) {
	        throw new RuntimeException();
	      }
	    };
	    c1.andThen(c1).accept("bonjour");
	    
	    Consumer<String> c = (x) -> {
	        System.out.println(x);
	        throw new RuntimeException();
	      };
	      c.andThen(c).accept("bonjour");
	    
	      
	    
	}
	/*
	 
Elle lève une exception de type NullPointerException si le paramètre de la méthode andThen() est null.
L'interface fonctionnelle BiConsumer définit une opération qui attend deux paramètres et ne renvoie aucun résultat. 
C'est une spécialisation de l'interface fonctionnelle Consumer qui attend deux paramètres.

L'interface BiConsumer<T,U> est typé avec deux generics qui précisent respectivement le type du premier et du second 
argument de l'opération de la fonction.

Elle définit la méthode fonctionnelle accept(T t, U u) qui ne renvoie aucune valeur.
Elle définit aussi une méthode par défaut :

Méthode
	default BiConsumer andThen(BiConsumer< ? super T>

Rôle
Renvoyer un BiConsumer qui exécute en séquence l'instance courante et celle fournie en paramètre

	L'interface fonctionnelle DoubleConsumer définit une opération qui attend en paramètre une valeur de type double et ne renvoie aucun résultat. 
	C'est une spécialisation de l'interface fonctionnelle Consumer qui attend une valeur flottante.
Elle définit la méthode fonctionnelle accept(double valeur) qui ne renvoie aucune valeur.
Elle définit aussi une méthode par défaut :

Méthode
default DoubleConsumer andThen(DoubleConsumer)

Rôle
Renvoyer un DoubleConsumer qui exécute en séquence l'instance courante et celle fournie en paramètre

L'interface fonctionnelle IntConsumer définit une opération qui attend en paramètre une valeur de type int et ne renvoie aucun résultat. C'est une spécialisation de l'interface fonctionnelle Consumer qui attend une valeur entière.
Elle définit la méthode fonctionnelle accept(int valeur) qui ne renvoie aucune valeur.
Elle définit aussi une méthode par défaut :

Méthode
	default IntConsumer andThen(IntConsumer)

Rôle
Renvoyer un IntConsumer qui exécute en séquence l'instance courante et celle fournie en paramètre

L'interface fonctionnelle LongConsumer définit une opération qui attend en paramètre une valeur de type long et ne renvoie aucun résultat. 
C'est une spécialisation de l'interface fonctionnelle Consumer qui attend une valeur entière longue.
Elle définit la méthode fonctionnelle accept(long valeur) qui ne renvoie aucune valeur.
Elle définit aussi une méthode par défaut :

Méthode
default LongConsumer andThen(LongConsumer)	

Rôle
Renvoyer un LongConsumer qui exécute en séquence l'instance courante et celle fournie en paramètre

L'interface fonctionnelle ObjDoubleConsumer<T> est une spécialisation de l'interface BiConsumer pour un objet et une valeur de type double. 
Elle définit la méthode fonctionnelle accept(T t, double value) qui ne renvoie rien.

L'interface fonctionnelle ObjIntConsumer<T> est une spécialisation de l'interface BiConsumer pour un objet et une valeur de type int. 
Elle définit la méthode fonctionnelle accept(T t, int value) qui ne renvoie rien.

L'interface fonctionnelle ObjLongConsumer<T> est une spécialisation de l'interface BiConsumer pour un objet et une valeur de type long. 
Elle définit la méthode fonctionnelle accept(T t, long value) qui ne renvoie rien. 
	 
*/

}
