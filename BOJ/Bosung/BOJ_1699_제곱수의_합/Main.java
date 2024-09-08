package BOJ_1699_제곱수의_합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 100000의 제곱근이 316.xx
		int[] powers = new int[317];
		
		for (int i = 0; i < 317; i++) {
			powers[i] = (int) Math.pow(i, 2);
		}
		
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= Math.sqrt(N); j++) {
				if (i >= powers[j])
				dp[i] = Math.min(dp[i], dp[i-powers[j]] + 1);
			}
		}
		
		System.out.println(dp[N]);
	}
}