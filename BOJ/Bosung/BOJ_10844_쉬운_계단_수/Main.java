package BOJ_10844_쉬운_계단_수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int[] dp = new int[101];
		
		int[][] dp2 = new int[101][10];
		
		dp2[1] = new int[]{0,1,1,1,1,1,1,1,1,1};
		
		dp[1] = 9;
		
		for (int i = 2; i <= 100; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp2[i][j] = dp2[i-1][j+1];
				}
				else if (j == 9) {
					dp2[i][j] = dp2[i-1][j-1];	
				}
				else {
					dp2[i][j] = (dp2[i-1][j-1] + dp2[i-1][j+1])%1000000000;					
				}
				dp[i] = (dp[i] + dp2[i][j])%1000000000;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(dp[N]);
	}
}
