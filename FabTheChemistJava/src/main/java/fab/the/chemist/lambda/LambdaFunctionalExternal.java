package fab.the.chemist.lambda;


//dans ce cas on utilise pas une functional interface de java mais on peut en definir une
public class LambdaFunctionalExternal {
	
	@FunctionalInterface
	  interface OperationEntiere {
	    long effectuer(int a, int b);
	  }

	  public long calculer(int a, int b, OperationEntiere operation) {
	    return operation.effectuer(a, b);
	  }

	  public static void main(String[] args) {
		  LambdaFunctionalExternal calc = new LambdaFunctionalExternal();
	    OperationEntiere addition = (a, b) -> a + b;
	    OperationEntiere soustraction = (a, b) -> a - b;

	    System.out.println(calc.calculer(10, 5, addition));
	    System.out.println(calc.calculer(10, 5, soustraction));
	  }
	

}
