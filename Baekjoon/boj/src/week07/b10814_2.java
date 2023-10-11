package week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
	
public class b10814_2 {
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner sc = new Scanner(System.in);
	    int[] A = new int[1000000]; //100만개의 정수 주어짐
	    for(int i = 0; i < 1000000; i++) {
	        A[i] = sc.nextInt();
	    } //배열 입력
	    
	    quick(A, 0, 999999);
	    System.out.println(A[500000]);
	}

	public static void quick(int A[], int left, int right) {
		if(left<right) {
			int pivot=Lomuto(A, left, right);
			quick(A, left, pivot-1);
			quick(A, pivot+1, right);
		}
	}
	
	public static int Lomuto(int arr[], int left, int right) {
	    int pivot = arr[right];
	    int i = left-1;
	    
	    for(int j  = left; j <= right-1; j++) {
	        if(arr[j]<=pivot) {
	            i++;
	            int tmp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = tmp;
	        }
	    }
	    int tmp = arr[i+1];
	    arr[i+1] = arr[right];
	    arr[right] = tmp;
	    return i+1;
	}
}