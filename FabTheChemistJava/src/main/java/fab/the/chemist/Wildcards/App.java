package fab.the.chemist.Wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App {

	/**
	 * 1.) WILDCARDS

		The problems and the most important fact about generics

			Collection<String> c1 = new ArrayList<>();
			Collection<Object> c2 = c1  it is not valid !!!
				String is an Object but a Collection<String> is not a Collection<Object> !!!
				

		So a List<Employee> is not a List<Person> even when the Employee class extends the Person class
			THIS IS WHY WILDCARDS HAVE CAME TO BE 


	à cette méthode il est impossible de passer une collection de string ou une collection de double 
	car une collection de string n'étend pas une collection d'object (meme si un string étend un object)
		print(Collection<Object> c)
			for i in c
				print i

		It is not generic in the sense that we can not print list of integers or list of doubles
			or list of custom objects -> we have to cast them to Object before calling that method

			COLLECTION OF OBJECT IS NOT A SUPERTYPE OF ALL KINDS OF COLLECTIONS !!!
				The supertype of all lkinds of collections -> wildcard

		print(Collection<?> c)
			for i in c:
				print i		we can do it we can print out whatever we want, BUT we cannot insert to that 
							collection whatever we want because we don't know what type will be passed in
								Sole exception: NULL

		c.add(new Object()) this will cause compile time error 


		public interface Shape() {
			public void draw();
		}

		class Circle extends Shape {
			draw:
				print "Drawing a circle...";
		}
		
		class Rectangle extends Shape {
			draw:
				print "Drawing a rectangle...";
		}
		

		drawAll(List<Shape> l)
			for i in l
				i.draw()

			This is going to work only for Shapes but not for classes that implements that given
				Shape interface
					--> we can not call this method on List<Rectangle> for example
						THIS IS WHY BOUNDED WILDCARDS HAVE CAME TO BE !!!
		

		-------------------------------------------------------------------------------------------------------	
	 * 
	 * 
	 * 
	 */
	
	//EXEMPLE 1
	public void print0(Collection<Object> c){
		for (Object i : c){
			System.out.println();
		}
	}
	
	public void callPrint0(){
		Collection<Integer> colI = new ArrayList<Integer>();
		colI.add(45);
		colI.add(90);
		//print0(colI); nous voyons déjà que nous avons une erreur à la compil, on DOIT passer une collection d'object
	}
	// FIN EXEMPLE 1
	
	//EXEMPLE 2
	public void print1(Collection<?> c){
		for (Object i : c){
			System.out.println(i);
		}
		
		//c.add(135); //par contre on remarquera qu'on ne peut pas ajouter d'element supplémentaire car java à ce stade ne peut pas deviner de quel type uil s'agit
		//c.add(new Object()); //meme ce type d'ajout est impossible
		
		//on peut lire les object uniquement en bouclant mais on ne peut pas les modifier
		
		//c.get(0) ; cette méthode est également impossible, pour lire un element particulier. (quoique get n'est pas une methode collection)
		//voir fichier App2.java pour 
	}
	
	public void callPrint1(){
		Collection<Integer> colI = new ArrayList<Integer>();
		colI.add(45);
		colI.add(90);
		print1(colI); //dans ce cas avec le wildcard, nous voyons que nous pouvons passer une liste d'une collection d'un type qui étends un autre type
	}
	// FIN EXEMPLE 2
	
	//EXEMPLE 2.2
		public void print2(Collection<?> c){
			/*
			for (Number i : c){    //cela fonctionne avec un type object mais avec autre chose nous dejà bloque car java ne peut pas deviner le type contenu dans l'object
				System.out.println(i);
			}
			*/
			//finalement dans ce cas, tout forme de lecture et manipulation est impossible
		}
		
		public void callPrint2(){
			Collection<Integer> colI = new ArrayList<Integer>();
			colI.add(45);
			colI.add(90);
			print2(colI); //dans ce cas avec le wildcard, nous voyons que nous pouvons passer une liste d'une collection d'un type qui étends un autre type
		}
		// FIN EXEMPLE 2.2
	
	//EXEMPLE 3
	public static void print(Collection<? extends Shape> c) {
		for(Object o : c)
			System.out.println(o);
				
		
	}
	
	
	public static void main(String[] args) {
		
		List<Circle> l = new ArrayList();
		
		App.print(l);
		
	}
}

class Circle implements Shape {

	//@Override
	public void draw() {
		
	}
	
}

interface Shape {
	public void draw();
}
