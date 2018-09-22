package fab.the.chemist.introduction;

public class Generics2 {

	public static void add(int num1, int num2) {
		System.out.println("The sum is: " + (num1+num2));
	}
	public static void add2(double num1, int num2) {
		System.out.println("The sum is: " + (num1+num2));
	}
	
	public static void main(String[] args) {
		
		add(2, 5); //ceci ne pose pas problème car le résultat est 7 car il s'agit de 2 int
		//add2(2.5, 4); //erreur car multiplication entre int et double , ceci entraine l'écriture d'une nouvelle méthode 
		add2(2.5,4);
		//les generics ont pour but d'eviter de multiplier les methodes autant de fois que les type sont differents
	}
}
