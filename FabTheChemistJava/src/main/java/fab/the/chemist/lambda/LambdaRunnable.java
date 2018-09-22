package fab.the.chemist.lambda;

import java.lang.Thread;

public class LambdaRunnable {

	public static void main(String[] args) {
		
		

		Thread monThread = new Thread(new Runnable() {
		  //@Override
		  public void run(){
			  System.out.println("Mon traitement ");
		  }
		});
		monThread.start();

	}
	
	
	Thread monThread2 = new Thread(() -> { System.out.println("Mon traitement"); });
	//monThread2.;


}
