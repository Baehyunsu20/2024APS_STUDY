import java.util.Scanner;

	public class SWEA_8931_zero
	{
		
		public static void main(String args[]) throws Exception
		{
	
			Scanner sc = new Scanner(System.in);
			int T;
			T=sc.nextInt();
	
			for(int test_case = 1; test_case <= T; test_case++)
			{
	            int K = sc.nextInt();
	            Stack stack = new Stack(K);
	            int sum = 0;
	            for (int i = 0; i < K; i++) {
	                int N = sc.nextInt();
	                stack.push(N);
	                if( N == 0 ) {
	                    stack.pop();
	                    stack.pop();
	                }
	            }
	            
	            while (!stack.isEmpty()) {
	                sum += stack.pop();
	            }
	         System.out.println("#" + test_case + " " + sum); 
	
			}
			sc.close();
		}
	}
	
	class Stack {
		private int max;
		private int top;
		private int[] stack;
		
		public Stack(int size) {
			this.max = size;
			this.stack = new int[max];
			this.top = -1;
		}
		
		public void push(int value) {
			if ( top >= max - 1) {
				return;
			}
			stack[++top] = value;
		}
		
		public int pop() {
			if (isEmpty()) {
				return -1;
			}
			int value = stack[top--];
			return value;
		}
		
		public boolean isEmpty() {
			return (top == -1);
		}
		
	}
