package 백만개의정수정렬_14229;

import java.util.List;
import java.util.Scanner;
import java.io.*;
public class Solution {
	
	static int[] list = new int[1000000];
//	static int[] tmp = new int[1000000];
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input_백만장자.txt"));
		for(int i=0; i<1000000; i++) list[i] = sc.nextInt();
		
		// 정렬 하고 싶은 배열의 범위를 설정
		quicksort(0, list.length-1);
		System.out.println(list[500000]);
		
		
		
		
	}

	private static void quicksort(int left, int right) {
		
		//해당 조건이 헷갈림. <= 이 아니라 <
		if(left<right) {
			int pivot = partition(left, right);
			quicksort(left, pivot-1);
			quicksort(pivot+1, right);
		}
		
	
	
}

	private static int partition(int left, int right) {
		//피봇 설정
		int pivot = list[left];
		int l = left+1; int r = right;
		
		//if로 해서 틀림. -> 무한 반복을 해야함.
		while(l<=r) {
			
			//pivot보다 큰 것을 찾을 때까지.
			while(list[l]<=pivot)l++;
			while(list[r]>pivot)r--;
			
			if(l<r) {
				//자리를 바꿔줌.
				int tmp = list[l];
				list[l] = list[r];
				list[r] = tmp;
			}
			
		}
		
		// 연산이 다 끝나고, 피봇과  r의 자리를 바꿔줘야함.
		int tmp = list[left];
		list[left] = list[r];
		list[r]=tmp;
		//피봇의 위치 인덱스를 반환
		return r;
		
		
		
	}

}