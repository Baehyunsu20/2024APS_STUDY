package BOJ_1912_연속합;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = sc.nextInt();
		}
		
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i], dp[i-1] + dp[i]);
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}