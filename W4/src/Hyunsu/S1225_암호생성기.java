package Hyunsu;
import java.util.*;

public class S1225_암호생성기 {
	static Scanner sc = new Scanner(System.in);
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		
		for(int t=1; t<=10; t++) {
			int time = sc.nextInt();
			int cnt =1;
			for(int n=0;n<8;n++) {
				//8개의 숫자로 일단 채워둠
				queue.add(sc.nextInt());
			}
			while(true) {
				int k = cnt % 5; 
				if(k==0)k=5;
//				System.out.println("peek : "+ queue.peek()+" k : "+k);

				int newNum = queue.poll() - k;
//				System.out.println("k를 뺀 수, rear로 넣어줄 값 : "+newNum);
				if(newNum <= 0) newNum=0;
				queue.add(newNum);
//				System.out.println("다음에 빠질 맨 앞자리 수(peek) : "+queue.peek());
				cnt++;
//				System.out.println(queue);
				 if(newNum ==0)break;
			}
			
			System.out.print("#"+t);
			while(!(queue.isEmpty())) {
				System.out.print(" "+queue.poll());
			}
			System.out.println();
			
		}
		
	}

}
