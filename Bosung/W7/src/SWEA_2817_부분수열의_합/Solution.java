package SWEA_2817_부분수열의_합;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 자연수의 개수와 원하는 합 입력 받기
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			// N개의 숫자를 저장할 배열 nums 만들기
			int[] nums = new int[N];

			// N개의 숫자로 이루어진 수열 입력 받기
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			// 부분 수열의 합이 K가 되는 경우를 셀 count 변수 생성
			int count = 0;
			
			// 비트마스킹을 활용하여 각 부분 수열의 합이 K와 같을 때 count 1 증가
			for (int i = 0; i < 1<<N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & 1<<j) > 0) {
						sum += nums[j];
					}
				}
				if (sum == K) {
					count++;
				}
			}
			
			// 테스트 케이스 번호와 부분 수열의 합이 K가 되는 경우의 수 출력
			System.out.println("#" + t + " " + count);
		}
	}	
}
