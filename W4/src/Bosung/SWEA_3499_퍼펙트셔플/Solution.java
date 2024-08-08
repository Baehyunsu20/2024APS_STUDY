package SWEA_3499_퍼펙트셔플;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 입력
		int t = sc.nextInt();
		
		// 테스트 케이스마다 셔플 후 배열을 담을 ans 배열 생성
		String[][] ans = new String[t][];
		
		for (int i = 0; i < t; i++) {
			
			// 카드 수 N 입력
			int N = sc.nextInt();
			
			// 카드를 입력 받을 names 배열 생성
			String[] names = new String[N];
			
			// names 배열에 카드 이름 입력 받기
			for (int j = 0; j < N; j++) {
				names[j] = sc.next();
			}
			
			// 셔플 후의 카드 배열을 저장할 shuffle 배열 생성
			String[] shuffle = new String[N];
			
			// N이 짝수일 경우 퍼펙트 셔플 후 카드 배열 저장
			if (N % 2 == 0) {
				for (int j = 0; j < N; j++) {
					if (j < N/2) {
						shuffle[2*j] = names[j];
					}
					else {
						shuffle[(j-N/2)*2 + 1] = names[j];
					}
				}
			}
			// N이 홀수일 경우 퍼펙트 셔플 후 카드 배열 저장
			else {
				for (int j = 0; j < N; j++) {
					if (j <= N/2) {
						shuffle[2*j] = names[j];
					}
					else {
						shuffle[(j-N/2-1)*2 + 1] = names[j];
					}
				}
			}
			
			// 퍼펙트 셔플 한 배열을 ans에 각각 저장
			ans[i] = shuffle;
		}
		
		// 문제에서 요구하는 대로 퍼펙트 셔플 후 카드 배열을 출력
		for (int i = 0; i < t; i++) {
			System.out.print("#" + (i+1) + " ");
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	
	}
}