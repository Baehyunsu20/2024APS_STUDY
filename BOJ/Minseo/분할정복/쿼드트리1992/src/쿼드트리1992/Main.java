package 쿼드트리1992;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str = sc.nextLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		dfs(0,0,N);
		System.out.println(sb);
		
	}
	static void dfs(int i, int j, int len) {
//		sb.append("(");
		boolean isTrue = true;
		int init = arr[i][j];
		for(int r=i;r<i+len;r++) {
			for(int c=j;c<j+len;c++) {
				if(arr[r][c]!=init) {
					isTrue = false;
					break;
				}
			}if(!isTrue) break;
		}
		if(isTrue) {
			sb.append(init);
		}else {
			int newlen = len/2;
			sb.append("(");
			for(int r=i;r<i+len;r+=newlen) {
				for(int c=j;c<j+len;c+=newlen) {
					dfs(r,c,newlen);
				}
			}
			sb.append(")");
		}
//		sb.append(")");
	}
}
