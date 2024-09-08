package BOJ_2156_포도주_시식亡;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] podo = new int[n];
		boolean[] visited = new boolean[2];
		
		for (int i = 0; i < n; i++) {
			podo[i] = sc.nextInt();
		}
		
		int[] dp = new int[n];
		dp[0] = podo[0];
		dp[1] = dp[0] + podo[1];
		if (min(podo[0], podo[1], podo[2]) == podo[0]) {
			dp[2] = podo[1] + podo[2];
			visited[0] = true;
			visited[1] = true;
		}
		else if (min(podo[0], podo[1], podo[2]) == podo[1]) {
			dp[2] = podo[0] + podo[2];
			visited[0] = false;
			visited[1] = true;
		}
		else {
			dp[2] = dp[1];
			visited[0] = true;
			visited[1] = false;
		}
		
		for (int i = 3; i < n; i++) {
			System.out.println(Arrays.toString(visited));
			if (visited[0] && visited[1]) {
				if (min(podo[i-2], podo[i-1], podo[i]) == podo[i-2]) { // 전전 포기
					dp[i] = dp[i-3] + podo[i-1] + podo[i];
				}
				else if (min(podo[i-2], podo[i-1], podo[i]) == podo[i-1]) { // 전 포기
					dp[i] = dp[i-3] + podo[i-2] + podo[i];
					visited[0] = false;
				}
				else {
					visited[1] = false;
					dp[i] = dp[i-1];
				}
			}
			else {
				dp[i] = dp[i-1] + podo[i];
				visited[0] = visited[1];
				visited[1] = true;
			}
		}
		
		System.out.println(Arrays.toString(dp));
		
	}
	static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b),c);
	}
}
// 2개 앞을 판단하면 될 줄 알았는데 안 된다는 걸 다 구현하고 알게 됨... 亡..
