package SWEA_4012_요리사_다시풀기;

//import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			
			int[][] board = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					board[r][c] = sc.nextInt();
				}
			}
			
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < 1<<N; i++) {
				int[] A = new int[N];
				int[] B = new int[N];
				for (int j = 0; j < N; j++) {
					if ((i & 1<<j) > 0) {
						A[j] = 1;
					}
				}
//				System.out.println(Arrays.toString(A));
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += A[j];
				}
				if (sum == N/2) {
					for (int j = 0; j < N; j++) {
						if (A[j] != 1) {
							B[j] = 1;
						}
					}
//					System.out.println(Arrays.toString(B));
					int sumA = 0;
					int sumB = 0;
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < N; k++) {
							if (A[j] == 1 && A[k] == 1) {
								sumA += board[j][k];
							}
							if (B[j] == 1 && B[k] == 1) {
								sumB += board[j][k];
							}
						}
					}
					ans = Math.min(ans, Math.abs(sumA-sumB));
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
