package SWEA_1218_괄호짝짓기;

import java.util.Scanner;

public class Solution {
	
	// 메인 메소드
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 유효성 여부를 저장하기 위한 배열 valid 만들기
		int[] valid = new int[10];
		
		// 기본값 1로 설정
		for (int i=0; i<10; i++) {
			valid[i] = 1;
		}
		
		for (int i=0; i<10; i++) {
			
			// 테스트 케이스의 길이 입력
			int N = sc.nextInt();
			
			String brackets = sc.next();
			
			// 괄호들로 이루어진 문자열을 나누어 저장할 char 배열 만들기
			char[] split = new char[N];
			
			// 괄호들로 이루어진 문자열을 나누어 char 배열에 저장
			for (int j=0; j<N; j++) {
				split[j] = brackets.charAt(j);
			}
			
			// stack 활용하여 유효성 여부 판단
			for (int j=0; j<N; j++) {
				// 모든 종류의 여는 괄호는 push
				if (split[j] == '(' || split[j] == '[' || split[j] == '{' || split[j] == '<') {
					push(split[j]);
				}
				// 닫는 괄호일 때 stack의 가장 위에 있는 여는 괄호가 같은 종류인지 파악하여 같은 종류면 pop, 다른 종류면 유효하지 않음
				else if (split[j] == ')') {
					if (peek() != '(') {
						valid[i] = 0;
						break;
					}
					else pop();
				}
				else if (split[j] == ']') {
					if (peek() != '[') {
						valid[i] = 0;
						break;
					}
					else pop();
				}
				else if (split[j] == '}') {
					if (peek() != '{') {
						valid[i] = 0;
						break;
					}
					else pop();
				}
				else if (split[j] == '>') {
					if (peek() != '<') {
						valid[i] = 0;
						break;
					}
					else pop();
				}
			}
			
			// 모든 괄호를 봤을 때 stack이 비어있지 않으면(여는 괄호만 남아있는 경우) 유효하지 않음
			if (!isEmpty()) {
				valid[i] = 0;
			}
			
			// 각 테스트 케이스마다 stack 리셋
			reset();
			
		}
		// 문제에서 요구하는 대로 유효성 여부 출력
		for (int i=0; i<10; i++) {
			System.out.println("#" + (i+1) + " " + valid[i]);
		}
	}
	
	// 문자들을 담을 stack 배열 생성
	static char[] stack = new char[1000];
	
	// 마지막으로 삽입된 위치를 알기 위한 top 변수 -1로 설정
	static int top = -1;
	
	// 비어있는지 판단하기 위한 isEmpty 메소드 구현
	static boolean isEmpty() {
		return top == -1;
	}
	
	// 삽입을 위한 push 메소드 구현
	static void push(char bracket) {
		stack[++top] = bracket;
	}
	
	// 출력 후 삭제를 위한 pop 메소드 구현
	static char pop() {
		if (!isEmpty()) {
			return stack[top--];
		}
		else return '0';
	}
	
	// 마지막으로 삽입된 문자를 알기 위한 peek 메소드 구현
	static char peek() {
		if (!isEmpty()) {
			return stack[top];
		}
		else return '0';
	}
	
	// stack 초기화를 위한 reset 메소드 구현
	static void reset() {
		top = -1;
	}
}
