package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			sc.nextInt();
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + t + " " + pow(N, M));
		}
	}
	
	static int pow(int N, int M) {
		if (M == 0) return 1;
		return N * pow(N, M-1);
	}
}
