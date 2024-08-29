package SWEA_2806_N_Queen;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Solution {
	
	static int[][] map;
	
	static int N, ans;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			ans=0;
			
			dfs(0);
			
			System.out.println("#"+t+" "+ans);
		}
	}
		
	static void dfs(int r) {
		if(r==N) {
			ans++;
			return;
		}else {
			for(int c=0;c<N;c++) {
				if(check(r,c)) {
					map[r][c]=1;
					dfs(r+1);
					map[r][c]=0;
				}				
			}			
		}
	}
	static boolean check(int r, int c) {
		// 8방 탐색
		int[] dr = {-1,-1,0,1,1,1,0,-1};
		int[] dc = {0,1,1,1,0,-1,-1,-1};
		for(int i=0;i<8;i++) {
			int nr=r, nc=c;
			while(nr+dr[i]>=0&&nr+dr[i]<N&&nc+dc[i]>=0&&nc+dc[i]<N) {
				nr+=dr[i]; nc+=dc[i];
				if(map[nr][nc]==1) {
					return false;
				}
			}
		}
		return true; 
	}

}