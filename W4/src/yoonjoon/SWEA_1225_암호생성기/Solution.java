package SWEA_1225_암호생성기;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			
			int N = sc.nextInt();
			
			MyQueue arm = new MyQueue(); 
		// MyQueue에서 arm 변수 지정 for문으로 0~7 8개 값 저장 
			for(int i = 0; i < 8; i++) {
				arm.enQueue(sc.nextInt()); 
			}
		//-i 후에 B에 값을 저장하고 deQueue로 뺀 후 enQueue로 추가
		int B;
		out:	
		while(true) {
			// - 1~부터 - 5까지 반복 
			for(int i = 1; i <=5; i++) {
				B = arm.deQueue() - i;
//				System.out.println("B: " + B);
				if(B <= 0) {
					// B가 0보다 작거나 같아질 경우 무조건 0을 가져야하기 때문에 
					// 0을 출력
					arm.enQueue(0);
					break out;					
				}
				arm.enQueue(B);
			}
		}// #과 N값 먼저 출력해주고 deQueue로 앞에서부터 값 가져오기
		System.out.print("#"+N);
		for(int i = 0; i < 8; i++) {
		System.out.print(" "+arm.deQueue());
		}
		System.out.println();
	}
	
}
}