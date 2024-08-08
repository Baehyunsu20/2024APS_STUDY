package Minseo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225암호생성기 {
	
	static boolean isAnswer=false;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
		
		int T = sc.nextInt();
			
		// 초기화
		isAnswer=false;
		q.clear();
		
		// 큐 입력받기
		for(int n=0;n<8;n++) {
			q.add(sc.nextInt());
		}
		
		// 사이클 돌리기
		while(!isAnswer) {
			cycle(q);
		}
				
		System.out.print("#"+t);
        for(int num : q){
        System.out.print(" "+num);
		}	
		System.out.println();
        }
	}
	
	static void cycle(Queue<Integer> q) {
		for(int i=1;i<=5;i++) {
			if(q.peek()-i>0) {
				q.add(q.peek()-i);
				q.remove();					
			}
			else if(q.peek()-i<=0) {
				q.add(0);
				q.remove();
				isAnswer=true;				
				return;
				}
			}
		return;
	}

}