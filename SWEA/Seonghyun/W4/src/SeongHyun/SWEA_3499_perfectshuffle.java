package SWEA_3499_퍼펙트셔플;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SWEA_3499_perfectshuffle
{
	public static void main(String args[]) throws Exception
	{
		Queue<String> queue1 = new LinkedList<>();
		Queue<String> queue2 = new LinkedList<>();
		// Queue queue1 = new Queue();
		// Queue queue2 = new Queue();
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
		int N = sc.nextInt();
	for(int i = 0; i < N; i++) {
		if ( i < (N+1)/2) {
			String card = sc.next();
			queue1.offer(card);
		} else {
			String card = sc.next();
			queue2.offer(card);
		}
	}	
        System.out.print("#" + test_case + " ");
	for(int i = 0; i < N/2; i++) {
        System.out.print(queue1.poll() + " ");
		System.out.print(queue2.poll() + " ");
        if (queue1.peek() != null) {
            if (queue2.peek() == null ) {
                System.out.print(queue1.poll());
            } else {
                continue;
            }
        } 
            System.out.println(" ");
		}
	}
}
}

// class Queue {
//     private Node front;						// Queue의 앞
//     private Node rear;						// Queue의 뒤
//     private int size;						// Queue의 크기
    
//     private class Node {
//         int data;
//         Node next;							// 다음 노드
        
//         public Node(int data) {
//             this.data = data;				// 생성자로 데이터 생성
//             this.next = null;				// 다음 노드 포인터를 초기화
//         }
//     }
    
//     public Queue() {
//         this.front = null;					// LinkedList에서는 -1이 아니라 null
//         this.rear = null;					// LinkedList에서는 -1이 아니라 null
//         this.size = 0;						// 초기 크기
//     }
    
//     public void add(int data) {				// Queue에 인덱스 추가(add)하는 메서드
//         Node newNode = new Node(data);
//         if (rear != null) {
//             rear.next = newNode;			// rear가 null이 아니면 rear의 다음은 새 노드
//         }
//         rear = newNode;						// rear를 새 노드로 갱신
//         if (front == null) {
//             front = newNode;				// front가 null이면 front는 새 노드
//         }
//         size++;								// 결과적으로 Queue 사이즈 1 증가
//     }
    
    
//     public int poll() {						// queue.poll()에 대한 메서드(삭제 후 반환)
//         if (front == null) {
//             throw new RuntimeException("Queue is empty");	// 예외처리
//         }
//         int data = front.data;				// front의 데이터 저장
//         front = front.next;					// 다음 front는 현 front
//         if (front == null) {
//             rear = null;					// front가 null이면 rear도 null
//         }
//         size--;								// 결과적으로 사이즈 감소
//         return data;						// 삭제한 데이터를 반환
//     }
    
    
//     public boolean isEmpty() {			// 비어있는지 확인하는 메서드
//         return size == 0;
//     }
    
    
//     public int size() {					// 현재의 크기 반환하는 메서드
//         return size;
//     }
    
   
//     public int peek() {					// 맨앞에 있는 인덱스를 제거하지 않고 반환
//         if (front == null) {
//             throw new RuntimeException("Queue is empty");
//         }
//         return front.data;
//     }
// }