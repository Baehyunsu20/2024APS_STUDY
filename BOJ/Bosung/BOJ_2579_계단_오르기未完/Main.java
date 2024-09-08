package BOJ_2579_계단_오르기未完;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] stair = new int[301];
		int[] dp = new int[301];
		
		for (int i = N-1; i >=0; i--) {	// 계단 역순으로 저장함
			stair[i] = sc.nextInt();
		}
		
		dp[0] = stair[0];
		dp[1] = stair[0] + stair[1];
		dp[2] = Math.max(dp[0] + stair[2], dp[1]);  // OXO or OOX
		
		// O가 세 개 이상 연속으로 나오지 않도록 하고 값이 모두 양수이므로 X가 연속으로 2개는 나오지 않을 것이라고 생각
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]), dp[i-1]);
		}
		
		System.out.println(dp[N-1]);
	}
}
