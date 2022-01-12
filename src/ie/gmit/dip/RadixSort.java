package ie.gmit.dip;

public class RadixSort { // Algorithm source -> https://www.programiz.com/dsa/radix-sort
	// Method to return largest value in the input array.
	int getMaxValue(int arr[], int n) {
		int maxVal = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > maxVal)
				maxVal = arr[i];
		return maxVal;
	}

	// Method to implement radix sort.
	void radixSort(int arr[], int size) {
		int maxVal = getMaxValue(arr, size); // Return largest value in the input array.

		// Use counting sort to sort values based on place value.
		// Start at place of on ones then multiply by 10 each iteration.
		// If input array max value divided by the place is not > 0 break loop.
		// Each pass will sort the input array by place value.
		for (int place = 1; maxVal / place > 0; place = place * 10)
			countingSort(arr, size, place);
	}

	// Using counting sort to sort values by their place values.
	public void countingSort(int arr[], int size, int place) {
		int maxVal = getMaxValue(arr, size); // Find max value to get the range of the values in the input array.
		// Array to store frequency of each distinct place value in the input array.
		int[] count = new int[maxVal + 1]; // Array size is the max value + 1 to account for index 0.

		for (int i = 0; i < maxVal; i++) // Fill array with 0.
			count[i] = 0; // 0 is to be incremented each time a place value is a duplicate.

		for (int i = 0; i < size; i++) // Count the frequency of each distinct place value.
			/*
			 * The value at at arr[i] is divided by the place then modulus 10 to retrieve
			 * the place value. That place value is then use to get index of count array and
			 * that index value is incremented.
			 */
			count[(arr[i] / place) % 10]++;

		// Update count so that each index stores the sum of index + previous index.
		for (int i = 1; i < 10; i++)
			count[i] = count[i] + count[i - 1];

		int[] sortedArr = new int[size + 1]; // Array to store input array in sorted place value order.
		/*
		 * Get the place value at each index of input array starting from end of the
		 * array. Use the place value to find that index in count array. Subtract 1 from
		 * the value at that index in count array and use as the index to place the
		 * value from input array into sorted array.
		 */
		for (int i = size - 1; i >= 0; i--) {
			sortedArr[count[(arr[i] / place) % 10] - 1] = arr[i];
			count[(arr[i] / place) % 10]--; // Decrement the value at count index of place value.
		}
		// Copy the sorted values into original array.
		for (int i = 0; i < size; i++)
			arr[i] = sortedArr[i];
	}
}