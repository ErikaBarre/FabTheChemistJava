package fab.the.chemist.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaList {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++) {
			  System.out.println(list.get(i));
		}

		list.forEach(System.out::println);
		
		
		
	}

}
