package SWEA_1251_하나로;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();

			int[][] board = new int[2][N];

			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < N; c++) {
					board[r][c] = sc.nextInt();
				}
			}

			double E = sc.nextDouble();
			double[][] edge = new double[N * (N - 1) / 2][3];
			
			int idx = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					edge[idx][0] = i;
					edge[idx][1] = j;
					// edge[idx][2]는 거리의 제곱이 들어가있음 (나중에 어차피 제곱해서 계산할 예정이라 굳이 루트 씌우지 않음)
					edge[idx][2] = Math.pow((board[0][i] - board[0][j]), 2) + Math.pow((board[1][i] - board[1][j]), 2);
					idx++;
				}
			}
			
			Arrays.sort(edge, new Comparator<double[]>() {
				public int compare(double[] o1, double[] o2) {
					return (int) (o1[2] - o2[2]);
				}
			});
			
			// 대장 정하자
			int[] p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			int count = 0;
			double distS = 0;
			for (int i = 0; i < edge.length; i++) {
				// p[(int)edge[i][0]]랑 p[(int)edge[i][1]]를 px, py에 저장하지 않으면...
				int px = p[(int)edge[i][0]];
				int py = p[(int)edge[i][1]];
				if (px != py) {
					for (int j = 0; j < N; j++) {
						if (p[j] == py) {	// 여기에서 py가 일정해야 하는데 p[(int)edge[i][1]]로 하면 값이 덮어써져서 if문에 안 걸리는 애들이 생김
							p[j] = px;
						}
					}
					distS += edge[i][2];
					count++;
//					System.out.println((int)edge[i][0] + " " + (int)edge[i][1]);
				}
				if (count == N-1) {
					break;
				}
			}
			System.out.println("#" + t + " " + Math.round(distS*E));
		}
	}
}
