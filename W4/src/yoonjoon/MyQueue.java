package Queue1;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
	
	private List<Integer> line = new ArrayList<>();
	private int front = -1,  rear = -1;
	//front, rear 양끝 둘다 시작점은 -1

	// enQueue로 Queue에 입력값 주기
	public void enQueue(int a) {
		line.add(a);
		rear++;
	}// front부터 값을 불러와서 i에 저장 한 후 제거 (굳이 제거를 안해도 호출되지않아서 제거하지 않아도 괜찮음)
	public int deQueue() {
		if(!isEmpty()) {
		int i = line.get(front);
		line.remove(i);
		front++;
		return i;
		}
		return 0;
	}// rear값 불러와서 표시해 주기
	public int Qpeek() {
		if(!isEmpty()) {
		int i = line.get(rear);
		return i;
		}
		return 0;
	} //front와 rear의 값이 같아지는 순간 Queue에는 값이 없음
	public boolean isEmpty() {
		return (front == rear);
	}
}
			


		