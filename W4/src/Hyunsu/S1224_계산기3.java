package Hyunsu;
import java.util.*;

/**
* 후위표기식으로 바꿔서 계산
* 피연산자는 바로 출력 또는 따로 저장, 연산자는 stack에 저장 및 pop push.
* ..
*/

public class S1224_계산기3{
	//연산자를 넣어줄 동적배열 arrayList 만들어주기
	static ArrayList<Character> stack = new ArrayList<>();
	//후위연산식으로 바꾸어 담기 위한 동적배열 post
	static ArrayList<Character> post = new ArrayList<>();
	static int top = -1;
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		//총 10개의 테스트케이스
		for(int t=1; t<=1; t++) {
			//총 문자열의 길이가 주어짐. 그 크기의 배열을 만들어주기 -> char 배열로 만들기, 숫자와 기호만 있기 때문
			int size = sc.nextInt();
			
			String inputLine = sc.next();
			for(int i=0; i<size; i++){
				//next()로 하면 띄어쓰기가 없어서 한줄로 모두 들어옴.
				char tmp = inputLine.charAt(i);
				//숫자가 들어올 때와 +가 들어올 경우.
					// +기호가 tmp일 경우 = stack에 push
					// 숫자가 tmp일 경우 = stack에서 pop
//				System.out.println("tmp : "+tmp);
				
				if(tmp == '+' || tmp =='*') {
					push(tmp);
				}					
				// 숫자가 tmp일 경우 = stack에서 pop
				else if(tmp >= '0' && tmp<='9') {
					//숫자가 들어올 경우, 숫자 뒤에 stack에서 pop하여 post 배열에 넣는다.
					post.add(tmp);
					if(!(isEmpty())){
						post.add(pop());
					}
				}
			}
			//후위표기식으로 완성.
			System.out.println("TC : "+t+" "+post);
			
			
			 int result = evaluate(post);
			 
			 System.out.println("#"+t+" "+result);
			
			

		}
		
		
	}
	
	//후위 표기식의 계산
	private static int evaluate(ArrayList<Character> post) {
		//stack을 이용한 pop, push
		//post라는 후위연산식이 들어오면
		//연산을 위한 stack이 하나 더 있어야겠다 / 여기는 숫자만 들어감
		ArrayList<Integer> calculation = new ArrayList<>();
		for(char n:post) {
			//순회를 하면서 연산
//			System.out.println("들어온 n값 : "+n);
			if(n>'0' && n<='9') {
				//숫자일 경우에는 스택에 쌓기
				//아스키 값을 이용.
				int tmp = n - '0';
//				System.out.println("tmp "+ tmp);
				push_list(calculation, tmp);
//				System.out.println(calculation);
			}else {
				//숫자가 아닐 때, n이 문자일 때.
				int num1 = pop_list(calculation);
//				System.out.println("num1 : "+num1);
				int num2 = pop_list(calculation);
//				System.out.println("num2 : "+num2);
				
				int ans = num1 + num2;
//				System.out.println("합해짐 "+ans);
				push_list(calculation, ans);
			}
			
			
		}
		
		//마지막에 남는 요소가 최종 연산값 : char -> int 를 위해 0문자열 빼주기.
		return pop_list(calculation);
	}

	// 스택이 비어있는지 확인하는 isEmpty
	static boolean isEmpty() {
		//top ==-1이면(stack이 비어있는 경우) true를 반환
		return top ==-1;
	}
	
	//pop 연산
	static char pop() {
		//비어있지않으면
		if(isEmpty()) {
			//처음에는 당연히 비어있음
			System.out.println("스택이 비었습니다. 아마 연산이 끝났습니다.");
			return 0;
		}
		// top 갱신
		return stack.get(top--);
	}
	
	//push 연산, 동적 배열 stack에 +를 넣는 문제
	static void push(char tmp) {
		stack.add(tmp);
		//내용물을 추가했으니 peek 갱신
		top++;
	}
	
	//------------------------------------------------------------//
	
	//동적배열을 이용한 pop, push를 만들어보자 -> top이 필요없음, 사이즈가 유동적이기때문
	static boolean isEmpty_list(ArrayList<Integer> cal) {
		return cal.isEmpty();
	}
	
	static int pop_list(ArrayList<Integer> cal) {
		if(isEmpty_list(cal)) {
			//비어있으면
//			System.out.println("post가 비어있습니다.");
			return 0;
		}
		//가장 마지막 = -1
//		return post.get(-1); -> arrayList는 음수 인덱스를 지원하지않음
		int peek = cal.size()-1;
		//마지막 요소를 반환해주고, 요소를 삭제함.
		int pop_element = cal.get(peek);
		cal.remove(peek);
		
		return pop_element;
	}
	
	static void push_list(ArrayList<Integer> cal, int tmp) {
		cal.add(tmp);
	}
	
}

