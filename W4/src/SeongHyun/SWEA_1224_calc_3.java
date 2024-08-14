package SWEA_1224_계산기3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import SWEA_1224_계산기3.stack3;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
		int L = sc.nextInt();
		String expression = sc.next();
		
		String postfix = infixToPostfix(expression);
		int result = evalPostfix(postfix);
		System.out.println("#" + test_case + " " + result);
		}
		sc.close();
		}
		
		static int evaluate(String expression) {
			String postfix = infixToPostfix(expression);
			return evalPostfix(postfix);
		}
		
		
		static Map<Character, Integer> map = new HashMap<>();
		
		static {
		map.put('+', 1);
		map.put('*', 2);
		}
		
		
		static String infixToPostfix(String infix) {	// 중위 표기식
			
			String postfix = "";						// 길이가 0인 문자열로 초기화
			 stack<Character> stack = new<> stack(infix.length());
			
			for (int i = 0; i < infix.length(); i++) {
				char c = infix.charAt(i);
				
				// 피연산자가 나오면 바로 출력
				if ('0' <= c && c <= '9') {
					postfix += c;
				} else if ( c == '(' ) {
					stack.push(c);				// 여는 괄호는 스택에 push
				} else if ( c == ')' ) {
					char popItem = stack.pop();	// 닫는 괄호는 여는 괄호 나올때까지 pop
					while (popItem != '(') {
						postfix += popItem;
						popItem = stack.pop();
					}
				} else {
					// 연산자 스택에 마지막에 우선순위가 낮은 연산자가 올 때까지 pop
					while (!stack.isEmpty() 
							&& stack.peek() != '(' 
							&& map.get(stack.peek()) >= map.get(c)) {
						char popItem = stack.pop();
						postfix += popItem;
					}
					
					stack.push(c);
				}
			}
			
			// 스택 비워주기
			while (!stack.isEmpty()) {
				postfix += stack.pop();
			}
			
			return postfix;
		}
		static int evalPostfix(String postfix) {
			
			 stack<Integer> stack = new stack<>(postfix.length());
			
			for ( int i = 0; i < postfix.length(); i++) {
				char c = postfix.charAt(i);
				
				if ('0' <= c && c <= '9') {
					stack.push( c - '0');					// 빼야 정수가 들어감
				} else {
					int num2 = stack.pop();
					int num1 = stack.pop();
					int result;
					
					if ( c== '+') {
						result = num1 + num2;
					} else  {
						result = num1 * num2;
					} 
					stack.push(result);
				}
			}
			return stack.pop();
		}
		
}

// 일단 계산값은 정상...