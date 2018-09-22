package fab.the.chemist.lambda;

public class Closures {

	 public static void main(String[] args) {
		 int a = 10;
		 int b = 20;
		 
		 doProcess(a, new Process() {
			@Override
			public void Process(int i) {
				System.out.println(i + b);
			}
		 });
		 
		 doProcess(a, i ->  System.out.println(i + b));
		 
	 }
	 
	 public static void doProcess(int i , Process p) {
		 p.Process(i);
	 }
	
	
}

interface Process {
	void Process(int i);
}
