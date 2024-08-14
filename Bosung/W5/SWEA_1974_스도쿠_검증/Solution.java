package SWEA_1974_스도쿠_검증;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 입력
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 스도쿠 입력 받을 2차원 배열 생성
			int[][] board = new int[9][9];
			
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					board[r][c] = sc.nextInt();
				}
			}
			
			// 스도쿠인지 아닌지 판단할 변수 sudoku 생성
			int sudoku = 1;
			
			// 각각의 가로줄을 row 배열에 담고 9개의 수의 합이 45인지, 곱이 362880인지 판단 후
			// 하나라도 아니면 스도쿠가 아니므로 sudoko 변수에 0 저장
			for (int r = 0; r < 9; r++) {
				int[] row = new int[9];
				for (int c = 0; c < 9; c++) {
					row[c] = board[r][c];
				}
				int sum = 0;
				int time = 1;
				for (int c = 0; c < 9; c++) {
					sum += row[c];
					time *= row[c];
				}
				if (sum != 45 || time != 362880) {
					sudoku = 0;
				}
			}
			
			// 각각의 세로줄을 col 배열에 담고 9개의 수의 합이 45인지, 곱이 362880인지 판단 후
			// 하나라도 아니면 스도쿠가 아니므로 sudoko 변수에 0 저장
			for (int c = 0; c < 9; c++) {
				int[] col = new int[9];
				for (int r = 0; r < 9; r++) {
					col[r] = board[r][c];
				}
				int sum = 0;
				int time = 1;
				for (int r = 0; r < 9; r++) {
					sum += col[r];
					time *= col[r];
				}
				if (sum != 45 || time != 362880) {
					sudoku = 0;
				}
			}
			
			// 3*3의 격자를 돌며 nemo 배열에 담고 9개의 수의 합이 45인지, 곱이 362880인지 판단 후
			// 하나라도 아니면 스도쿠가 아니므로 sudoko 변수에 0 저장
			for (int r = 0; r < 9; r += 3) {
				for (int c = 0; c < 9; c += 3) {
					// nemo 배열에 저장하기 위해 변수 n을 만들고 하나를 저장할 때마다 1씩 올려줌
					int[] nemo = new int[9];
					int n = 0;
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							nemo[n] = board[r+i][c+j];
							n++;
						}
					}
					int sum = 0;
					int time = 1;
					for (int i = 0; i < 9; i++) {
						sum += nemo[i];
						time *= nemo[i];
					}
					if (sum != 45 || time != 362880) {
						sudoku = 0;
					}
				}
			}
			// 테스트 케이스 번호와 sudoku 출력
			System.out.println("#" + (test_case) + " " + sudoku);
			
			// 여태까진 모든 입력값이 입력된 후 출력하기 위해 문제에서 요구하는 출력값을
			// 첫 for문 밖에서 생성한 한 차원 위 배열에 저장해서 모든 입력과 계산이 끝난 후 출력했었는데
			// 어차피 입력이 한 번에 들어오니까 그냥 for문 안에서 출력해줘도 되는듯?
		}
	}
}