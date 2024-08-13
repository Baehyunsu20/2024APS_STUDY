package Hyunsu;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

/**
 * 중간에 계속 들어가서 인덱스가 바뀌어야하는 문제가 발생
 * 단방향 연결 리스트를 사용하는 방법.
 * N개의 링크드 리스트를 만들어두고
 * 
 * LinkedList<Integer> llist = new LinkedList<>();

llist.add(100); //맨 뒤에 값 추가
llist.add(300); //맨 뒤에 값 추가
llist.add(1,200); //1번 인덱스에 200이라는 값 추가
llist.addFirst(0); //맨앞에 0이라는 값 추가
llist.addLast(400); //맨 뒤에 400이라는 값 추가

 * 
 */

public class S1228_암호문1 {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		//static으로 만들 경우에는 throws 자동 완성이 뜨지 않음.
		//throws FileNotFoundException  -> 얘는 함수에 붙이는 것임. 클래스가 아니라!
		Scanner sc = new Scanner(new File("input_암호문1.txt"));
		
		//N개의 암호문을 담을 숫자 연결리스트
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int t =1; t<=10; t++) {
			
			int n = sc.nextInt();
			//케이스별 리스트 초기화
			list = new LinkedList<Integer>();
			for(int i=0; i<n; i++) {
//				int k = sc.nextInt();
//				System.out.println(k);
				list.add(sc.nextInt());
			}
			//연결리스트는 그냥 출력 가능
//			System.out.println(list);
			
			//몇번의 삽입이 있는가? = time 번의 삽입이 존재.
			int time = sc.nextInt();
			//총 7번의 삽입 연산이 존재 :  time번의 I 존재
			for(int k=0; k<time; k++) { 
				//I를 버림
				sc.next();
				
				//몇번째 자리에 넣을 것인지
				int idx = sc.nextInt();
				
				int howmany = sc.nextInt();
				int[] tmp = new int[howmany];
				//howmany만큼의 수를 차곡차곡 추가해줌. 그리고 idx를 올림.
				for(int i=0; i<howmany; i++) {
					//삽일할 암호문의 리스트
					list.add(idx++,sc.nextInt());
				}
				
			}
			System.out.print("#"+t);
			for(int l=0; l<10; l++) {
				System.out.print(" "+list.get(l));
			}
			System.out.println();

		}

	}

}
