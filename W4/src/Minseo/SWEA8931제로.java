package Minseo;

import java.util.*;

public class SWEA8931제로{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			Stack<Integer> stack = new Stack<>();
			int N = sc.nextInt();
			for(int n=0;n<N;n++) {
				int s = sc.nextInt();
				if(s==0) {
					stack.pop();
				} else {
					stack.push(s);					
				}
			}
			
//			System.out.println(stack);
					
			int sum=0;
			for(int num : stack) {
				sum+=num;
			}
			
			System.out.println("#"+t+" "+sum);
		}
		
		sc.close();
	}

}
