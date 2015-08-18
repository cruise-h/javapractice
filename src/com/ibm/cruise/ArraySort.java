package com.ibm.cruise;

public class ArraySort {

	public static int[] mergeList(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				result[k++] = a[i++];
			} else {
				result[k++] = b[j++];
			}

		}

		while (i < a.length) {
			result[k++] = a[i++];
		}

		while (j < b.length) {
			result[k++] = b[j++];
		}
		return result;
	}
	
	public static void println(int[] array){
		for(int a : array){
			System.out.print(a+" ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 2, 2, 3, 5, 6, 7, 7 };
		int b[] = { 1, 2, 4, 5, 8, 8, 9, 10, 11, 12, 12, 13, 14 };
		int[] result = mergeList(a, b);
		println(result);
	}

}
