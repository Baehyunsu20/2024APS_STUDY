package Stack2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack {
	
	private List<Character> up = new ArrayList<Character>();
	private int top = -1;
	
	public void push(char a) {
		up.add(a);
		top++;
		
	}
	public char pop() {
		if(!isEmpty()) {
			char i = up.get(top);
			up.remove(top);
			top--;
			return i;
		}
		return 0;
	}
	public char peek() {
		if(!isEmpty()) {
			char i = up.get(top);
			return i;
		}	
		return 0;
	}
	public boolean isEmpty() {
		boolean result;
		if(top == -1)
			result = true;
		else
			result = false;
		return result;
		
//		return (top == -1);
	}
}