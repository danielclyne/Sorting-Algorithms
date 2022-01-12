package ie.gmit.dip;

public class MergeSort { // Algorithm source -> https://www.codesdope.com/course/algorithms-merge-sort/

	public void mergeSort(int[] arr, int start, int end) { // Pass in array with the start and end index of array.
		if (start < end) { // Base case checks if array has more than 1 element.
			int middle = (start + end) / 2; // variable to hold the arrays middle index.
			mergeSort(arr, start, middle); // Recursively split array from start index to middle.
			mergeSort(arr, middle + 1, end); // Recursively split array from middle index + 1 to end.
			merge(arr, start, middle, end); // Merges the split arrays back together in sorted order.
		}
	}

	public void merge(int[] arr, int start, int middle, int end) {
		int tempArr1Size = ((middle + 1) - start); // Set size of temp arrays to size of split arrays.
		int tempArr2Size = (end - middle);

		int[] tempArr1 = new int[tempArr1Size]; // temp arrays to hold the values of the split arrays.
		int[] tempArr2 = new int[tempArr1Size];

		for (int i = 0; i < tempArr1Size; i++) { // Copy values from start to middle.
			tempArr1[i] = arr[start + i];
		}

		for (int i = 0; i < tempArr2Size; i++) { // Copy values from middle to end.
			tempArr2[i] = arr[middle + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = start;

		while (i < tempArr1Size && j < tempArr2Size) { // Keep running while i and j are less than the array sizes.
			if (tempArr1[i] < tempArr2[j]) { // If value of i in first temp array is less than j in second temp array.
				arr[k] = tempArr1[i]; // Add value of i to original array.
				i++; // increment index i.
			} else {
				arr[k] = tempArr2[j]; // Else if value of i is greater than j add value of j to original array.
				j++; // Increment index j.
			}
			k++; // Increment the index of the original array.
		}

		while (i < tempArr1Size) { // This will copy any leftover values in 1st temp array to end of arr.
			arr[k] = tempArr1[i]; // This will only run if there are leftovers.
			k++;
			i++;
		}

		while (j < tempArr2Size) { // This will copy any leftover values in 2nd temp array to end of arr.
			arr[k] = tempArr2[j]; // This will only run if there are leftovers.
			k++;
			j++;
		}
	}
}