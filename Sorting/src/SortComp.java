//referenced Data Structures: Abstraction and Design Using Java, Second Edition El- liot B. Koffman, Paul A. T. Wolfgang Wiley 2010 as a guide in writing the code

import java.util.Random;

public class SortComp {
	//for merge sort
	int comparisonMerge = 0;
	int exchangeMerge = 0;
	long timeMerge = 0;
	
	int comparisonQuick = 0;
	int exchangeQuick = 0;
	long timeQuick = 0;

	//insertion sort
	public void insertionSort(int[] arr){
		int compInsert = 0;
		int exchInsert = 0;
		long startTime = System.nanoTime();
		
		for(int i = 1; i < arr.length; i++){
			for(int j = i; j > 0; j--){
				if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                    exchInsert++;
				}
				compInsert++;	
			}
		}
		long timeInsert = System.nanoTime() - startTime;		
		System.out.println("Insertion Sort made " + compInsert + " comparisons, " + exchInsert + " exchanges, and took " + timeInsert + " nanoseconds for array of size " + arr.length + "\n");
	
	}	
	
	//merge sort 
	public void mergeSort(int[] arr){
		long startTime = System.nanoTime();
		if(arr.length > 1){
			int half = arr.length / 2;
			int[] left = new int[half];
			int[] right = new int[arr.length - half];
			System.arraycopy(arr, 0, left, 0, half);
			System.arraycopy(arr, half, right, 0, arr.length - half);
			
			mergeSort(left);
			mergeSort(right);
			
			merge(arr, left, right);
			timeMerge = System.nanoTime() - startTime;	
		}
	}
	
	//merges the arrays in merge sort
	public void merge(int[] arr, int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int k = 0;
		for(int l = 0; l < arr.length; l++){
			 if (j >= right.length || (i < left.length && left[i] <= right[j])) {
	                arr[l] = left[i];   
	                i++;
	            } else {
	            	exchangeMerge++;
	                arr[l] = right[j];   
	                j++;
	            }
			comparisonMerge++;
		}
		
		
		while(i < left.length){
			arr[k++] = left[i++];
		}
		
		while(j < right.length){
			arr[k++] = right[j++];
		}
		
	}
	
	//calls quick sort
	public void quickSort1(int[] arr){
		long startTime = System.nanoTime();
		quickSort2(arr, 0, arr.length - 1);
		timeQuick = System.nanoTime() - startTime;
	}
	
	//does the actual quick sort
	public void quickSort2(int[] arr, int low, int high) {
		if(low < high){
			int piv = partition(arr, low, high);
			quickSort2(arr, low, piv - 1);
			quickSort2(arr, piv + 1, high);
		}		
	}
	
	//partitions arrays 
	public int partition(int[] arr, int low, int high){
		int pivot = arr[low];
		int up = low;
		int down = high;
		do{
			comparisonQuick++;
			while((up < high) && (pivot >= arr[up])){
				up++;
			}
			comparisonQuick++;
			while(pivot < arr[down]){
				down--;
			}
			if(up < down){
				swap(arr, up, down);
				exchangeQuick++;
				
			}
			
		} while(up < down);
		swap(arr, low, down);
		exchangeQuick++;
		return down;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	//prints data of quick sort
	public void dataQuick(int[] arr){
		System.out.println("Quick Sort made " + comparisonQuick + " comparisons, " + exchangeQuick + " exchanges, and took " + timeQuick + " nanosecond for an array of size " + arr.length + "\n" );

	}
	
	//prints data of merge sort
	public void dataMerge(int[] arr){
		System.out.println("Merge Sort made " + comparisonMerge + " comparisons, " + exchangeMerge + " exchanges, and took " + timeMerge + " nanosecond for an array of size " + arr.length + "\n" );

	}

	public static void main(String args[]){
		Random r = new Random();
		
		int[] test = {3, 2, 1};
		int[] test1 = {6, 5, 3, 2, 7, 1, 8, 4, 10, 9};
		
		int[] test2 = new int[100];
		for(int i = 0; i < 100; i++){
			int  n = r.nextInt(100) + 1;
			test2[i] = n;
		}
		
		int[] test3 = new int[1000];
		for(int i = 0; i < 1000; i++){
			int  n = r.nextInt(1000) + 1;
			test3[i] = n;
		}
		
		int[] test4 = new int[10000];
		for(int i = 0; i < 10000; i++){
			int  n = r.nextInt(10000) + 1;
			test4[i] = n;
		}
		
				
		
		//instances of class - needed to get instance data for comparisons and exchanges
		SortComp sc1 = new SortComp();
		SortComp sc2 = new SortComp();
		SortComp sc3 = new SortComp();
		SortComp sc4 = new SortComp();
	
		
		//insertion sort
		sc1.insertionSort(test1);
		sc1.insertionSort(test2);
		sc1.insertionSort(test3);
		sc1.insertionSort(test4);

	

		
		//merge sort
		sc1.mergeSort(test1);
		sc1.dataMerge(test1);
		
		sc2.mergeSort(test2);
		sc2.dataMerge(test2);
		
		sc3.mergeSort(test3);
		sc3.dataMerge(test3);
		
		sc4.mergeSort(test4);
		sc4.dataMerge(test4);
		
	
		
		
	
		//quick sort
		sc1.quickSort1(test1);
		sc1.dataQuick(test1);
	
		sc2.quickSort1(test2);
		sc2.dataQuick(test2);
		
		sc3.quickSort1(test3);
		sc3.dataQuick(test3);
		
		sc4.quickSort1(test4);
		sc4.dataQuick(test4);
		
	
	}
}
