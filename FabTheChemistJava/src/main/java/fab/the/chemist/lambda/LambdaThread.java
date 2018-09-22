package fab.the.chemist.lambda;

public class LambdaThread {

	public static void main(String[] args) {
		
		Thread monThread = new Thread(new Runnable() {
			@Override
			public void run(){
				System.out.println("Mon traitement");
			}
		});
		monThread.start();
		
		
		Thread monThread0 = new Thread(() -> { 
												System.out.println("Mon traitement21"); 
											});
		monThread0.start();
		
		
		//Les traitements d'une expression lambda peut contenir plusieurs opérations 
		//fqui doivent être regroupées dans un bloc de code entouré d'accolades comme pour le corps d'une méthode.
		Runnable monTraitement = () -> {
			  System.out.println("traitement 1");
			  System.out.println("traitement 2");};
		
	}
	
}
