package BOJ_9095_123더하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int n =sc.nextInt();
			
			System.out.println(dp[n]);
		}
	}
}