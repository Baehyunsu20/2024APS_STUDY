package SWEA_1222_계산기1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	// 메인 메소드
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 만큼 ans 배열 생성
		int[] ans = new int[10];
		
		for (int i = 0; i < 10; i++) {
			
			// 문자열의 길이 입력
			int N = sc.nextInt();
			
			// 문자열 입력
			String input = sc.next();
			
			// 중위표기법으로 문자를 저장할 infix 배열 생성
			char[] infix = new char[N];
			
			// 문자열을 문자로 나누어 저장
			for (int j = 0; j < N; j++) {
				infix[j] = input.charAt(j);
			}
			
			// 후위표기법으로 문자를 저장할 postfix 배열 생성
			char[] postfix = new char[N];
			// stack 구조로 postfix 배열에 저장하기 위해 변수 top을 -1로 설정
			int top = -1;
			
			// stack 구조를 활용하여 후위표기법 배열 만들기
			for (int j = 0; j < N; j++) {
				// +면 stack에 push
				if (infix[j] == '+') {
					push(infix[j]);
				}
				// 피연산자면 infix[j]를 postfix에 넣기 (push 하는 느낌)
				else {
					postfix[++top] = infix[j];
					// stack이 비어있지 않다면 pop 한 것도 postfix에 넣기 (push 하는 느낌, +만 들어감)
					if (!isEmpty()) {
						postfix[++top] = popChar();
					}
				}
			}
			// stack을 또 사용하기 위해 reset 메소드 사용 (앞서 사용한 stackChar과 다른 stackInt을 쓰긴 하지만 같은 top을 사용하기 때문)
			reset();
			
			// 합을 저장하기 위한 sum 변수 0으로 설정
			int sum = 0;
			
			// stack 구조를 사용하여 후위표기법으로 표기된 배열의 합을 구함
			for (int j = 0; j < N; j++) {
				// +면 stack에 있는 두 숫자를 pop하여 더하고 sum에 저장 후 push
				if (postfix[j] == '+') {
					sum = popInt() + popInt();
					push(sum);
				}
				// 피연산자면 push (이때 char 자료형으로 표현된 숫자들을 int로 바꾸어 push 하기 위해 문자 '0'을 뺀 후 push 함)
				else {
					push((int) (postfix[j] - '0'));
				}
			}
			
			// stackInt에 저장되어 있는 마지막 합을 ans[i]에 저장
			ans[i] = popInt();
			
			// 다음 케스트 케이스를 위해 reset
			reset();
		}
		// 테스트 케이스마다 저장된 합 출력
		for (int i = 0; i < 10; i++) {
			System.out.println("#" + (i+1) + " " + ans[i]);
		}
	}
	
	// stack 구현을 위해 ArrayList로 char, int 배열 만들기
	static List<Character> stackChar = new ArrayList<>();
	static List<Integer> stackInt = new ArrayList<>();
	
	// 마지막으로 삽입된 곳의 위치를 알기 위한 top -1로 설정
	static int top = -1;
	
	// 비어있는지 확인하기 위한 isEmpty 메소드 구현
	static boolean isEmpty() {
		return top == -1;
	}
	
	// char 자료형을 삽입하기 위한 push 메소드 구현
	static void push(char a) {
		stackChar.add(++top, a);
	}
	// int 자료형을 삽입하기 위한 push 메소드 구현
	static void push(int a) {
		stackInt.add(++top, a);
	}
	
	// char 자료형을 출력하기 위한 popChar 메소드 구현
	static char popChar() {
		return stackChar.get(top--);
	}
	// int 자료형을 출력하기 위한 popInt 메소드 구현
	static int popInt() {
		return stackInt.get(top--);
	}
	
	// top 변수를 다시 -1로 설정하는 reset 메소드 구현
	static void reset() {
		top = -1;
	}
}