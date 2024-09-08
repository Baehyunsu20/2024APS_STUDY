package BOJ_11052_카드_구매하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[1001];
		int[] P = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			P[i] = sc.nextInt();
		}
		
		dp[1] = P[1];
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i - j >= 0) {
					dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
				}
			}
			dp[i] = Math.max(dp[i], P[i]);
		}
		
		for (int i = N + 1; i <= 1000; i++) {
			for (int j = 1; j <= N; j++) {
				if (i - j >= 0) {
					dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
				}
			}
		}
		
		System.out.println(dp[N]);
	}
}
