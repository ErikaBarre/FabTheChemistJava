package fab.the.chemist.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;

public class LambdaScopeVariable {

	public static void main(String[] args) {
		//1)
		afficher("Bonjour",5);	

		//2)
		// 
	    JButton bouton = new JButton("Incrementer");

	    Integer compteur = 0;
	    //bouton.addActionListener(event -> compteur++); //variable non accessible
	    
	    int compteur0 = 0;
	    compteur0++;
	    //bouton.addActionListener(event -> System.out.println(compteur0));  meme chose
	    
	    int[] compteur1 = new int[1];
	    bouton.addActionListener(event -> compteur1[0]++);  //accès dans le cas d'un talbeau (pas recommandée d'autant qu'elle n'est pas thread-safe.)
	    
	    AtomicInteger compteur2 = new AtomicInteger(0);
	    bouton.addActionListener(event -> compteur2.incrementAndGet());
	    
	    // 
	    
	    
	    //3)
	    //Les variables locales et les paramètres déclarés dans une expression lambda doivent l'être comme s'ils l'étaient dans le contexte englobant : 
	    //une expression lambda ne définit pas de nouvelle portée. Ainsi, il n'est pas possible de définir deux variables avec le même nom dans un même 
	    //bloc de code, donc il n'est pas possible de définir une variable dans l'expression lambda si celle-ci est déjà définie dans le contexte englobant.
	    
	    Personne p1 = new Personne("nom3","prenom3");
	    Personne p2 = new Personne("nom1","prenom1");
	    Personne p3 = new Personne("nom2","prenom2");
	    List<Personne> personnes = new ArrayList(3);
	    personnes.add(p1);
	    personnes.add(p2);
	    personnes.add(p3);
	    /*
	    Comparator<Personne> triParNom = (Personne p1,  Personne p2) -> {
	      return p2.getNom().compareTo(p1.getNom());
	    };
	    */
	    
		
		
	}
	
	public static void afficher(String message, int repetition) {
	    Runnable r = () -> {
	      for (int i = 0; i < repetition; i++) {
	        System.out.println(message);
	      }
	    };
	    new Thread(r).start();
	  }

}
