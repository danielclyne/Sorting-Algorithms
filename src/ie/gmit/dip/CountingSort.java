package ie.gmit.dip;

public class CountingSort { // Algorithm source -> https://www.programiz.com/dsa/counting-sort

	public void countingSort(int[] arr, int size) {
		// Find the largest value to get the range of the values in the input array.
		int maxVal = arr[0];
		for (int i = 1; i < size; i++) {
			if (arr[i] > maxVal)
				maxVal = arr[i];
		}
		// Array to store frequency of each distinct value in the input array.
		int[] count = new int[maxVal + 1]; // Array size is the max value + 1 to account for index 0.

		for (int i = 0; i < maxVal; i++) { // Fill array with 0.
			count[i] = 0; // 0 is to be incremented each time a value is a duplicate.
		}

		for (int i = 0; i < size; i++) { // Count the frequency of each distinct value.
			count[arr[i]]++; // Increment value at index arr[i] of count e.g. arr[i] = 2, count[2]++.
		}
		// Update count so that each index stores the sum of index + previous index.
		for (int i = 1; i <= maxVal; i++) {
			count[i] = count[i] + count[i - 1];
		}

		int[] sortedArr = new int[size + 1]; // Array to store input array values in sorted order.
		/*
		 * Get the value at each index of input array starting from end of the array.
		 * Use the value to find that index in count array. Subtract 1 from the value at
		 * that index in count array. Use new value(count[arr[i]] -1) as the index to
		 * place the value from input array into sorted array.
		 */
		for (int i = size - 1; i >= 0; i--) {
			sortedArr[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--; // Decrement the value at count index of value arr[i].
		}
		// Copy the sorted values into original array.
		for (int i = 0; i < size; i++) {
			arr[i] = sortedArr[i];
		}
	}
}