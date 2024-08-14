package Hyewon;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		
	
	// 숫자받기
	Scanner sc = new Scanner (System.in);
	
	for(int t=1; t<=10; t++) {
	String [][] arr = new String [8][8];
	for(int r=0; r<8;r++) {
		for(int c=0; c<8; c++) {
			arr[r][c] = sc.next();
		}
	}
	
	int length = sc.nextInt();
	int a = length-1;
	// 가로 회문 카운트 
	int cnt =0;
	for(int r=0; r<8; r++) {
		for(int c=0; c<8; c++) { //  만약에 회문길이가 3이면 1개 체크 / 4면 2개 / 5면 2개 / 6이면 3 7도3
			boolean isP = true;
			for(int i=0; i<length/2;i++) {
			if(!arr[r][c+i].equals(arr[r][c+a-i])) {
				isP = false;
				break;
				}
			}
			if(isP) {
			cnt++;
			}
		}
	}
	
	//세로 회문 카운트
	for(int c=0; c<8; c++) {
		for(int r=0; r<8; r++) { //  만약에 회문길이가 3이면 1개 체크 / 4면 2개 / 5면 2개 / 6이면 3 7도3
			boolean isP = true;
			for(int i=0; i<length/2;i++) {
				if(!arr[r+i][c].equals(arr[r+a-i][c])) {
					isP = false;
					break;
				}
			}
			if(isP) {
			cnt++;
			}
		}
	}
	
	
	
	System.out.printf("#%d %d",t,cnt);
	
	
		}
	
	}
}
