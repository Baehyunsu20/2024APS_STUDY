package Hyewon;

import java.util.Scanner;

public class RC카 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int cnt =0;
		
		for(int i=0; i<T; i++) {
			int n = sc.nextInt();
			int distance=0;
			int first = 0; // first는 현재 속도
		
		// commands 수(초 수) 만큼 반복	
			for(int j=0; j<n;j++) {
			// 속도 type 받아오기 // 0: 유지 / 1:감속 /2: 감속
				int type = sc.nextInt(); 
			// 속도 받아오기 (문제의 input 값 중 type이 0인 경우는 speed 개별 지정 필요함)
				int speed;
				if(type==0) {
					speed=0; // if 속도 유지면 0을 할당 받아서 first(현재속도)와 동일하도록
				}
				else speed = sc.nextInt();
			
				// 속도 type 별 거리 지정해주기	
				if (type==0) {
					// 현재속도유지 which means first 에 변화줄 필요 없음
				}
				else if (type ==1){
					first+=speed;
				}
				else if (type==2) {
				first-=speed;
				if(first<0) { // 문제 조건에 감속해야할 속도가 현재속도 first보다 더 크다면 속도를 0으로 하라는 조건
					first=0;
					}
				}
				
				distance += first; // 각각의 command 별 거리값을 누적해서 더해주고
			}	
				cnt++;
				System.out.println("#" + cnt + " " + distance);
		
			
			}
		
		sc.close();
			}
		
}

			
		

	

