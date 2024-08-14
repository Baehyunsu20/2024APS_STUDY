package Hyunsu;
import java.util.*;
/**
 * 스택의 사용
 * (--------) 막대기/ () 얘는 레이저/  
 * ( ( ( () ( ( () ) ) () ) ) ) -> 막대기 3개와 레이저 2개 : 
 * 막대기 하나당 (레이저 갯수 2 +1) =3 만큼의 조각 생성 * 총 막대기 3개 = 총 9개의 조각
 * 막대기의 갯수를 ((( 로 세고 . ()()갯수를 센다
 * ((( 를 stack에 쌓음 / ')'가 나오면  top '('을 pop / 해서 
 * 
 * 뒤에서 부터 읽어왔을때 이전의 입력이 여는괄호라서 ) -> ( : ()이 된다면 레이저다.
 * top의 최댓값 = 막대기의 갯수 (최댓값 갱신)
 * 레이저의 갯수 = () 가 연속 일때는 카운트를 해주기?
 * 스택이 채워지고 비워지는 동안은 같은 레이저의 수를 가진다.
 */

public class S5432_쇠막대자르기 {
	static Scanner sc = new Scanner(System.in);
	static List<Character> stack = new ArrayList<>();
	static int bar;
	static int lasernum;
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t =1; t<=T; t++) {
			//테스트 케이스마다 초기화
			bar = 0;
			lasernum = 0;
			int part = 0;
			stack = new ArrayList<>();
			
			String input = sc.next();
			for(int tmp=0; tmp<input.length(); tmp++) {
				char one = input.charAt(tmp);
				if(one == '(') {
					//여는 괄호일때는 input
					System.out.println("push했어요");
					push(one);
				}
				else {
					//')'일때
					//1. 직전의 인풋이 '('라면 : ()
					//2. 직전의 인풋이 ')'라면 : ))
						if(input.charAt(tmp-1)=='(') {
							// ()의 완성 -> 레이저의 갯수를 카운트 해주고, '('를 pop
							lasernum++;
							System.out.println("()의 상황 : pop 했어요");
							pop();
						}
						else if(input.charAt(tmp-1)==')') {
							// ))의 상황
//							bar++;
							int tmp1 = lasernum +1;
							part += tmp1 * stack.size();
							pop();
							System.out.println("빼기전 조각 : "+part+" 스택 사이즈 : "+stack.size());
							part -= stack.size();
							System.out.println("))의 상황 : pop 했어요, 조각 : "+part);
						}
						//pop이후에 비어있으면, 막대가 끝남. 이제 조각 갯수 계산
						if(isEmpty() && tmp!=0) {
							lasernum =0;
						}
					
					
				}
			}
			System.out.println("#"+t+" "+part);
			
			
		}
		
	}

	private static char peek() {
		if(isEmpty()) {
			return 0;
		}
		return stack.get(stack.size()-1);
	}

	private static char pop() {
		if(isEmpty()) {
			return 0;
		}
		char tmp =  stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return tmp;
	}

	private static boolean isEmpty() {
		return stack.isEmpty();
	}

	private static void push(char one) {
		stack.add(one);
	}
	

}
