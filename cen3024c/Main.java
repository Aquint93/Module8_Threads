package cen3024c;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Random random = new Random ();
		int [] array = new int [200000000];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10)+1;
		}
		
		long before = System.currentTimeMillis();
		System.out.println("Single Sum: "+SumClass.singleSum(array));
		System.out.println("Single Time: "+(System.currentTimeMillis()-before)+"\n");
		
		long start = System.currentTimeMillis();
		System.out.println("Parallel Sum: "+SumClass.parallelSum(array, Runtime.getRuntime().availableProcessors()));
		System.out.println("Parallel Time: "+(System.currentTimeMillis()-start));
	}

}
