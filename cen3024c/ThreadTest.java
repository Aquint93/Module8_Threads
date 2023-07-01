package cen3024c;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

class ThreadTest {

	@Test
	public void testParallel() throws InterruptedException {
		Random random = new Random();
		int[] array = new int[200000000];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10)+1;
		}
		
		long expectedSum = SumClass.singleSum(array);
		long parallelSum = SumClass.parallelSum(array, Runtime.getRuntime().availableProcessors());
		
		Assertions.assertEquals(expectedSum, parallelSum);
	}

}
