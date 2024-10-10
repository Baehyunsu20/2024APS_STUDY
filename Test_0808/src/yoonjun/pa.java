package yoonjun;

import java.util.Scanner;

public class pa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t ++) {
			
			int[][] pan = new int[100][100];
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					pan[i][j] = sc.nextInt();
					
					
				}
			}
		}

	}

}
