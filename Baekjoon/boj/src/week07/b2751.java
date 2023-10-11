package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class b2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		quick(arr, 0, N-1);
		for(int a: arr) {
			sb.append(a+"\n");
		}
		System.out.println(sb);
	}
	
	public static void quick(int arr[], int left, int right) {
		if(left<right) {
			int pivot = Lomuto(arr, left, right);
			quick(arr, left, pivot-1);
			quick(arr, pivot+1, right);
		}
	}
		
	public static int Lomuto(int arr[], int left, int right) {
		int pivot = arr[right];
		int i = left-1;
		
		for(int j = left; j < right; j++) {
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