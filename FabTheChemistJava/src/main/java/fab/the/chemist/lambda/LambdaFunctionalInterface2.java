package fab.the.chemist.lambda;

//Les méthodes publiques de la classe Object peuvent cependant être redéfinies dans une interface fonctionnelle.
@FunctionalInterface
public interface LambdaFunctionalInterface2 {
	 String executer();
	  boolean equals(Object obj);
	  //exccepté Object clone(); car cette methode de Object est protected et pas public

}
