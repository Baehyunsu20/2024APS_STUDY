package BOJ_1992_쿼드트리;

import java.util.Scanner;

public class Main {
	static String ans = "";
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] board = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < N; c++) {
				board[r][c] = (int) (str.charAt(c)-'0');
			}
		}
		
		qTree(board);
		
		System.out.println(ans);
	}
	
	static void qTree(int[][] board) {
		
		int N = board.length;
		
		// 기저조건
		int sum = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sum += board[r][c];
			}
		}
		if (sum == 0) {
			ans += 0;
			return;
		}
		else if (sum == N*N) {
			ans += 1;
			return;
		}
		
		// 재귀
		ans += "(";
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int[][] nBoard = new int[N/2][N/2];
				for (int r = 0; r < N/2; r++) {
					for (int c = 0; c < N/2; c++) {
						nBoard[r][c] = board[r + i * N/2][c + j * N/2];
					}
				}
				qTree(nBoard);
			}
		}
		ans += ")";
	}
}
/*
4
1100
0100
0011
0011
 */
