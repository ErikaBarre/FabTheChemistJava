package fab.the.chemist.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaReferenceInstanceArbitraire {
	
	public static void main(String[] args) {
		
		String[] fruits = {"Melon", "abricot", "fraise", "cerise", "mytille"};
	    
		//syntaxe classique
		Arrays.sort(fruits, new Comparator<String>() {
	      @Override
	      public int compare(String s1, String s2) {
	        return s1.compareToIgnoreCase(s2);
	      }
	    });
	    System.out.println(Arrays.deepToString(fruits));
		
		 //syntaxe reference
		 Arrays.sort(fruits, String::compareToIgnoreCase);
		 System.out.println(Arrays.deepToString(fruits));   
		 
		 //syntaxe lambda
		 Arrays.sort(fruits, (s1, s2) -> s1.compareToIgnoreCase(s2) );
		 System.out.println(Arrays.deepToString(fruits));
	}

	//Ainsi this::equals est équivalent à l'expression lambda x -> this.equals(x).
	
}
