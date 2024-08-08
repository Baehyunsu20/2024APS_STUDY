package SWEA_5432_쇠막대기자르기;

import java.util.Scanner;

public class Solution {
	
	// 메인 메소드
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 입력
		int t = sc.nextInt();
		
		// 테스트 케이스 수 만큼 조각의 수를 저장할 배열 생성
		int[] count = new int[t];
		
		for (int i=0; i<t; i++) {
			
			// 괄호들을 문자열로 입력
			String brackets = sc.next();
			
			// 괄호들을 나누어 문자로 저장할 배열 split 생성
			char[] split = new char[brackets.length()];
			
			// 괄호로 이루어진 문자열을 나누어 split 배열에 저장
			for (int j=0; j<brackets.length(); j++) {
				split[j] = brackets.charAt(j);
			}
			
			// stack 구조를 활용하여 조각의 수 구하기
			for (int j=0; j<split.length; j++) {
				// 여는 괄호는 push
				if (split[j] == '(') {
					push(split[j]);
				}
				// 닫는 괄호이면서 바로 왼쪽이 여는 괄호일 경우(레이저일 경우) 
				// count 메소드를 사용하여 count 배열에 누적된 여는 괄호의 개수-1 만큼 추가한 뒤 pop
				else if (split[j-1] == '(') {
					count[i] += count();
					pop();
				}
				// 닫는 괄호이면서 바로 왼쪽이 여는 괄호가 아닐 경우
				// count 배열에 1추가한 뒤 pop
				else {
					count[i] += 1;
					pop();
				}
			}
		}
		
		// 문제에서 요구한 대로 잘려진 조각의 총 개수 출력
		for (int i=0; i<t; i++) {
			System.out.println("#" + (i+1) + " " + count[i]);
		}
	}
	
	// stack 구현
	// 문자들을 담을 stack 배열 생성
	static char[] stack = new char[100000];
	
	// 마지막 삽입 위치를 알기 위한 top 변수 -1로 설정
	static int top = -1;
	
	// 배열에 문자를 삽입하기 위한 push 메소드 구현
	static void push(char bracket) {
		stack[++top] = bracket;
	}
	
	// 배열에서 문자를 삭제하기 위한 pop 메소드 구현
	static char pop() {
		return stack[top--];
	}
	
	// 조각의 개수를 세기 위한 count 메소드 구현
	static int count() {
		return top;
	}
}
