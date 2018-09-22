package fab.the.chemist.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

public class LambdaReferenceStatic {

	public static void main(String[] args) {
		
		JButton monBouton = new JButton("Incrementer");
		
		monBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				  System.out.println("clic");
			}
		});
		
		
		monBouton.addActionListener(event -> System.out.println("clic"));
		
		//reference:
		monBouton.addActionListener(System.out::println);
		
		//2)
		//pour une methode static
		List<String> fruits = Arrays.asList("melon", "abricot", "fraise", "cerise");
	    afficher(fruits, (fmt, arg) -> String.format(fmt, arg));
	    afficher(fruits, String::format);
		
		//3)
	    //int[] valeurs = {10, 4, 2, 7, 5, 8, 1, 9, 3, 6}; //ne fonctionne pas avec primitif
	    Integer[] valeurs = {10, 4, 2, 7, 5, 8, 1, 9, 3, 6};
	    Arrays.sort(valeurs, Integer::compare);
	    System.out.println(Arrays.deepToString(valeurs));
		
	    Integer[] valeurs1 = {10, 4, 2, 7, 5, 8, 1, 9, 3, 6};
	    Arrays.sort(valeurs1, LambdaReferenceStatic::comparerEntierAscendant);
	    System.out.println(Arrays.deepToString(valeurs));
	    
	    //4)
	    LambdaReferenceStatic.executer();
		
		//appel d'un methode static en java8 peut s'écrire ainsi
	    LamdbaReferenceStatic:executer();	
		
		//avec le lambda
		//() -> executer();
	    
	    
	}
	
	public static void afficher(List<String> liste, MonFormateur formateur) {
	    int i = 0;
	    for (String element : liste) {
	      i++;
	      System.out.print(formateur.formater("%3d %s%n", i, element));
	    }
	  }
	
	public static int comparerEntierAscendant(int a, int b) {
	    return a - b;
	  }
	
	
	//4)
	static void executer() {
		System.out.println("execution de mon traitement par "+Thread.currentThread().getName());
	}

	
		
}

@FunctionalInterface
interface MonFormateur {
  String formater(String format, Object... arguments);
}


