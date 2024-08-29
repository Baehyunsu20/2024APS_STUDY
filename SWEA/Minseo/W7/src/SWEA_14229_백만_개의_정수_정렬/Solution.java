package SWEA_14229_백만_개의_정수_정렬;

import java.util.Scanner;

public class Solution {
	
	static int[] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 백만개의 정수 입력받기
		A = new int[1000000];
		for(int i=0;i<1000000;i++) {
			A[i]=sc.nextInt();
		}
		
		// 숫자가 백만개니까 퀵정렬 사용
		quickSort(0,999999);
		System.out.println(A[500000]);
		
	}
	static void quickSort(int left, int right) {
		if(left<right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1,right);
		}
	}
	static int partition(int left, int right) {
		// 초기값 설정
		int pivot = A[left];
		int L = left+1, R = right;
		while(L<=R) {
			while(L<=R&&A[L]<=pivot) {
				L++;
			}
			while(A[R]>pivot) {
				R--;
			}
			if(L<R) {
				int tmp = A[L];
				A[L]=A[R];
				A[R]=tmp;
			}
		}
		int tmp=A[left];
		A[left]=A[R];
		A[R]=tmp;
		
		return R;		
	}

}