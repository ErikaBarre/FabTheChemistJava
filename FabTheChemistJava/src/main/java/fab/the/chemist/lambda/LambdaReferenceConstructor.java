package fab.the.chemist.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import fab.the.chemist.lambda.Personne;

public class LambdaReferenceConstructor {


	 public static void main(String[] args) {
		 
		 //unoiquement pour constructeur sans argument		 
		 Supplier<Personne> supplier = Personne::new;
		 System.out.println(supplier.get());
		 
		 //constructeur avec plusieur parametre 
		 PersonneSupplier supplierP = Personne::new;
		 Personne personne = supplierP.creerInstance("nom1", "prenom1");
		 System.out.println(personne);
		 
		 PersonneSupplier supplierP1 = (nom, prenom) -> new Personne(nom, prenom);
		 Personne personneP1 = supplierP1.creerInstance("nom1", "prenom1");
		 System.out.println(personneP1);
		 
		 
		 Supplier<Personne> supplier0 = () -> new Personne();
		 Supplier<Personne> supplier1 = () -> new Personne("","");
		 
		 //Supplier<Integer> I0 = Integer::new;
		 Supplier<Integer> I1 = () -> new Integer(0);
		 //Supplier<String> I2 =(String s) -> new Integer(s);
		 
		 Supplier<ArrayList<Personne>> supplier5 = ArrayList<Personne>::new;
		 Supplier<ArrayList<Personne>> supplier6 = () -> new ArrayList<Personne>(); 
		 
		 //Supplier<String[]> supplier7 = String[]::new;
		 //Supplier<> supplier8 = (int size) -> new String[size];
		 
		 
		 //generic
		 //MaFabrique<Integer[]> fabrique = Integer[]::new; 
		 //Integer[] entiers = fabrique.creerInstance(10);
		 //System.out.println("taille = "+entiers.length);
		 
		 
		 
		  }
	
}

interface MaFabrique<T> {
	  T creerInstance();
}