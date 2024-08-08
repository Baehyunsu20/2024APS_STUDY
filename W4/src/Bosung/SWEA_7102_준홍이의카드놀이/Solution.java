package SWEA_7102_준홍이의카드놀이;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 입력
		int t = sc.nextInt();
		
		// 테스트 케이스마다 등장할 확률이 높은 카드의 합을 저장할 ans 배열 생성
		int[][] ans = new int[t][];
		
		for (int i = 0; i < t; i++) {
			
			// N, M 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 두 숫자를 고르는 모든 경우의 수에서 합을 저장하기 위한 sum 배열 생성
			int[] sum = new int[N*M];
			
			// 첫 숫자는 n, m 모두 1부터 시작
			int n = 1;
			int m = 1;
			
			// n, m을 바꿔가며 모든 경우의 수에서 합을 구하여 sum 배열에 저장
			for (int j = 0; j < sum.length; j++) {
				sum[j] = n + m;
				
				// 다음 n은 n 유지, 다음 m은 1 증가
				int nn = n;
				int nm = m + 1;
				
				// 만약 m이 M을 넘어가면 n을 1 증가시킨 후 m은 1로 초기화
				if (nm == M + 1) {
					nn = n + 1;
					nm = 1;
				}
				// 확정된 nn, nm으로 n과 m 바꾸기
				n = nn;
				m = nm;
			}
			
			// 카드의 합의 개수를 셀 count 배열 생성 
			int[] count = new int[N+M+1];
			
			// sum 배열을 돌며 합의 개수 세기
			for (int j = 0; j < sum.length; j++) {
				count[sum[j]]++;
			}
			
			// 각각의 테스트 케이스마다 합의 개수를 센 배열을 ans 배열에 저장
			ans[i] = count;
		}
		
		// 문제에서 요구하는 대로 등장할 확률이 가장 높은 것들을 출력
		for (int i = 0; i < t; i++) {
			
			System.out.print("#" + (i+1) + " ");
			
			// 가장 많이 나온 합의 개수를 저장할 max 생성
			int max = 0;
			
			// 각 테스트 케이스마다 가장 많이 나온 합의 개수 구하기
			for (int j = 0; j < ans[i].length; j++) {
				if (ans[i][j] > max) {
					max = ans[i][j];
				}
			}
			// 가장 많이 나온 합들 출력
			for (int j = 0; j < ans[i].length; j++) {
				if (ans[i][j] == max) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
}