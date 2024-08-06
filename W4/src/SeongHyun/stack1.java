package SWEA_1222_계산기1;

public class stack {

		private int top;
		private int[] stack;
		
		public stack(int size) {
			this.stack = new int [size];
			this.top = -1;
		}
		
		public void push(int value) {
			if(top >= stack.length -1 ) {
				return;
			}
			stack[++top] = value;
		}

		public int pop() {
			if (isEmpty()) {
				return 0;
			}
			int value = stack[top--];
			return value;
		}
		
		public Boolean isEmpty() {
			return top == -1;	
		}
	
	}
