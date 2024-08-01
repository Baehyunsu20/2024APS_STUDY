package Hyewon;

import java.util.Scanner;
public class 오목 {



	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
// 19X19 배열만들기
	int [][] arr = new int [19][19];
	
	for(int r=0; r<19; r++) {
		for(int c =0; c<19; c++) {
			arr[r][c] = sc.nextInt();
					
			}
		}
	boolean yesOmok = false; // 값을 다 넣었는데 오목 달성하지 못한 경우를 생각하지 못했음 이때 boolean 기능 추가

// 값 체크하기
	for(int r=0; r<19; r++) {
		for(int c =0; c<19; c++) {
			int V = arr[r][c];
			if(V!=1 && V!=2) continue;
					
		// 윗대각선체크
			if(r>=4 && c<=14) {
				int i;
				for(i=1; i<5;i++) {
				if(arr[r-i][c+i] != V) {
					break;
				}
			}
				if(i==5) {
					System.out.println(V);
					System.out.println((r+1)+ " " + (c+1));
					yesOmok = true;
				}
		}
			
	
	
		// 가로 체크	
		if(c<=14) {
			int i;
			for(i=1; i<5;i++) {
				if(arr[r][c+i] != V) {
					break;
				}
			}
			if(i==5) {
				System.out.println(V);
				System.out.println((r+1)+ " " + (c+1));
				yesOmok = true;
				}
		}
		
		// 아래 대각선 체크
		if(r<=14 && c<=14) {
			int i;
			for(i=1; i<5;i++) {
				if(arr[r+i][c+i] != V) {
					break;
				}
			}
			if(i==5) {
				System.out.println(V);
				System.out.println((r+1)+ " " + (c+1));
				yesOmok = true;
		}
		}
		
		// 세로 체크
		if(r<=14) {
			int i;
			for(i=1; i<5;i++) {
				if(arr[r+i][c] != V) {
					break;
				}
			}
			if(i==5) {
				System.out.println(V);
				System.out.println((r+1)+ " " + (c+1));
				yesOmok = true;
		}	
	}	
		}
	}
	if(!yesOmok) {
		System.out.println(0);
//	System.out.println(Arrays.deepToString(arr));
	}
	sc.close();
	}
}

	
	
	
	
//		
		


