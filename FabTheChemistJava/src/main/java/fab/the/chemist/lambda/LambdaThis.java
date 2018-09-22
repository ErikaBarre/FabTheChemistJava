package fab.the.chemist.lambda;

import java.util.function.LongFunction;

public class LambdaThis {

	 public static void main(String[] args) {
		 LambdaThis instance = new LambdaThis();
		    System.out.println(instance.toString());
		    instance.executer();    
		  }

		  public void executer() {
		    Runnable runnable = () -> { System.out.println(this.toString());};
		    Thread thread = new Thread(runnable);
		    thread.start();
		  }
		  
}
