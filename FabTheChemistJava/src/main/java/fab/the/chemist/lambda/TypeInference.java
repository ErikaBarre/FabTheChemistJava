package fab.the.chemist.lambda;

public class TypeInference {

	//inference c'est le concept qui indique que le language à la compilation peut déterminer de lui le type du paramètre passé
	public static void main(String[] args) {
		
		StringLengthLambda myLambda0 = (String s) -> s.length();
		StringLengthLambda myLambda1 = (s) -> s.length(); //le type du param n'est pas obligatoire puisque definit dans l'interface , java le retrouve par inference
		StringLengthLambda myLambda2 = s -> s.length(); //si un seul param alors pas besoin de place des parametres. (parenthèses obligatoires si 0 ou 2 ou plus de param)
		
		printLambda(s -> s.length());
		
		System.out.println(myLambda0.getLength("gello plo"));
	}
	
	public static void printLambda(StringLengthLambda stringLengthLambda){
		System.out.println(stringLengthLambda.getLength("asedfrt yhjuik"));
	}
	
	interface StringLengthLambda{
		int getLength(String s);
	}
	
}
