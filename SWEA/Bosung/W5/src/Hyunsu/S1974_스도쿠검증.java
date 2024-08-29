package Hyunsu;
import java.util.*;
import java.io.*;

/**
 * 가로, 세로를 이용해서
 */

public class S1974_스도쿠검증 {


	static int[][] arr = new int[9][9];
	//가로의 카운트 배열
	static int[] row  = new int[10];
	//세로의 카운트 배열
	static int[] col  = new int[10];
	//뭉탱이에 대한 확인
	static int[][][] dum = new int[3][3][10]; 
	static int ans = 1;
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input_스도쿠.txt"));
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			 ans = 1;
			
			int[][] arr = new int[9][9];
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			if(!(check(arr))) {
				//return false일때
				ans = 0;
			}

			System.out.println("#"+t+" "+ans);
		}
		
		
		
	}//main
	static boolean check(int[][] arr) {
		
		//가로 확인

		for(int i=0; i<9; i++) {
			row  = new int[10];
			for(int j=0; j<9; j++) {
				int tmp = arr[i][j];
				row[tmp]++;
				
				if(row[tmp]>1) {
					ans = 0;
					return false;
				}
			}
		}
		//세로 확인
		for(int i=0; i<9; i++) {
				col  = new int[10];
				for(int j=0; j<9; j++) {
					int tmp = arr[j][i];
					col[tmp]++;
					
					if(col[tmp]>1) {
						ans = 0;
						return false;
					}
				}
			}
		
		//뭉텅이 확인
		dum = new int[3][3][10]; 
		for(int i=0; i<9; i++) {
			row  = new int[10];
			for(int j=0; j<9; j++) {
				int tmp = arr[i][j];
				
				int x= i/3;
				int y= j/3;
				
				dum[x][y][tmp]++;
				
				if(dum[x][y][tmp]>1) {
					return false;
				}
			}
		}

		return true;

	}

}
