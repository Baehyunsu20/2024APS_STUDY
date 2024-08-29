package 부분수열의합_2817;

import java.util.Scanner;
/**
 * n개의 수열을 받고, 합이 k가 되는 경우의 수 구하기
 * 모든 조합의 합을 구하고 합이 k인 것 구하기
 */

public class Solution {
	static int n;
	static int k;
	static int[] list;
	static boolean[] sel;
	
	static int cnt;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			n= sc.nextInt();
			k= sc.nextInt();
			cnt =0;
			list = new int[n];
			sel = new boolean[n];
			
			for(int i=0; i<n; i++) {
				list[i] =sc.nextInt();
			}
			
			
			recurr(0);
			System.out.println("#"+t+" "+cnt);
		}
	}


	private static void recurr(int idx) {
		if(idx ==n) {
			int sum =0;
			for(int i=0; i<n; i++) {
				if(sel[i]) {
					sum+=list[i];
				}
			}//하나의 조합 완성
			
			if(sum==k) {
//				System.out.println("조합 완성입니다");
				cnt++;
			}
			return;

		}
		sel[idx] = true;
		recurr(idx+1);
		
		sel[idx] = false;
		recurr(idx+1);
		
	}


}