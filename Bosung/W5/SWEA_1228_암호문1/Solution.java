package SWEA_1228_암호문1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			// 암호문을 저장하기 위한 연결리스트 password 만들기
			List<Integer> password = new LinkedList<>();
			
			// 원본 암호문의 길이 N 입력
			int N = sc.nextInt();
			
			// N개의 숫자를 입력받아 password에 저장
			for (int i = 0; i < N; i++) {
				password.add(sc.nextInt());
			}
			
			// 명령어의 개수 입력
			int M = sc.nextInt();
			
			// 받은 명령어의 개수만큼 암호문 수정하기
			for (int i = 0; i < M; i++) {
				
				// 처음 받는 I 없애기
				sc.next();
				
				// 숫자를 추가할 인덱스
				int index = sc.nextInt();
				
				// 숫자를 추가할 횟수
				int count = sc.nextInt();
				
				// count만큼 숫자를 받아 index의 위치에 추가하고
				// index에 1을 추가하며 다음 숫자도 암호문에 추가하기 
				for (int j = 0; j < count; j++) {
					password.add(index++, sc.nextInt());
				}
			}
			
			// 수정된 암호문 앞의 10개씩 출력
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(password.get(i) + " ");
			}
			System.out.println();
		}
	}
}
