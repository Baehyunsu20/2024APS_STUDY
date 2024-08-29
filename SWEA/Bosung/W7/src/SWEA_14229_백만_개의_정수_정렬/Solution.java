package SWEA_14229_백만_개의_정수_정렬;

import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int[] arr = new int[1000000];
	static int N = arr.length;
	
	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		qS(0, N-1);
		System.out.println(arr[N/2]);
	}
	
	static void qS(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			qS(left, pivot-1);
			qS(pivot+1, right);
		}
	}
	
	static int partition(int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		for (int j = left; j < right; j ++) {
			if (arr[j] < pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		arr[right] = arr[i+1];
		arr[i+1] = pivot;
		return i+1;
	}
}
