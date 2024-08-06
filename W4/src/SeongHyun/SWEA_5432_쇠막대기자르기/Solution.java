package SWEA_5432_쇠막대기자르기;

import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();                                   // 테스트 케이스 입력                                       // 중첩된 파이프 개수                                     // 잘린 파이프 카운트
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sum = 0;                                        // 썰린 쇠막대기 합
            int P = 0;                                          // 쇠막대기 중첩상태
            String S = sc.next();
            int size = S.length();
            Stack stack = new Stack(size);

            for (int i = 0; i < size; i++) {
                char c = S.charAt(i);
                
                if ( c== '(') {                                 // 중첩상태로 전개
                    stack.push(Character.toString(c));
                    P++;
                }
                else if ( c == ')'  ) {                         // 종단지점
                    stack.pop();
                    P--;
                    if ( S.charAt(i-1) == '(') {                // () 레이저 썰기
                        sum += P;
                    } else {                                    // 쇠막대기의 끝(최상단 꽁다리 추가)
                        sum++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + sum);
    }
}

}

class Stack {													// stack 클래스
	private int max;
	private int top;
	private String[] stack;
	
	public Stack(int size) {									// stack에 대한 메서드
		this.max = size;
		this.stack = new String[max];
		this.top = -1;
	}
	
	public void push(String word) {								// stack.push 메서드
		if ( top >= max - 1) {
			return;
		}
		stack[++top] = word;
	}
	
	public String pop() {										// stack.pop 메서드
		if (isEmpty()) {
			return null;
		}
		return stack[top--];
	}
	
	public boolean isEmpty() {									// stack.isEmpty 메서드
		return (top == -1);
	}
    
	public String top() {										// stack.top 메서드
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }
	
}