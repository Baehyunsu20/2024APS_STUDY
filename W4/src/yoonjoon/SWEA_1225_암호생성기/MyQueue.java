package SWEA_1225_암호생성기;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
	
	private List<Integer> line = new ArrayList<>();
	private int front = -1,  rear = -1;


	public void enQueue(int a) {
		line.add(a);
		rear++;
	}
	public int deQueue() {
		if(!isEmpty()) {
			front++;
			int i = line.get(front);
//			line.remove(front);
			return i;
		}
		return 0;
	}
	public int Qpeek() {
		if(!isEmpty()) {
		int i = line.get(rear);
		return i;
		}
		return 0;
	}
	public boolean isEmpty() {
		return (front == rear);
	}
}
			


		