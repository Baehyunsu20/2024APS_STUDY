package SWEA_1225_암호생성기;

import java.util.Scanner;

public class Solution {
    static int[] queue = new int[8];
    static int front = 0;
    static int rear = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int T = sc.nextInt();
            // 큐 초기화
            front = 0;
            rear = 8;

            for (int i = 0; i < 8; i++) {
                int item = sc.nextInt();
                enQueue(item);
            }
            
           
            while (true) {
                int rItem = deQueue();  
                rItem -= 1;  
                if(rItem==0) {
                	enQueue(rItem);
                	break;
                } else {
                enQueue(rItem);  
            }
            }
            
            System.out.print("#" + T + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(deQueue() + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    // 포화 상태 확인
    static boolean isFull() {
        return (rear + 1) % queue.length == front;
    }

    // 삽입
    static void enQueue(int item) {
        if (isFull()) {
            return;
        }
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
    }

    // 삭제
    static int deQueue() {
        int item = queue[front];
        front = (front + 1) % queue.length;
        return item;
    }

}
