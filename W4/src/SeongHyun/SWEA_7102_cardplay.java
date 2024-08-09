package SWEA_7102_준홍이의카드놀이;

import java.util.LinkedList;
// import java.util.Queue;
import java.util.Scanner;

public class SWEA_7102_cardplay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();	
        
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();																// N 세팅
            int M = sc.nextInt();																// M 세팅
            
            Queue queueN = new Queue();			// N 세트에 대한 queue (LinkedList 이용)
            Queue queueM = new Queue();			// M 세트에 대한 queue (LinkedList 이용)
            
            
            for(int i = 1; i <= N; i++) {						// 각각의 queue를 통해 카드세트 배치
                queueN.add(i);
            }
            for(int i = 1; i <= M; i++) {
                queueM.add(i);
            }
            
            int[] mostFre = new int[N + M + 1];					// 가장 높은 빈도 찾기 위한 조합 배열
            
            
            for(int i = 0; i < N; i++) {						// 가능한 모든 조합 구하기
                int numN = queueN.poll();						// 각각의 queue에서 카드를 뽑아서 조합 카운트
                for(int j = 0; j < M; j++) {
                    int numM = queueM.poll();
                    int sum = numN + numM;
                    mostFre[sum]++;
                    queueM.add(numM); 							// 카드 다시 M세트에 리턴
                }
                queueN.add(numN); 								// 카드 다시 N세트에 리턴 
            }
            
      
            int cnt = 0;										// 빈도 카운트
            for (int i = 2; i <= N + M; i++) {
                if (mostFre[i] > cnt) {							// 카드 빈도가 최대 카운트(가장 높은 빈도)보다 높으면 갱신
                    cnt = mostFre[i];
                }
            }
            
            // 결과 출력
            System.out.print("#" + test_case);
            for (int i = 2; i <= N + M; i++) {
                if (mostFre[i] == cnt) {						// 카드의 빈도가 최대 카운트와 동일한거 출력
                    System.out.print(" " + i);
                }
            }
            System.out.println();
        }
        
        sc.close();
    }
}




class Queue {
    private Node front;						// Queue의 앞
    private Node rear;						// Queue의 뒤
    private int size;						// Queue의 크기
    
    private class Node {
        int data;
        Node next;							// 다음 노드
        
        public Node(int data) {
            this.data = data;				// 생성자로 데이터 생성
            this.next = null;				// 다음 노드 포인터를 초기화
        }
    }
    
    public Queue() {
        this.front = null;					// LinkedList에서는 -1이 아니라 null
        this.rear = null;					// LinkedList에서는 -1이 아니라 null
        this.size = 0;						// 초기 크기
    }
    
    public void add(int data) {				// Queue에 인덱스 추가(add)하는 메서드
        Node newNode = new Node(data);
        if (rear != null) {
            rear.next = newNode;			// rear가 null이 아니면 rear의 다음은 새 노드
        }
        rear = newNode;						// rear를 새 노드로 갱신
        if (front == null) {
            front = newNode;				// front가 null이면 front는 새 노드
        }
        size++;								// 결과적으로 Queue 사이즈 1 증가
    }
    
    
    public int poll() {						// queue.poll()에 대한 메서드(삭제 후 반환)
        if (front == null) {
            throw new RuntimeException("Queue is empty");	// 예외처리
        }
        int data = front.data;				// front의 데이터 저장
        front = front.next;					// 다음 front는 현 front
        if (front == null) {
            rear = null;					// front가 null이면 rear도 null
        }
        size--;								// 결과적으로 사이즈 감소
        return data;						// 삭제한 데이터를 반환
    }
    
    
    public boolean isEmpty() {			// 비어있는지 확인하는 메서드
        return size == 0;
    }
    
    
    public int size() {					// 현재의 크기 반환하는 메서드
        return size;
    }
    
   
    public int peek() {					// 맨앞에 있는 인덱스를 제거하지 않고 반환
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }
}