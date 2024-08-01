package Bosung;

import java.util.Scanner;

public class S1220_Magnetic {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 10개의 테스트 케이스 각각의 교착 상태의 개수를 저장할 count 배열 만들기
		int[] count = new int[10];
		
		for (int t=0; t<10; t++) {
			
			// 첫 입력은 100으로 고정
			int hundred = sc.nextInt();
			
			// 100*100 크기의 테이블을 저장할 2차원 배열 table 만들기
			int[][] table = new int[100][100];
			
			// 100*100개의 값을 table에 저장
			for (int i=0; i<100; i++) {
				for (int j=0; j<100; j++) {
					table [i][j] = sc.nextInt();
				}
			}
			
			// 교착 상태 개수 찾기
			// 첫 행, 첫 열부터 N극을 찾고 아래방향으로 쭉 탐색했을 때 N극이 나오면 패스, S극이 나오면 count에 1 더하기
			// (N극의 아래방향에 S극이 있고 사이에 아무것도 없으면 자기장을 걸었을 때 두 자성체는 교착상태가 됨)
			// 첫 for문에서 i가 100이면 d=1을 더했을 때 오류가 날줄 알고 99로 써서 통과했는데 100해도 됐을 듯..?
			for (int i=0; i<99; i++) {
				for (int j=0; j<100; j++) {
					// 테이블 인덱스 값이 1이면 (=N극이면)
					if (table[i][j] == 1) {
						// 밑으로 쭉 탐색 했을 때
						for (int d=1; i+d<100; d++) {
							// N극이 또 있으면 다음 인덱스로!
							if (table[i+d][j] == 1) {
								break;
							}
							// S극을 발견하면 count에 1 더하기!
							else if (table[i+d][j] == 2) {
								count[t] += 1;
								break;
							}
						}
					}
				}
			}
		}
		// 문제에서 요구하는 대로 테스트 케이스 번호, 모든 교착 상태 개수 출력
		for (int i=0; i<10; i++) {
			System.out.println("#"+ (i+1) + " " + count[i]);
		}
	}
}