package ie.gmit.dip;

public class Utilities {
	// Generates an array size n of random integers from 0 to 99
	public int[] randomArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		return array;
	}

	// Returns the average of the input array
	public double getAverage(double[] arr) {
		double total = 0;
		for (int i = 0; i < arr.length; i++) {
			total = total + arr[i];
		}
		double average = total / arr.length;
		return average;
	}
	
	// Prints the input array to the screen
	public void printArray(double[] arr) {
		for (double i : arr) {
			System.out.print(i + " ");
		}
	}
}