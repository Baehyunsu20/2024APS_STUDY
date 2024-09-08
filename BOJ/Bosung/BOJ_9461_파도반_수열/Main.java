package BOJ_9461_파도반_수열;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long[] P = new long[101];
		
		
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		P[5] = 2;
		P[6] = 3;
		P[7] = 4;
		P[8] = 5;
		P[9] = 7;
		
		for (int i = 10; i <= 100; i++) {
			P[i] = P[i-5] + P[i-1];
		}
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			System.out.println(P[N]);
		}
	}
}
