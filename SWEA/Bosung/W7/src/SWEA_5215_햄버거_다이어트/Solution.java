package SWEA_5215_햄버거_다이어트;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 각 테스트 케이스의 재료 수와 제한 칼로리 입력 받기
			int N = sc.nextInt();
			int L = sc.nextInt();
			
			// 각 재료의 점수와 칼로리를 저장할 2차원 배열 만들기
			int[][] ham = new int[N][2];
			
			// 각 햄버거마다 점수와 칼로리 저장하기
			for (int i = 0; i < N; i++) {
				ham[i][0] = sc.nextInt(); // 점수
				ham[i][1] = sc.nextInt(); // 칼로리
			}
			
			// 점수의 합의 최댓값을 저장할 max 변수 생성
			int max = 0;
			
			// 비트마스킹을 이용하여 선택한 재료들에 대해
			// 칼로리의 합이 제한 칼로리를 넘지 않는 선에서 점수의 합의 최댓값을 구함
			for (int i = 0; i < 1<<N; i++) {
				int score = 0;
				int cal = 0;
				for (int j = 0; j < N; j++) {
					if ((i & 1<<j) > 0) {
						score += ham[j][0];
						cal += ham[j][1];
						// 재료들의 칼로리를 합하다가 제한 칼로리가 넘어가면 break
						if (cal > L) {
							break;
						}
					}
				}
				// 제한 칼로리를 넘지 않을 때 score가 max보다 크면 max에 score 저장
				if (cal <= L) {
					if (score > max) {
						max = score;
					}
				}
			}
			
			// 테스트 케이스 번호와 점수의 합의 최댓값 출력
			System.out.println("#" + t + " " + max);
		}
	}
}
