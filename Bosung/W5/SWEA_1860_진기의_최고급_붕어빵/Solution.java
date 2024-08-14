package SWEA_1860_진기의_최고급_붕어빵;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 손님 수 N, 만드는 데 걸리는 시간 M, 한 번에 만드는 붕어빵의 개수 K 입력 받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			// 손님이 오는 시간을 입력 받을 time 배열 생성
			int[] time = new int[N];
			
			// N명의 손님이 오는 시간 저장
			for (int i = 0; i < N; i++) {
				time[i] = sc.nextInt();
			}
			
			// 손님이 오는 마지막 시간 저장하기 위해 timeMax 생성
			int timeMax = 0;
			
			// 손님이 오는 마지막 시간 저장
			for (int i = 0; i < N; i++) {
				if (time[i] > timeMax) {
					timeMax = time[i];
				}
			}
			
			// 붕어빵 수를 세기 위한 count 생성
			int count = 0;
			
			// 붕어빵을 모두 팔 수 있는지 확인하기 위해 boolean형 변수 sell 생성
			boolean sell = true;
			
			// 각 초마다 붕어빵이 완성될 시간이면 count에 K개 추가
			// 손님이 도착할 시간이면 count에서 1 빼기
			// 마지막 손님이 올 시간까지 수행하며 count가 음수가 되면 sell을 false로 바꾸고 break
			for (int sec = 0; sec <= timeMax; sec++) {
				if (sec % M == 0 && sec != 0) {
					count += K;
				}
				for (int i = 0; i < N; i++) {
					if (sec == time[i]) {
						count--;
					}
				}
				if (count < 0) {
					sell = false;
					break;
				}
			}
			
			// 테스트 케이스 번호를 출력하고 sell이 true로 남아있으면 Possible, false면 Impossible 출력
			System.out.print("#" + t + " ");
			if (sell) {
				System.out.println("Possible");
			}
			else {
				System.out.println("Impossible");
			}
		}
	}
}
