package Hyunsu;

import java.util.*;
import java.io.*;

/**
 * 0부터 10만 전까지의 수로 표현되는 암호문 N가 있다
 */

public class S1230_암호문3 {
	public static void main(String[] args) throws FileNotFoundException {
		//java.io를 꼭 임포트 해와야한다.
		Scanner sc = new Scanner(new File("input_암호문3.txt"));
		
		for(int t=1; t<=10; t++) {
			int n = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			for(int i=0; i<n; i++) {
				//리스트의 맨뒤에 값을 추가 --> 원본 암호문 뭉치를 연결리스트에 저장.
				list.add(sc.nextInt());
			}
			
			//command = 총 몇개의 명령문이 있는가.
			int command = sc.nextInt();
			String mode;
			//연산의 위치
			int idx = 0;
			int many;
			
			for(int c=0; c<command; c++) {
				//명령문 한 turn.
				//삽입, 추가, 삭제 읽어오기
				mode = sc.next();
//				System.out.println(mode);
				switch (mode) {
				case "I": {
					//중간에 삽입하는 연산
					idx = sc.nextInt();
					many = sc.nextInt();
					//몇개인지 many로 파악하고 그만큼의 반복으로 숫자를 차례로 입력.
					for(int m=0; m<many; m++) {
						list.add(idx++, sc.nextInt());
					}
					break;
				}
				case "D": {
					//삭제를 진행하는 연산
					idx = sc.nextInt();
					many = sc.nextInt();
					for(int m=0; m<many; m++) {
						list.remove(idx);
					}
					break;
				}
				case "A": {
					//맨뒤에 추가하는 연산
					many = sc.nextInt();
					for(int m=0; m<many; m++) {
						list.add(sc.nextInt());
					}
					break;
				}

			}
		}
			
			System.out.print("#"+t);
			for(int num=0; num<10; num++) {
				System.out.print(" "+list.get(num));
			}
			System.out.println();
		
	}

}
}
