package fab.the.chemist.GenericMethod;

public class App {

	public static void main(String[] args) {
		
		GenericMethod genericMethod = new GenericMethod();
		genericMethod.showItem(34.7);
		System.out.println("The returned item is: " + genericMethod.showItem(45));
		System.out.println("The returned item is: " + genericMethod.showItem('Z'));
		System.out.println("The returned item is: " + genericMethod.showItem("Sentence"));
		
		Integer[] integerArray = {3,4,5,2,1};
		genericMethod.showArray(integerArray);
		
		String[] names = {"Kevin","Joe","Adam","Smith"};
		
		genericMethod.showArray(names);
		
	}
}
