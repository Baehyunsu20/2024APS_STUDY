package BOJ_11053_가장_긴_증가하는_부분_수열;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];

		Arrays.fill(dp, 1);
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
