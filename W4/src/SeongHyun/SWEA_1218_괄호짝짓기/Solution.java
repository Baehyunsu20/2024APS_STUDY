package SWEA_1218_괄호짝짓기;

import java.util.Scanner;

public class Solution
{
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		// int [] rep = new int[10];								// 각 테스트 케이스에 자동적으로 크기 저장
		// for (int test_case = 0; test_case < 10; test_case++) {  // 테스트 케이스 반복
		// 	rep[test_case] = sc.nextInt();							// 한번에 출력하는건데 일단 여기선 버림
		// }	

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int L = sc.nextInt();									// 테스트 케이스 길이
            // int L = rep[test_case];
            Stack stack = new Stack(L);								
            String S = sc.next();									// 문자열 입력
            for (int i = 0; i < L; i++) {							 
				char c = S.charAt(i);								// String형에서 char로 변환
                    String ST = stack.top();              	
					if ((c == ')' && "(".equals(ST))  				// 닫힌 괄호들은 일단 top과 비교
						|| ( c == '}' && "{".equals(ST)) 
						|| ( c == ']' && "[".equals(ST))
						|| ( c == '>' && "<".equals(ST))) {		
						stack.pop();								// 짝이면 쌍소멸
					} else {
							stack.push(Character.toString(c));		// 열린 괄호들은 일단 스택
							}

                    } 
					if (!stack.isEmpty()) {
						System.out.println("#" + test_case + " 0");	// 유효하지 않으면 0
					} else {
						System.out.println("#" + test_case + " 1");	// 유효하면 1
					}

            }
		}

	}

class Stack {														// stack 클래스
	private int max;
	private int top;
	private String[] stack;
	
	public Stack(int size) {										// stack에 대한 메서드
		this.max = size;
		this.stack = new String[max];
		this.top = -1;
	}
	
	public void push(String word) {									// stack.push 메서드
		if ( top >= max - 1) {
			return;
		}
		stack[++top] = word;
	}
	
	public String pop() {											// stack.pop 메서드
		if (isEmpty()) {
			return null;
		}
		return stack[top--];
	}
	
	public boolean isEmpty() {										// stack.isEmpty 메서드
		return (top == -1);
	}
    
	public String top() {											// stack.top 메서드
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }
	
}

// 후기 : stack에서 막힐 땐 String 대신  Char로 가보자..(문자열일 때!)
