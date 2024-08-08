package SWEA_8931_제로;

import java.util.Scanner;

public class Solution {
	
	// 메인 메소드
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 입력
		int t = sc.nextInt();
		
		// 수의 합을 저장할 sumarr 배열 만들기
		int[] sumarr = new int[t];
		
		for (int i=0; i<t; i++) {
			
			int K = sc.nextInt();
			
			// K개의 정수를 입력받아 0이 아니면 stack에 push, 0이면 pop 하기
			for (int j=0; j<K; j++) {
				int num = sc.nextInt();
				if (num != 0) {
					push(num);
				}
				else pop();
			}
			// sumarr 배열에 sum 저장, stack 리셋
			sumarr[i] = sum();
			reset();
		}
		// 문제에서 요구하는 대로 수의 합 출력
		for (int i=0; i<t; i++) {
			System.out.println("#" + (i+1) + " " + sumarr[i]);
		}
	}
	// 스택 구조 구현 (문제에서 stack을 초과하거나, 지울 수 없을 때 0이 나오지 않는 것을 보장하여 isFull, isEmpty 메소드는 구현하지 않음)
	// 크기 100,000의 stack 배열 만들기
	static int[] stack = new int[100000];
	
	// 마지막으로 삽입된 원소의 위치를 알기 위한 top을 -1로 설정
	static int top = -1;
	
	// 삽입메소드 push 구현
	static void push(int num) {
		stack[++top] = num;
	}
	
	// 삭제메소드 pop 구현
	static int pop() {
		return stack[top--];
	}
	
	// 합을 구하기 위한 sum 메소드 구현
	static int sum() {
		int sum = 0;
		for (int i=0; i<=top; i++) {
			sum += stack[i];
		}
		return sum;
	}
	
	// 테스트 케이스마다 stack을 초기화하기 위한 reset 메소드 구현
	static void reset() {
		top = -1;
	}
}
