package SWEA_8931_제로;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			
			Stack pipe = new Stack();
			for(int i = 0; i < N; i++) {
				int num = sc.nextInt();
				if(num == 0)
					pipe.pop();
				else
					pipe.push(num);
			}
			int sum = 0;
			while(!pipe.isEmpty()) {
				sum += pipe.pop();
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}

class Stack {
	private List<Integer> pipe = new ArrayList<Integer>(); 
	private int top = -1;

	public void push(int a) {
		pipe.add(a);
		top++;
	}
	public int pop() {
		if(!isEmpty()) {
			int i = pipe.get(top);
			pipe.remove(top);
			top--;
			return i;
		}
		return Integer.MIN_VALUE;
	}
	
	public int peek() {
		return pipe.get(top);
	}
	public boolean isEmpty() {
		return (top == -1);
	}
}