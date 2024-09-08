package BOJ_2193_이친수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		long[] dp = new long[91];
		
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 3; i <= 90; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(dp[N]);
	}
}
