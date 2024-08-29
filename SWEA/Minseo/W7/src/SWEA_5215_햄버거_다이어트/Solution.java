package SWEA_5215_햄버거_다이어트;

import java.util.Scanner;

public class Solution {
	
	static int N, L;
	static int[] taste, kcal;
	
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N =sc.nextInt();
			L = sc.nextInt();
			
			taste = new int[N];
			kcal = new int[N];
			
			for(int n=0;n<N;n++) {
				taste[n]=sc.nextInt();
				kcal[n]=sc.nextInt();
			}
			
			answer=0;
			dfs(0,0,0);
			
			System.out.println("#"+t+" "+answer);
			
			
		}
	}
	static void dfs(int i, int tasteSum, int kcalSum) {
		if(kcalSum>L) {
			return;
		}
		if(i==N) {
			answer = Math.max(answer, tasteSum);
			return;
		}
		
		dfs(i+1,tasteSum, kcalSum);
		dfs(i+1,tasteSum+taste[i],kcalSum+kcal[i]);
		
	}

}
