package com.ibm.cruise;

import java.util.NoSuchElementException;


public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,3,5,6,8,9,12,24,17,19};
		System.out.println(binarySearch(array, 3, 0, 8));
		System.out.println(binarySearch0(array,24, 0, array.length));
	}
	
	/**
	 * recursive 
	 * @param sortArray
	 * @param des
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	public static int binarySearch(int[] sortArray, int des, int fromIndex, int toIndex){
		if(fromIndex<0||toIndex<0){
			throw new IllegalArgumentException("fromIndex & toIndex must larger than zero");
		}
		if(des<sortArray[fromIndex] || des>sortArray[toIndex]){
			throw new NoSuchElementException("can not search the element");
		}
		if(fromIndex <= toIndex){
			int midIndex = (fromIndex+toIndex)>>>1;
			int midValue = sortArray[midIndex];
			if(midValue < des){
				fromIndex = midIndex+1;
			}else if(midValue > des){
				toIndex = midIndex-1;
			}else{
				return midIndex;
			}
		}
		
		return binarySearch(sortArray, des, fromIndex, toIndex);
	}

	/**
	 * non-recursive
	 * @param sortedArray
	 * @param des
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	private static int binarySearch0(int[] sortedArray, int des, int fromIndex, int toIndex){
		int low = fromIndex;
		int high = toIndex - 1;
		while(low <= high){
			int midIndex = (low + high)>>>1;
			int midValue = sortedArray[midIndex];
			if(midValue>des){
				high = midIndex - 1;
			}else if(midValue < des){
				low = midIndex + 1;
			}else{
				return midIndex;
			}
		}
		return -1;
	}
}
