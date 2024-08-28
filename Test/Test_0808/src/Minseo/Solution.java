package Minseo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("src/input_minseo.txt"));
		
		char[][] arr = new char[100][100];
		for(int t=1;t<=10;t++) {
			int tc = Integer.parseInt(sc.nextLine());
			
			// 배열 받아오기
			for(int i=0;i<100;i++) {
				arr[i]=sc.nextLine().toCharArray();
			}
			
			// 회문의 최대길이 구하기		
			// 가로
			int max1=0;
			for(int r=0;r<100;r++) {
				for(int c=0;c<99;c++) {
					int j=1;
					// 만약 arr[r][c] 문자랑 바로 오른쪽 문자가 같으면
					if(arr[r][c]==arr[r][c+1]) {
						// 한칸 왼쪽, 한칸 오른쪽 이동한 문자들도 같은지 확인
						while(c+j+1>=0 && c+j+1<100 &&c-j>=0 && c-j<100) {
							if(arr[r][c-j]==arr[r][c+(j+1)]) {
								j++;
							}else {
								break;
							}
						
						}
						// 최대 길이값 업데이트
						if(2*j>max1) {
							max1=2*j;
						}	
						// arr[r][c]문자랑 바로 오른쪽 문자가 같지 않으면 arr[r][c]기준으로 양 옆 문자가 같은지 확인
					}else {
					while(c+j>=0 && c+j<100 &&c-j>=0 && c-j<100) {
						if(arr[r][c+j]==arr[r][c-j]) {
							j++;
						}else {
							break;
						}
					}
					// 최대 길이값 업데이트
					if(2*(j-1)+1>max1) {
						max1=2*(j-1)+1;
						}					
					}
				}
			}
			// 세로
			int max2=0;
			for(int r=0;r<99;r++) {
				for(int c=0;c<100;c++) {
					int j=1;
					if(arr[r][c]==arr[r+1][c]) {
						while(r+j+1>=0 && r+j+1<100 &&r-j>=0 && r-j<100) {
							if(arr[r-j][c]==arr[r+(j+1)][c]) {
								j++;
							}else {
								break;
							}
						}
						if(2*j>max2) {
							max2=2*j;
						}					
					}else {
					while(r+j>=0 && r+j<100 &&r-j>=0 && r-j<100) {
						if(arr[r+j][c]==arr[r-j][c]) {
							j++;
						}else {
							break;
						}
					}
					if(2*(j-1)+1>max2) {
						max2=2*(j-1)+1;
						}					
					}
				}
			}
			
			// 가로, 세로에서 구한 회문 최대길이 max1, max2중 최대길이 구하기
			int max=max1>max2? max1:max2;
			
			System.out.printf("#%d %d\n",tc,max);
			
			
		}
	}
}
