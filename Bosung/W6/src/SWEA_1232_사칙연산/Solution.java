package SWEA_1232_사칙연산;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int N = sc.nextInt();
			
			// tree[i] = {자신의 값(연산자이거나 피연산자), 왼쪽 자식 정점, 오른쪽 자식 정점};
			String[][] tree = new String[N+1][];
			
			for (int i = 1; i <= N; i++) {
				
				sc.nextInt();
				
				String input = sc.nextLine();
				
				// 문자열.trim() : 문자열 앞뒤의 공백 제거 (이때는 앞의 공백 지우기 위해 넣음)
				input = input.trim();
				
				tree[i] = input.split(" ");
			}
			System.out.println("#" + t + " " + (int)cal(1, tree));
		}
	}
	
	static double cal(int num, String[][] board) {
		
		if (board[num][0].equals("+")) {
			double a = cal(Integer.parseInt(board[num][1]), board);
			double b = cal(Integer.parseInt(board[num][2]), board);
			return a + b;
		}
		else if (board[num][0].equals("-")) {
			double a = cal(Integer.parseInt(board[num][1]), board);
			double b = cal(Integer.parseInt(board[num][2]), board);
			return a - b;
		}
		else if (board[num][0].equals("*")) {
			double a = cal(Integer.parseInt(board[num][1]), board);
			double b = cal(Integer.parseInt(board[num][2]), board);
			return a * b;
		}
		else if (board[num][0].equals("/")) {
			double a = cal(Integer.parseInt(board[num][1]), board);
			double b = cal(Integer.parseInt(board[num][2]), board);
			return a / b;
		}
		else return Double.parseDouble(board[num][0]);
	}
}
