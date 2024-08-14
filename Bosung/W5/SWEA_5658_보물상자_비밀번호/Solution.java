package SWEA_5658_보물상자_비밀번호;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			String nums = sc.next();
			
			Queue<Character> numsQ = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				numsQ.offer(nums.charAt(i));
			}
			
			int m = 0;
			
			int repeat = N/4;
			
			int p = repeat*4;
			int q = N/4;

			char[][] all = new char[p][q];
			
			for (int k = 0; k < repeat; k++) {
				
				char[][] sep = new char[4][N/4];
				
				int n = 0;
				
				for (int i = 1; i <= 4; i++) {
					for (int j = 1; j <= N/4; j++) {
						sep[i-1][j-1] = nums.charAt(n++);
					}
				}
				
				for (int i = 0; i < 4; i++) {
					all[m+i] = sep[i];
				}
				
				m += 4;
				
				for (int i = 0; i < N-1; i++) {
					numsQ.offer(numsQ.poll());
				}
				
				nums = "";
				
				for (int i = 0; i < N; i++) {
					nums += numsQ.poll().toString();
				}
				
				for (int i = 0; i < N; i++) {
					numsQ.offer(nums.charAt(i));
				}
			}
			
			for (int i = 0; i < p; i++) {
				for (int j = 1; i + j < p; j++) {
					boolean same = true;
					for (int k = 0; k < q; k++) {
						if (all[i][k] != all[i+j][k]) {
							same = false;
							break;
						}
					}
					if (same) {
						all[i] = new char[q];
					}
				}
			}
			
			int[] number = new int[p];
			
			for (int i = 0; i < p; i++) {
				for (int j = 0; j < q; j++) {
					switch (all[i][j]) {
					case '0':
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
						break;
					case '1':
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
						break;
					case '2':
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
						break;
					case '3':
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
						break;
					case '4':
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
						break;
					case '5':
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
						break;
					case '6':
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
						break;
					case '7':
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
						break;
					case '8':
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
						break;
					case '9':
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
						break;
					case 'A':
						number[i] += (((int) all[i][j] - 55)*Math.pow(16, q-j-1));
						break;
					case 'B':
						number[i] += (((int) all[i][j] - 55)*Math.pow(16, q-j-1));
						break;
					case 'C':
						number[i] += (((int) all[i][j] - 55)*Math.pow(16, q-j-1));
						break;
					case 'D':
						number[i] += (((int) all[i][j] - 55)*Math.pow(16, q-j-1));
						break;
					case 'E':
						number[i] += (((int) all[i][j] - 55)*Math.pow(16, q-j-1));
						break;
					case 'F':
						number[i] += (((int) all[i][j] - 55)*Math.pow(16, q-j-1));
						break;
					}
				}
			}
			
			Arrays.sort(number);
			System.out.println("#" + t + " " + number[p-K]);
		}
	}
}
