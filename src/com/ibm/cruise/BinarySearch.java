package com.ibm.cruise;

import java.util.NoSuchElementException;


public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,3,5,6,8,9,12,24,17,19};
		System.out.println(binarySearch(array, 1, 8, 3));

	}
	
	public static int binarySearch(int[] sortArray, int des, int fromIndex, int toIndex){
		if(fromIndex<0||toIndex<0){
			throw new IllegalArgumentException("fromIndex & toIndex must larger than zero");
		}
		if(des<sortArray[fromIndex] || des>sortArray[toIndex]){
			throw new NoSuchElementException("can not search the element");
		}
		if(fromIndex <= toIndex){
			int midIndex = (fromIndex+toIndex)>>1;
			int midValue = sortArray[midIndex];
			if(midValue < des){
				fromIndex = midIndex+1;
			}else if(midValue > des){
				toIndex = midIndex-1;
			}else{
				return midIndex;
			}
		}else{
			throw new IllegalArgumentException("fromIndex must smaller than toIndex");
		}
		
		return binarySearch(sortArray, des, fromIndex, toIndex);
	}

}
