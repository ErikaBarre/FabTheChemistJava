package fab.the.chemist.lambda;

public class App1 {

	/*
	 * lambda permet l'établissement de la programmation fonctionel
	 * rend le code plus concis et lisible
	 * capable de supporter des process en parallele
	 * 
	 * POO
	 * tout est object
	 * tout les black de code sont associée à des classes et des objects
	 * 
	 * 
	 */
	
	public void App1(){
		System.out.println("test txt");
	}
	
	public void App11(Greeting greeting){
		greeting.perform();
	}
	
	public static void main(String[] args) {
		App1 app1 = new App1();
		app1.App1();
		
		Greeting greeting = new GreetingImpl();
		app1.App11(greeting);

		//java retrouve la fonction car dans l'interface une methode ne possede aucun argument
		//MyLambda myLambdaFunction = () -> System.out.println("test txt1");
		//MyLambdaAdd myLambdaFunction2 = (int a, int b) -> a + b;
		
		//avec interface definie dans un autre fichier
		//Greeting greetg = () -> System.out.println("test txt1") ;
		//on deinit qu'une methode par interface avec les lambda 
		//(java n'est pas fout de voir qu'un methode avec un nimbre de parametres different est forcément une methode avec une signature differentes)
		//Greeting greetg2 = (1, 3) ->  ;  => erreur car ne peut pas faire la different entre les 2 methodes
		
		//le lambda sert à remplacer 2 type d'écriture 
		//soit l'intanciation d'une classe implementant une interface, 
		//soit l'implémentation d'une interface qui nous oblige a developper le contenu :
		Greeting greeting23 = new Greeting() {
			
			public void perform() {
								
			}
			
		};
		
		
		
	}

	
}

interface MyLambda{
	void foo();
	
}

interface MyLambdaAdd{
	
	int foo(int a, int b);
}
