package Test0809;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <의석이의 세로로 말해요>
 * 단어가 5개 -> 세로로 일기 
 * 길이가 달라 세로로 비어있는 글자는 스킵
 * 최대글자수는 15.
 */

public class Solution {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			//단어 5개만 고정
			String[][] arr = new String[5][15];
			
			for(int line=0; line<5;line++) {
				//한줄로 받아오고
				String tmp = sc.next();
				//공백없이 한글자씩 쪼개기
				String[] tmp2= tmp.split("");
				
				for(int c=0;c<tmp2.length;c++) {
					//들어온 글자의 길이만큼 순회
					arr[line][c]=tmp2[c];
				}
			}//배열의 완성
			System.out.print("#"+t+" ");
			for(int c=0; c<15; c++) {
				for(int r=0; r<5; r++) {
					//세로로 읽기
					if(arr[r][c] == null) {
						//null이면 다음 세로 글자로 넘어감
						continue;
					}
					System.out.print(arr[r][c]);
				}
			}
			System.out.println();

		}

	}
	
	

}
