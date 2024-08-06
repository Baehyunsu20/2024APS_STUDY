package SWEA_1222_계산기1;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	for(int test_case = 1; test_case <= 10; test_case++)
	{
	int L = sc.nextInt();
	String expression = sc.next();
	
	String postfix = infixToPostfix(expression);
//	System.out.println(postfix);
	int result = evalPostfix(postfix);
	System.out.println("#" + test_case + " " + result);
	}
	}
	
	static int evaluate(String expression) {
		String postfix = infixToPostfix(expression);
		return evalPostfix(postfix);
	}
	
	
	static String infixToPostfix(String infix) {	// 중위 표기식
		
		String postfix = "";						// 길이가 0인 문자열로 초기화
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			// 피연산자가 나오면 바로 출력
			if ('0' <= c && c <= '9') {
				postfix += c;
			} else {
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
		
		Stack<Integer> stack = new Stack<>();
		
		for ( int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if ('0' <= c && c <= '9') {
				stack.push( c - '0');					// 빼야 정수가 들어감
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result;
				
				result = num1 + num2;
				stack.push(result);
			}
		}
		return stack.pop();
	}
	
}

// ㄴ SWEA pass본
// 과제 제출본    
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         for (int test_case = 1; test_case <= 10; test_case++) {
//             int L = Integer.parseInt(sc.nextLine());
//             String expression = sc.nextLine();

//             int result = evalPostfix(expression);
//             System.out.println("#" + test_case + " " + result);
//         }
//         sc.close();
//     }

//     static int evalPostfix(String expression) {
//         stack stack = new stack (expression.length());

//         for (int i = 0; i < expression.length(); i++) {
//             char c = expression.charAt(i);

//             if ('0' <= c && c <= '9') {
//                 stack.push(c - '0');
//             } else if ( c == '+') {
//                 int num2 = stack.pop();
//                 int num1 = stack.pop();
//                 int result = num1 + num2;
//                 stack.push(result);
//             }
//         }
// 		int ans = 0;
// 		while (!stack.isEmpty()) {
// 			ans += stack.pop();
// 		}
//         return ans;
//     }
// }

// 스택을 새로 구성하는 과정에서 뭔가 단단히 꼬여서
// 내부 라이브러리랑 사용할때의 코드를 쓰면 꼬여버리는 상황...
// 일단 코드 출력값은 정상적이니 나중에 알아보자...