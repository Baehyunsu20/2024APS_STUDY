package SWEA_4613_러시아_국기_같은_깃발;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 행과 열의 개수 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 색이 입력될 2차원 배열 color 생성
			char[][] color = new char[N][M];
			
			// 색을 입력받아 color 배열에 저장
			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < M; c++) {
					color[r][c] = str.charAt(c);
				}
			}
			
			// 새로 칠해야 하는 칸의 개수의 최솟값을 저장할 minCount를 Integer의 최댓값으로 생성
			int minCount = Integer.MAX_VALUE;
			
			// 흰색과 파란색의 경계가 되는 행, 파란색과 빨간색의 경계가 되는 행을 바꾸어가며 최솟값을 저장
			// 흰색과 파란색의 경계가 되는 행 boundarywb에는 파란색이 들어가고
			// 파란색과 빨간색의 경계가 되는 행 boundarybr에는 빨간색이 들어가도록 하여
			// 먼저 boundarywb를 첫 행과 마지막 행을 제외한 행 중에서 고르고
			// 그 후 boundarywb의 바로 아래에 있는 행부터 마지막 행 중에서 boundarybr을 고르도록 함
			for (int boundarywb = 1; boundarywb <= N-2; boundarywb++) {
				int countW = 0;
				// 첫 행부터 boundarywb 바로 전 행까지 흰색이 아닌 칸의 개수를 셈
				for (int w = 0; w < boundarywb; w++) {
					for (int c = 0; c < M; c++) {
						if (color[w][c] != 'W') {
							countW += 1;
						}
					}
				}
				// boundarywb의 바로 아래 행에서 마지막 행의 범위 중 boundarybr 선택
				for (int boundarybr = boundarywb + 1; boundarybr <= N-1; boundarybr++) {
					int countBR = 0;
					// boudarywb부터 boundarybr 전까지 파란색이 아닌 칸의 개수를 셈
					for (int b = boundarywb; b < boundarybr; b++) {
						for (int c = 0; c < M; c++) {
							if (color[b][c] != 'B') {
								countBR += 1;
							}
						}
					}
					// boundarybr부터 마지막행까지 빨간색이 아닌 칸의 개수를 셈
					for (int r = boundarybr; r <= N-1; r++) {
						for (int c = 0; c < M; c++) {
							if (color[r][c] != 'R') {
								countBR += 1;
							}
						}
					}
					// 흰색으로 바꾼 칸과 파란색, 빨간색으로 바꾼 칸의 합이 minCount보다 작으면 최솟값으로 저장
					if (countW + countBR < minCount) {
						minCount = countW + countBR;
					}
				}
			}
			
			// 테스트 케이스 번호와 최솟값 출력
			System.out.println("#" + test_case + " " + minCount);
		}
	}
}
