package SWEA_1230_암호문3;

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
				
				// 명령어 확인
				char alphabet = sc.next().charAt(0);
				
				// 명령어가 I로 시작하는 경우
				if (alphabet == 'I') {
					
					// 숫자를 추가할 인덱스와 숫자를 추가하는 횟수
					int index = sc.nextInt();
					int count = sc.nextInt();
					
					// count만큼 숫자를 받아 index의 위치에 추가하고
					// index에 1을 추가해가며 다음 숫자도 암호문에 추가하기
					for (int j = 0; j < count; j++) {
						password.add(index++, sc.nextInt());
					}
				}

				// 명령어가 D로 시작하는 경우
				else if (alphabet == 'D') {
					
					// 숫자를 제거할 인덱스와 숫자를 제거하는 횟수
					int index = sc.nextInt();
					int count = sc.nextInt();
					
					// index의 위치에서 count만큼 숫자 제거
					for (int j = 0; j < count; j++) {
						password.remove(index);
					}
				}

				// 명령어가 A로 시작하는 경우
				else if (alphabet == 'A') {
					
					// 숫자를 추가하는 횟수
					int count = sc.nextInt();
					
					// password의 마지막에 count만큼 숫자 추가
					for (int j = 0; j < count; j++) {
						password.add(sc.nextInt());
					}
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
