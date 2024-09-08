package BOJ_11728_배열_합치기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int al = sc.nextInt();
		int bl = sc.nextInt();
		
		int[] A = new int[al];
		int[] B = new int[bl];
		
		for (int i = 0; i < al; i++) {
			A[i] = sc.nextInt();
		}
		
		for (int i = 0; i < bl; i++) {
			B[i] = sc.nextInt();
		}
		
		int[] sum = new int[al+bl];
		
		int idx = 0;
		int ap = 0;
		int bp = 0;
		
		while (ap < al && bp < bl) {
			if (A[ap] <= B[bp])
				sum[idx++] = A[ap++];
			else {
				sum[idx++] = B[bp++];
			}
		}
		
		if (ap < al) {
			while (ap < al) {
				sum[idx++] = A[ap++];
			}
		}
		else {
			while (bp < bl) {
				sum[idx++] = B[bp++];
			}
		}
		
		for (int i = 0; i < sum.length; i++) {
			System.out.print(sum[i] + " ");
		}
	}
}
