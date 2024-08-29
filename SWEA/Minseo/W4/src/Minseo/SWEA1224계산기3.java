package Minseo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class SWEA1224계산기3 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("src/input(1).txt"));
		
		for(int t=1;t<=10;t++) {
		
		int N = sc.nextInt();
		sc.nextLine();
		String expression = sc.nextLine();
		
		String postfix = infixToPostfix(expression);
		System.out.println("#"+t+" "+postfix);
		}
		
	}
	
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
	}
	
	
	static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for (int i=0;i<infix.length();i++) {
			char c = infix.charAt(i);
			
			// 피연산자가 나오면 바로 출력
			if('0' <= c && c<='9') {
				postfix += c;				
			} else if(c=='(') {
				stack.push(c);
			} else if(c==')') {
				char popItem = stack.pop();
				while(popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else {
				// 연산자
				// 스택의 마지막에
				// 우선순위가 낮은 연산자가 올 때까지 pop
				while(!stack.isEmpty() && stack.peek() != '(' &&
						map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					postfix+=popItem;
				}
				
				stack.push(c);
			}
		}
		// 스택 비워주기
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}

}