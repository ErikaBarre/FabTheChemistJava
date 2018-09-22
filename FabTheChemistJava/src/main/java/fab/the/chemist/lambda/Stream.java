package fab.the.chemist.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Stream {

	public static void main(String[] args) {
		
		List<Personne> people = 
				Arrays.asList(
						new Personne("Charles", "Dickens",60)
						
						);
		
		people.stream().forEach(System.out::println);
		
		people.stream().forEach(p -> System.out.println(p.getNom()));
		
		people.stream()
					.filter(p -> p.getNom().startsWith("C"))
					.forEach(p -> System.out.println(p.getNom()));
		
		long l =people.stream()
		.filter(p -> p.getNom().startsWith("C"))
		.count();
		
		
		long l2 =people.parallelStream()
				.filter(p -> p.getNom().startsWith("C"))
				.count();
		
	}
		
}
