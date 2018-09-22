package fab.the.chemist.lambda;

import java.util.function.Supplier;

public class LambdaSupplier {
	
	 public static void main(String[] args) {
		    Supplier<String> message = () -> "Bienvenue";
		    System.out.println(message.get());
		  }
	

}
