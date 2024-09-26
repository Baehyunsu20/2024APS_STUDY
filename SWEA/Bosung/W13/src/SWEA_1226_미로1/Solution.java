package SWEA_1226_미로1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] board = new int[16][16];
	static boolean[][] visited = new boolean[16][16];
	static boolean find;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			sc.nextInt();
			
			for (int r = 0; r < 16; r++) {
				String str = sc.next();
				for (int c = 0; c < 16; c++) {
					board[r][c] = (int) str.charAt(c) - '0';
				}
			}
			visited = new boolean[16][16];
			
//			System.out.println(Arrays.deepToString(board));
			find = false;
			finding(1, 1);
//			for (int r = 0; r < 16; r++) {
//				for (int c = 0; c < 16; c++) {
//					if (visited[r][c]) System.out.print("O ");
//					else System.out.print("X ");
//				}
//				System.out.println();
//			}
			
			if (find) System.out.println("#" + t + " " + 1);
			else System.out.println("#" + t + " " + 0);
		}
	}
	static void finding(int r, int c) {
		
		if (board[r][c] == 3) {
			find = true;
			return;
		}
		
		visited[r][c] = true;
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (board[nr][nc] != 1 && !visited[nr][nc]) {
				finding(nr, nc);
			}
		}
	}
}
