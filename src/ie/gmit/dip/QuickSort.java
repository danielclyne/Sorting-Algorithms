package ie.gmit.dip;

public class QuickSort { // Algorithm source -> https://www.baeldung.com/java-quicksort
	public void quickSort(int[] arr, int start, int end) {
		// Base condition. If there is only 1 value, it is already in sorted position.
		if (start >= end) {
			return;
		}
		// Rearrange values less than pivot on left and greater than on right of array.
		int pivot = partition(arr, start, end);

		// Recursively sort values in array that are less than pivot.
		quickSort(arr, start, pivot - 1);

		// Recursively sort values in array that are greater than pivot.
		quickSort(arr, pivot + 1, end);
	}

	public int partition(int[] arr, int start, int end) {
		// Set the final index value as the pivot.
		int pivot = arr[end];

		// Values less than the pointer will be swapped to the left of pointer.
		// Values greater than the pointer will remain to the right of pointer.
		int pointer = start;

		/*
		 * Iterate array up to before pivot. Every time an index value is less than or
		 * equal to the pivot, swap that index value with the pointer value and
		 * increment the pointer index.
		 */
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[pointer];
				arr[pointer] = temp;
				pointer++;
			}
		}

		// Swap the pivot with the pointer to place pivot in its sorted position.
		int temp = arr[end];
		arr[end] = arr[pointer];
		arr[pointer] = temp;

		// Return pointer which is now the index of the pivot value.
		return pointer;
	}
}