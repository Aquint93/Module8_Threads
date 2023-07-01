package cen3024c;

public class SumClass extends Thread{
	private int[] array;
	private int start;
	private int end;
	private long sum;
	
	public SumClass(int[] arr, int start, int end) {
		array = arr;
		this.start= start;
		this.end = end;
		sum = 0;
	}
	
	public long getSum() {
		return sum;
	}
	
	@Override
	public void run() {
		for(int i = start; i < end; i++) {
			sum += array[i];
		}
	}
	
	public static long parallelSum(int[] arr, int numOfThreads) throws InterruptedException {
		int arraySize = arr.length;
		int chunkSize = arraySize/numOfThreads;
		SumClass[] threads = new SumClass[numOfThreads];
		
		for(int i = 0; i < numOfThreads; i++) {
			int start = i * chunkSize;
			int end = start + chunkSize;
			threads[i] = new SumClass(arr, start, end);
			threads[i].start();
		}
		
		long sum = 0;
		
		for(SumClass newThread : threads) {
			newThread.join();
			sum += newThread.getSum();
		}
		
		return sum;
	}
	
	public static long singleSum(int[] arr) {
		long sum = 0;
		
		for(int array : arr) {
			sum += array;
		}
		return sum;
	}	
}
