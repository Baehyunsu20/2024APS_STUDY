package Hyunsu;
import java.util.*;
/**
 * 
 */

public class S8931_zero {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int len = sc.nextInt();
			int[] list = new int[len];
			Stack<Integer> stack_list = new Stack<>();
			
			//배열에 순서대로 숫자 넣기
			//stack으로 문제 풀기 : LIFO(Last input First ouput)
			//0이 나오면 pop으로 데이터 삭제하기
			
			for(int i=0; i<len; i++) {
				int tmp = sc.nextInt();
				if(tmp==0) {
					//이전 값을 뱉어냄
					stack_list.pop();
				}
				else {
					stack_list.push(tmp);
				}
			}//이제 남아있는 수의 합을 구하기
			int size = stack_list.size();
			double sum = 0;
			for(int i=0; i<size;i++) {
				sum += stack_list.pop();
			}
			System.out.println("#"+t+" "+(int)sum);
			
			
		}
		
	}

}
