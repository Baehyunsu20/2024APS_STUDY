package Minseo;
import java.util.*;
import java.io.*;

public class SWEA1218괄호짝짓기 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("src/input.txt"));
		
		for(int t=1;t<=10;t++) {
			int N = sc.nextInt();
			String s = sc.next();
			
			Stack<Character> stack = new Stack<>();
			boolean mismatch = false;
			
			// 문자열 가져오기
			for(int i=0;i<N;i++) {
				char c = s.charAt(i);
				
				// 여는 괄호면 push
				if(c=='('||c=='{'||c=='['||c=='<') {
					stack.push(c);
				} else { // 닫는 괄호면 c랑 그 전(top)값, 둘이 비교
					// 그 전에 처음부터 닫는 괄호면 break하고 0 출력
					if(stack.isEmpty()) {
						mismatch=true;
						break;
					}else {
						// stack.pop() -> top에 담고 값 비교
						char top = stack.pop();
						if(c==')'&&top=='('||c=='}'&&top=='{'||
								c==']'&&top=='['||c=='>'&&top=='<') {
							continue;
						}else {
							mismatch = true;
						}
					}
				}
				
				if(mismatch==true) break;
			}
			
			if(stack.isEmpty()&&!mismatch) {
				System.out.println("#"+t+" 1");
			}else {
				System.out.println("#"+t+" 0");
			}
		}
		
		
	}

}

