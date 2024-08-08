package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	
	// N^M을 구하는 메소드 power 구현
	static int power(int N, int M) {
		
		// M이 0일 땐 1 리턴
		if (M==0) {
			return 1;
		}
		// 재귀호출을 통해 거듭제곱 구현
		else {
			return N*power(N, M-1);
		}
	}
	
	// 메인 메소드
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 거듭제곱 값을 저장할 ans 배열 만들기
		int[] ans = new int[10];
		
		for (int i=0; i<10; i++) {
			
			int t = sc.nextInt();
			
			// power 메소드를 사용해 거듭제곱 값 구하고 저장
			ans[i] = power(sc.nextInt(),sc.nextInt());
		}
		
		// 문제에서 요구하는 대로 거듭제곱 값 출력
		for (int i=0; i<10; i++) {
			System.out.println("#" + (i+1) + " " + ans[i]);
		}
		
	}
}