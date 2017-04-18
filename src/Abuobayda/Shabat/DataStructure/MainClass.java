/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Abuobayda.Shabat.DataStructure;

import java.util.Arrays;

/**
 *
 * @author Abuobayda Shabat
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = new int[5];
        array[0]=10;
        array[1]=5;
        array[2]=2;
        array[3]=15;
        array[4]=3;
        //mergeSort(array);
        //shellSort(array);
        //insertionSort(array);
        selectionSort(array);
        
        for(int i=0; i<array.length;i++){
            System.out.println("item "+(i+1)+": "+ array[i]);
        }
    }
    // Arranges the elements of the given array into sorted order
	// using the "merge sort" algorithm, which splits the array in half,
	// recursively sorts the halves, then merges the sorted halves.
	// It is O(N log N) for all inputs.
	public static void mergeSort(int[] a) {
		if (a.length >= 2) {
			// split array in half
			int[] left  = Arrays.copyOfRange(a, 0, a.length / 2);
			int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);
			
			// sort the halves
			mergeSort(left);
			mergeSort(right);
			
			// merge them back together
			int i1 = 0;
			int i2 = 0;
			for (int i = 0; i < a.length; i++) {
				if (i2 >= right.length ||
						(i1 < left.length && left[i1] < right[i2])) {
					a[i] = left[i1];
					i1++;
				} else {
					a[i] = right[i2];
					i2++;
				}
			}
		}
	}
	
	
	// Arranges the elements of the given array into sorted order
	// using the "shell sort" algorithm, which creates slices of
	// the array separated by a given gap and insertion-sorts by
	// that gap, eventually ending in a normal insertion sort.
	// It is O(N^1.25) on average.
	public static void shellSort(int[] a) {
		for (int gap = a.length / 2; gap >= 1; gap = gap / 2) {
			// insertion sort on every gap'th element
			for (int i = gap; i < a.length; i++) {
				int temp = a[i];
				int j = i;
				while (j >= gap && a[j - gap] > temp) {
					a[j] = a[j - gap];
					j -= gap;
				}
				a[j] = temp;
			}
		}
	}
	
	
	
	// Arranges the elements of the given array into sorted order
	// using the "insertion sort" algorithm, which manages a sorted
	// prefix of the array, and one at a time, shifts each next element
	// to be in the right ordered place within that sorted prefix
	// until the entire array is sorted.
	// It is O(N^2) but faster (O(N)) for sorted inputs.
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			// move a[pass] into its proper place,
			// assuming that a[0]..a[pass-1] are sorted
			int temp = a[i];
			int j = i;
			while (j >= 1 && a[j - 1] > temp) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
	}
	
	// Arranges the elements of the given array into sorted order
	// using the "selection sort" algorithm, which makes sweeps over
	// the array, finding the i'th smallest element each time,
	// and swapping it to be stored at index i.
	// It is O(N^2) for all inputs.
	public static void selectionSort(int[] a) {
		for (int pass = 0; pass < a.length; pass++) {
			// figure out what should go into a[pass]
			int min = pass;
			for (int j = pass + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			
			swap(a, pass, min);
		}
	}
	
	
	
	// Swaps the values at the two given indexes in the given array.
	private static final void swap(int[] a, int i, int j) {
		if (i != j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
	
	
	// Returns true if the given array is in sorted ascending order.
	private static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	
}
