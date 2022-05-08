package com.greatlearning.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class FloorAssembly {

	public void getAssembly(int[] floorSizesToAssemble) {
		int[] sortedFloorSizeArray = new int[floorSizesToAssemble.length];
		// Storing a copy of floor sizes in a new array and sorting that array
		for (int i = 0; i < floorSizesToAssemble.length; i++) {
			sortedFloorSizeArray[i] = floorSizesToAssemble[i];
		}
		sort(sortedFloorSizeArray, 0, sortedFloorSizeArray.length - 1);
		int max=0;
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> temp;
		for(int i=0;i<floorSizesToAssemble.length;i++)
		{
			System.out.println("Day: "+(i+1));
			temp = new ArrayList<Integer>();
			stack.push(floorSizesToAssemble[i]);

			while(max<sortedFloorSizeArray.length && !stack.isEmpty() && sortedFloorSizeArray[max]==stack.peek())
			{
				temp.add(stack.pop());
				max++;
			}
			if(!temp.isEmpty())
			{
				Collections.sort(temp, Collections.reverseOrder());
				for(int a:temp)
				{
					System.out.print(a+" ");
				}
			}
				
				System.out.println();
			
		}

	}

	// Merge sort
	void merge(int array[], int left, int mid, int right) {
		int leftArrSize = mid - left + 1;
		int rightArrSize = right - mid;

		int leftArr[] = new int[leftArrSize];
		int rightArr[] = new int[rightArrSize];

		for (int i = 0; i < leftArrSize; ++i)
			leftArr[i] = array[left + i];
		for (int j = 0; j < rightArrSize; ++j)
			rightArr[j] = array[mid + 1 + j];

		int i = 0, j = 0;

		int k = left;
		while (i < leftArrSize && j < rightArrSize) {
			if (leftArr[i] >= rightArr[j]) {
				array[k] = leftArr[i];
				i++;
			} else {
				array[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while (i < leftArrSize) {
			array[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < rightArrSize) {
			array[k] = rightArr[j];
			j++;
			k++;
		}
	}

	void sort(int array[], int left, int right) {
		if (left < right) {

			int mid = left + (right - left) / 2;

			sort(array, left, mid);
			sort(array, mid + 1, right);

			merge(array, left, mid, right);
		}
	}

}
