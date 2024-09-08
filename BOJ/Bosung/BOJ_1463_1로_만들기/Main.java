package BOJ_1463_1로_만들기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int[] dp = new int[1000001];
		
		for (int i = 2; i <= 1000000; i++) {
			int temp = Integer.MAX_VALUE;
			int temp1 = Integer.MAX_VALUE;
			int temp2 = Integer.MAX_VALUE;
			if (i % 3 == 0) {
				temp = dp[i/3] + 1;
			}
			if (i % 2 == 0) {
				temp1 = dp[i/2] + 1;
			}
			temp2 = dp[i-1] + 1;
			
			dp[i] = Math.min(temp, Math.min(temp1, temp2));
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(dp[sc.nextInt()]);
	}
}
