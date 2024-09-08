package BOJ_1654_랜선_자르기_이분탐색;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		int N = sc.nextInt();
		
		int[] lan = new int[K];
		
		long min = 0;
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			lan[i] = sc.nextInt();
			if (lan[i] > max) {
				max = lan[i];
			}
		}
		
		max++;
		long mid = 0;
		
		while (min < max) {
			mid = min/2 + max/2;
			long count = 0;
			for (int i = 0; i < K; i++) {
				count += lan[i]/mid;
			}
			if (count < N) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		
		System.out.println(min-1);
	}
}
