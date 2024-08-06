package Minseo;
import java.util.*;
import java.io.*;
public class SWEA1218괄호짝짓기 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("src/input.txt"));

		for(int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
	        String s = sc.next();

	        Stack<Character> stack = new Stack<>();
	        boolean isBalanced = true;
	        
	        for(int i = 0; i < N; i++) {
	        	char c = s.charAt(i);

	        	// 여는 괄호는 스택에 넣습니다.
	        	if(c == '(' || c == '{' || c == '[' || c == '<') {
	        		stack.push(c);
	        		} 
	        	// 닫는 괄호는 스택에서 꺼내어 짝이 맞는지 확인합니다.
	        	else if(c == ')' || c == '}' || c == ']' || c == '>') {
	        		if(stack.isEmpty()) {
	        			isBalanced = false;
	        			break;
	        			}
	        		char top = stack.pop();
	        		if((c == ')' && top != '(') ||
	        			(c == '}' && top != '{') ||
	        			(c == ']' && top != '[') ||
	        			(c == '>' && top != '<')) {
	                    isBalanced = false;
	                    break;
	                    }
	        		}
	            }

	            // 스택이 비어있지 않으면 괄호가 모두 짝지어지지 않은 것입니다.
	            if(!stack.isEmpty()) {
	                isBalanced = false;
	            }

	            System.out.println("#" + t + " " + (isBalanced ? 1 : 0));
	        }

	        sc.close();
	    }
	}

