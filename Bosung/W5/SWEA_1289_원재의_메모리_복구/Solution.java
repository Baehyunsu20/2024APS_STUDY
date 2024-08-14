package SWEA_1289_원재의_메모리_복구;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 메모리를 하나씩 자르기 위해 String으로 받음
			String memory = sc.next();
			
			// 하나씩 자른 메모리를 저장할 char 배열 만들기
			char[] code = new char[memory.length()];
			
			// 하나씩 잘라서 char 배열에 넣기
			for (int i = 0; i < memory.length(); i++) {
				code[i] = memory.charAt(i);
			}
			
			// char 배열에 저장된 숫자와 비교하기 위한 check 생성
			char check = '0';
			int count = 0;

			// char 배열이 check와 다를 때마다 count를 1씩 증가시키고 check를 0이면 1로, 1이면 0으로 바꾸기
			for (int i = 0; i < code.length; i++) {
				if (code[i] != check) {
					count++;
					if (check == '0') {
						check = '1';
					}
					else {
						check = '0';
					}
				}
			}
			
			// 테스트 케이스와 최소 수정 횟수 출력
			System.out.println("#" + test_case + " " + count);
		}
	}
}
