package ie.gmit.dip;

public class BubbleSort { // Algorithm source -> Sorting Algorithms Part 2 Lecture on Moodle

	public void bubbleSort(int[] arr) { // Pass in the array to be sorted.
		for (int outer = arr.length - 1; outer > 0; outer--) { // Loop to access each value.
			for (int inner = 0; inner < outer; inner++) { // Loop to compare values at each index.
				if (arr[inner] > arr[inner + 1]) { // If value of index inner is greater than value of index inner + 1.
					int temp = arr[inner]; // Store inner in the variable temp.
					arr[inner] = arr[inner + 1]; // Set inner equal to the value at inner + 1.
					arr[inner + 1] = temp; // Set inner + 1 equal to the value stored in the variable temp.
				}
			}
		}
	}
}