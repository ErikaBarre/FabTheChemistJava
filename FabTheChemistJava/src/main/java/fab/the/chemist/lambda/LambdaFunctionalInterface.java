package fab.the.chemist.lambda;

//l'annotation n'est pas obligatoire, java reconnait le type d'interface dont il s'agit mais il est recommender d'ajouter l'annotation
//Une interface fonctionnelle ne peut pas avoir plus d'une méthode abstraite. Si plusieurs méthodes abstraites sont définies dans l'interface, celle-ci ne sera pas une interface fonctionnelle.

@FunctionalInterface
public interface LambdaFunctionalInterface {
	public void firstMethod();
	//public void secondMethod();

}
