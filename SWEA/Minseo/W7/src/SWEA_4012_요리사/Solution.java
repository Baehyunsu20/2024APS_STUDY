package SWEA_4012_요리사;

import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[][] food;
	
	static boolean[] ingredient;
	static int taste;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			food = new int[N][N];
			ingredient = new boolean[N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					food[i][j]=sc.nextInt();
				}
			}
			
			// 재료 선택 N/2개씩
			taste = Integer.MAX_VALUE;
			choice(0,0);
			System.out.println("#"+t+" "+(taste/2));
		}
		
	}
	
	static void choice(int n,int r) {
		if(n==N&&r==n/2) {
			int food1=0, food2=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i!=j&&ingredient[i]&&ingredient[j]) {
						food1+=food[i][j]+food[j][i];
					}else if(i!=j&&!ingredient[i]&&!ingredient[j]) {
						food2+=food[i][j]+food[j][i];
					}
				}
			}
			taste = Math.min(taste,Math.abs(food1-food2));
			return;
		}else if(n==N) {
			return;
		}
		
		ingredient[n]=true;
		choice(n+1, r+1);
		ingredient[n]=false;
		choice(n+1, r);
		
	}
	
}