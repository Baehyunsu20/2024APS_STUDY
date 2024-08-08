package Hyunsu;
import java.util.*;
/**
 * 카드를 절반을 나누고(인풋으로 들어온 숫자 N을 반으로 나눔)
 * 중첩클래스를 사용하지 않는 방법으로 -> if로 q1, q2를 나눔.
 * 
 */

public class S3499_퍼펙트셔플 {
	static Scanner sc = new Scanner(System.in);
	static int T = sc.nextInt();
	//범위가 1부터 1000까지 가능 = 최대 배열의 크기 = 1000
	//반으로 나눠서 진행
	static String[] queue1 = new String[600];
	static int front1 = -1;
	static int rear1 = -1;
	
	static String[] queue2 = new String[600];
	static int front2 = -1;
	static int rear2 = -1;
	
	public static void main(String[] args) {
		
		for(int t=1; t<=T; t++) {
			int cardNum = sc.nextInt();
			//queue2에 쌓일 카드의 수 (num은 버림 나눗셈이기 때문에 q2의 연산으로 들어가야한다.)
			int num = cardNum/2;
			
			//queue1에 쌓일 카드의 수
			int res = cardNum - num;
			
			 // 초기화를 테스트케이스 때마다 해주지않으면 front, rear가 계속 커짐.
		    front1 = rear1 = -1;
		    front2 = rear2 = -1;
			
			
			
			//q1에 쌓일 카드의 스택
			for(int i=0; i<res; i++) {
				String[] tmp = sc.next().split(" ");
				String word = tmp[0];
				enQueue(queue1, word);
				
			}
			
			//q2에 쌓일 카드의 수
			for(int i=0; i<num; i++) {
//				int front = front2;
//				int rear = rear2;
				//split을 해도 단어로 들어오는게 아닌 배열[]로 들어온다.
				String[] tmp = sc.next().split(" ");
				String word = tmp[0];
				enQueue(queue2, word);
				
			}
			//절반씩 각 큐에 들어감.
			//이제 한개씩 배출
			System.out.print("#"+t+" ");
			 for(int time=1; time <= cardNum; time++) {
				 if(!(time%2==0)) {
					 //time이 홀수 일때,  q1에서 dq
					String tmp =  deQueue(queue1);
					System.out.print(tmp+" ");
					 
				 }
				 else {
					 if(!(isEmpty(queue2))) {
						//time이 짝수일때, q2에서 dq
						String tmp =  deQueue(queue2);
						System.out.print(tmp+" ");
						 
					 }
				 }
			 }
			 System.out.println();
			
		}
		
	}

	
	static boolean isEmpty(String[] queue) {
		if(queue == queue1)return front1==rear1;
		else return front2==rear2;
	}
	
	static boolean isFull(String[] queue) {
		if(queue == queue1) return rear1==queue.length -1 ;
		else return rear2==queue.length -1 ;
	}
	

	//삽입
	//front와 rear를 따로 입력 받아도 메서드는 값을 복사하는 것이기 때문에 실제 front, rear에는 적용이 안된다. -> 각각 처리.
	private static void enQueue(String[] queue, String word) {
		//배열이 다 차있으면
		if(isFull(queue))return;
		
		//여기서 q1와 q2를 조건문으로 나눠야함.
		if(queue == queue1) {
//			System.out.println("q1 : "+word + "값을 삽입합니다.");
			queue[++rear1]=word;
//			System.out.println("q1: front"+front1+", rear : "+rear1+" "+Arrays.toString(queue));
			
		}
		else {
//			System.out.println("q2 : "+word + "값을 삽입합니다.");
			queue[++rear2]=word;
//			System.out.println("q2: front"+front2+", rear : "+rear2+" "+Arrays.toString(queue));
			
		}
		
	}
	
	static String deQueue(String[] queue) {
		if(isEmpty(queue)) {
			return null;
		}
		
		//여기서 q1와 q2를 조건문으로 나눠야함.
				if(queue == queue1) return queue[++front1];
				else return queue[++front2];
							
	}


}
