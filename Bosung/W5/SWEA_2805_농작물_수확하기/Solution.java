package SWEA_2805_농작물_수확하기;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 입력
		int t = sc.nextInt();
		
		// 테스트 케이스마다 합을 저장하기 위해 ans 배열 생성
		int[] ans = new int[t];
		
		for (int i = 0; i < t; i++) {
			
			// 농장의 크기 N 입력
			int N = sc.nextInt();
			
			// N*N의 2차원 배열 arr 생성
			int[][] arr = new int[N][N];
			
			// 농장물의 가치를 2차원 배열에 입력 받기
			for (int r = 0; r < N; r++) {
				// N의 길이를 가지는 N개의 문자열 배열 형태로 입력이 되어 이를 int 배열에 넣기 위한 과정
				String row = sc.next();
				// 각 문자열을 행마다 따로 받은 후 charAt을 통해 문자로 나눈 뒤 int로 바꾸기 위해 문자 0을 빼주고 저장함
				for (int c = 0; c < N; c++) {
					arr[r][c] = (int) (row.charAt(c) - '0');
				}
			}
			
			// 합을 저장하기 위해 변수 sum 생성
			int sum = 0;
			
			// 마름모를 두 부분으로 나눠 위에 있는 세모 모양의 합 (중간 행 미포함)
			for (int r = 0; r < N/2; r++) {
				sum += arr[r][N/2];
				for (int j = 1; j < r + 1; j++) {
					sum += arr[r][N/2+j] + arr[r][N/2-j];
				}
			}
			
			// 아래에 있는 세모 모양의 합 (중간 행 포함)
			for (int r = N/2; r < N; r++) {
				sum += arr[r][N/2];
				for (int j = N - r - 1; j > 0; j--) {
					sum += arr[r][N/2+j] + arr[r][N/2-j];
				}
			}
			
			// 테스트 케이스마다 구한 합을 ans 배열에 저장
			ans[i] = sum;
		}
		
		// 농장의 규칙에 따라 얻을 수 있는 수익 출력
		for (int i = 0; i < t; i++) {
			System.out.println("#" + (i+1) + " " + ans[i]);
		}
	}
}