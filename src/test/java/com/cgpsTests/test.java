package com.cgpsTests;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class test {

	public static void main(String[] args) {
	
		int[]intArray =  {5,3,7,-12,9,-22,14};
		
		for (int index =  intArray.length-1; index > 0; index--) {
			for (int j = 0; j < index; j++) {
				//System.out.println(intArray[6]);
				if (intArray[j]>intArray[j+1]) {
					swap(intArray, j, j+1);
				}
			}
		}
		for (int j = 0; j <= intArray.length-1; j++) {
			System.out.println(intArray[j]);
		}
		
	}
	
	public static void swap (int[] array, int i, int j) {
		if (i==j) {
			return;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
