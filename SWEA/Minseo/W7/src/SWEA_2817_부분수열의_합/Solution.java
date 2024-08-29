package SWEA_2817_부분수열의_합;

import java.util.Scanner;

public class Solution {
	static int N,K;
	static int cnt;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			arr = new int[N];
			for(int n=0;n<N;n++) {
				arr[n]=sc.nextInt();
			}
			
			cnt=0;
			dfs(0,0);
			System.out.println("#"+t+" "+cnt);
			
		}
		
	}
	static void dfs(int i,int sum) {
		if(sum==K) {
		cnt++;
		return;
		}else if(sum>K||i==N) {
			return;
		}
		dfs(i+1,sum);
		dfs(i+1,sum+arr[i]);
	}

}
