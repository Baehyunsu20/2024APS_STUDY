package BOJ_11057_오르막_수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int[] dp = new int[1001];
		
		int[][] dp2 = new int[1001][10];
		dp2[1] = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		for (int i = 2; i <= 1000; i++) {
			dp2[i][9] = 1; 
			for (int j = 8; j >= 0; j--) {
				dp2[i][j] = (dp2[i-1][j] + dp2[i][j+1])%10007;
			}
		}
		
		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < 10; j++) {
				dp[i] += dp2[i][j];
			}
			dp[i] = dp[i]%10007;
		}
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(dp[N]);
	}
}
