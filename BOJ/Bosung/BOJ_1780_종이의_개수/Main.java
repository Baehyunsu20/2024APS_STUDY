package BOJ_1780_종이의_개수;

import java.util.Scanner;

public class Main {
	static int[] ans = new int[3];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] board = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				board[r][c] = sc.nextInt();
			}
		}
		
		paper(board, N);

		for (int i = 0; i < 3; i++) {
			System.out.println(ans[i]);
		}
	}
	static void paper(int[][] board, int N) {
		
		// 전체가 0으로 이루어진 경우 기저 조건
		boolean zero = true;
		
		out:
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] != 0) {
					zero = false;
					break out;
				}
			}
		}
		if (zero) {
			ans[1]++;
			return;
		}
		
		// 전체가 -1, 1로 이루어진 경우 기저 조건
		int sum = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sum += board[r][c];
			}
		}
		if (sum == -(N*N)) {
			ans[0]++;
			return;
		}
		else if (sum == (N*N)) {
			ans[2]++;
			return;
		}
		
		// 재귀 돌리기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int[][] nBoard = new int[N/3][N/3];
				for (int r = 0; r < N/3; r++) {
					for (int c = 0; c < N/3; c++) {
						nBoard[r][c] = board[r + i*(N/3)][c + j*(N/3)];
					}
				}
				paper(nBoard, N/3);
			}
		}
	}
}
