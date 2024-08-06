package SWEA_1224_계산기3;

public class stack<T> {

		private int top;
		private T[] stack;
		
		public stack(int size) {
			this.stack = (T[]) new Object[size];
			this.top = -1;
		}
		
		public void push(T value) {
			if(top >= stack.length - 1) {
				return;
			}
			stack[++top] = value;
		}

		public T pop() {
			if (isEmpty()) {
				return null;
			}
			return stack[top--];
		}
		
		public Boolean isEmpty() {
			return ( top == -1);
		}
		
		public T peek() {
			if (isEmpty()) {
				return null;
			}
			return stack[top];

		}
		
//		public int size() {
//			for()
//			return size;
//		}
//		
//		public void clear() {
//			for (int i = 0; i < size(); i++)
//				stack.pop();
//		}
	}
