package BOJ_1654_랜선_자르기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		int N = sc.nextInt();
		
		int[] lan = new int[K];
		
		int maxA = 0;
		for (int i = 0; i < K; i++) {
			lan[i] = sc.nextInt();
			maxA += lan[i]/N;
		}
		
		int ans = 0;
		
		for (int l = maxA; l >= 1; l--) {
			int count = 0;
			for (int i = 0; i < K; i++) {
				count += lan[i]/l;
			}
			if (count == N) {
				ans = l;
				break;
			}
		}
		System.out.println(ans);
	}
}
