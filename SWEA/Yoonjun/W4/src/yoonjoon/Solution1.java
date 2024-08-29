package SWEA_5432_쇠막대기자르기;

import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			Stack mac = new Stack();
			
			String A = sc.next();
			
			int count = 0;
			
			for( int i = 0; i < A.length(); i++) {
				
				char B = A.charAt(i);
				
					
				if(B == '(') {
					mac.push(B);
				}else {
					mac.pop();
				if(A.charAt(i-1) == '(') {
					count = count + mac.size();
				} else {
				count++;
			}		
		}
		
	}
			System.out.println("#"+t+" "+count);
}
	}
}