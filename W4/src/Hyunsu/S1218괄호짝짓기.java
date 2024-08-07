package Hyunsu;
import java.util.*;

public class S1218괄호짝짓기 {
	static Scanner sc =new Scanner(System.in);
	static List<Character> stack = new ArrayList<>();
	
	public static void main(String[] args) {
		for(int t=1; t<=10; t++) {
			//스택 초기화
			stack = new ArrayList<>();
			
			//0인지 아닌지 : 0이면 유효X, 1이면 유효
			int tf = 1;
			
			//몇개의 문자인지 가져옴	
			int num = sc.nextInt();
			//모든 괄호를 일단 가져옴.
			String input = sc.next();
			for(int time=0; time <num; time++) {
				//앞에서부터 차근차근 가져옴.
				char tmp = input.charAt(time);
//				System.out.println("tmp : "+tmp);
				//인풋을 받아오고, 닫는 괄호가 나올 때는, top의 괄호와 맞아야함.
				if(tmp=='{' || tmp=='[' || tmp=='(' || tmp=='<') {
					//여는 괄호가 나오면 stack에 쌓아둠.
					push(tmp);
//					System.out.println(time + "번째"+" push");
				}
				else if(tmp=='}') {
					if(peek()=='{') {
						pop();
						tf=1;
//						System.out.println(time + "번째"+"pop"+"tf : "+tf);
					}
					else {
						//짝이 안 맞을 경우
						tf=0;
						break;
						
					}
				}
				else if(tmp==']') {
					if(peek()=='[') {
						pop();
						tf=1;
//						System.out.println(time + "번째"+" pop, "+"tf : "+tf);
					}
					else {
						//짝이 안 맞을 경우
						tf=0;
						break;
						
					}
					
				}
				else if(tmp==')') {
					if(peek()=='(') {
						pop();
						tf=1;
//						System.out.println(time + "번째 "+"pop"+"tf : "+tf);
					}
					else {
						//짝이 안 맞을 경우
						tf=0;
						break;
						
					}
					
				}
				else if(tmp=='>') {//나머지 ">"
//					System.out.println("> 들어옴");
					if(peek()=='<') {
						pop();
						tf=1;
//						System.out.println(time + "번째 "+"pop"+"tf : "+tf);
					}
					else {
						//짝이 안 맞을 경우
						tf=0;
						break;
						
					}
				}
				else {
					System.out.println("괄호가 아닌 것이 들어왔습니다.");
					tf=0;
				}
				
				
			}//전체 배열을 다 확인 = for문 완료
			System.out.println("#"+t+" "+tf);
		}
		
		
	}
	
	static boolean isEmpty() {
		return stack.isEmpty();
	}
	

	private static char pop() {
		if(isEmpty()) {
			return 0;
		}
		int top = stack.size()-1;
		char res = stack.get(top);
		//동적배열에서 아예 삭제
		stack.remove(top);
		
		return res;
	}

	private static char peek() {
		return stack.get(stack.size()-1);
	}

	private static void push(char tmp) {
		stack.add(tmp);
	}

}
