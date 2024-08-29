package Bosung;

import java.util.Scanner;

public class J1733_오목 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] table = new int[19][19];
		
		for (int i=0; i<19; i++) {
			for (int j=0; j<19; j++) {
				table[i][j] = sc.nextInt();
			}
		}
		
		// 8방향으로 dx, dy 설정
		int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
		int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
		
//		boolean find = false;
		
		// 첫째 줄 출력을 위해 winner 만들기
		int winner = 0;
		
		// 조건을 만족하는 오목을 찾았을 때 인덱스를 저장하기 위해 크기 2의 1차원 배열 foundI, foundJ 만들기 (만들어진 오목의 첫 부분, 마지막 부분 두 곳만 조건을 만족하므로 크기 2로 설정)
		int[] foundI = {-1, -1};
		int[] foundJ = {-1, -1};
		
		// 조건을 만족하는 오목 찾기
		for (int i=0; i<19; i++) 
			for (int j=0; j<19; j++) {
				// 검은색이 승리할 경우
				if (table[i][j] == 1) {
					// 8방향으로 돌려서 이어지는 흑돌 있는지 찾기
					for (int k=0; k<8; k++) {
						int count = 0;					// 이어지는 흑돌만큼 count가 증가하여 4가 되면 오목 후보 (왜 후보인지 뒤에 설명)
						int movedI = i + dx[k];
						int movedJ = j + dy[k];
						// 흑돌이 이어지는만큼 count를 증가시켰을 때 count가 5가 되면 6목이므로 6목 거르기 위해 5번 증가시켜보기 (6목 거르기 1번)
						for (int l=0; l<5; l++) {
							if (movedI<0 || movedI==19 || movedJ<0 || movedJ==19)	// 이어지는 흑돌을 찾을 때 바둑판 밖으로 나가면 더이상 count 증가시키지 않고 for문 나가기
								break;
							if (table[movedI][movedJ] == 1) {						// 이어지는 돌이 흑돌이면 count 1증가 후 인덱스 옮겨서 다시 탐색
								count += 1;
								movedI += dx[k];
								movedJ += dy[k];
							}
						}
						// 6목에서 두번째 돌을 탐색할 때도 count가 4가 될 수 있기 때문에 해당 돌의 탐색 반대 방향에 같은 돌이 있는지 확인하여 없을 경우 오목 확정! (6목 거르기 2번)
						if (count == 4) {
//							System.out.println(1);
//							System.out.println((i+1) + " " + (j+1));
//							find = true;
							int backmovedI = i +dx[(k+4)%8];
							int backmovedJ = j +dy[(k+4)%8];
							// 해당 돌이 바둑판의 가장자리에 위치하여 반대 방향을 탐색할 수 없는 경우 => 오목 확정
							if (backmovedI<0 || backmovedI==19 || backmovedJ<0 || backmovedJ==19) {
								winner = 1;						// 승자는 흑돌
								if (foundI[0] == -1) {			// 처음 찾은 오목의 돌 저장
									foundI[0] = i;
									foundJ[0] = j;
								}
								else {
									foundI[1] = i;				// 두번째 찾은 오목 돌 저장
									foundJ[1] = j;
								}
							}
							// 반대 방향을 탐색했을 때 흑돌이 아닌 경우 => 오목 확정
							else if (table[backmovedI][backmovedJ] != 1) {
								winner = 1;
								if (foundI[0] == -1) {
									foundI[0] = i;
									foundJ[0] = j;
								}
								else {
									foundI[1] = i;
									foundJ[1] = j;
								}
							}
							
						}
					}
				}
				// 흰색이 승리할 경우
				else if (table[i][j] == 2) {
					for (int k=0; k<8; k++) {
						int count = 0;
						int movedI = i + dx[k];
						int movedJ = j + dy[k];
						for (int l=0; l<5; l++) {
							if (movedI<0 || movedI==19 || movedJ<0 || movedJ==19)
								break;
							if (table[movedI][movedJ] == 2) {
								count += 1;
								movedI += dx[k];
								movedJ += dy[k];
							}
						}
						if (count == 4) {
//							System.out.println(2);
//							System.out.println((i+1) + " " + (j+1));
//							find = true;
							int backmovedI = i +dx[(k+4)%8];
							int backmovedJ = j +dy[(k+4)%8];
							if (backmovedI<0 || backmovedI==19 || backmovedJ<0 || backmovedJ==19) {
								winner = 2;
								if (foundI[0] == -1) {
									foundI[0] = i;
									foundJ[0] = j;
								}
								else {
									foundI[1] = i;
									foundJ[1] = j;
								}
							}
							else if (table[backmovedI][backmovedJ] != 2) {
								winner = 2;
								if (foundI[0] == -1) {
									foundI[0] = i;
									foundJ[0] = j;
								}
								else {
									foundI[1] = i;
									foundJ[1] = j;
								}
							}
							
						}
					}
				}
//			if (find == true)
//				break;
			}
		
		// 검은색이 승리한 경우
		if (winner == 1) {
			// 조건을 만족하는 두 개의 돌 중 문제에서 요구하는 돌의 위치 출력하기 (완성된 오목이 가로나 대각선일 경우 왼쪽 돌, 세로일 경우 먼저 찾은 돌 => foundJ만 비교하면 됨)
			if (foundJ[0]<=foundJ[1]) {
				System.out.println(1);
				System.out.println((foundI[0]+1) + " " + (foundJ[0]+1));
			}
			else {
				System.out.println(1);
				System.out.println((foundI[1]+1) + " " + (foundJ[1]+1));
			}
		}
		// 흰색이 승리한 경우
		else if (winner == 2) {
			if (foundJ[0]<=foundJ[1]) {
				System.out.println(2);
				System.out.println((foundI[0]+1) + " " + (foundJ[0]+1));
			}
			else {
				System.out.println(2);
				System.out.println((foundI[1]+1) + " " + (foundJ[1]+1));
			}
		}
		// 승부가 결정되지 않은 경우 (winner가 1이나 2가 아님)
		else {
			System.out.println(0);
		}
		
//		if (find == false)
//			System.out.println(0);
	}
}

// 시도 1. 왼쪽 아래에서 오른쪽 위로 가는 오목이 생기면 왼쪽아래가 아닌 오른쪽 위를 출력해서 실패 => boolean값 find 관련을 모두 주석 처리하고 foundI와 foundJ 배열을 만들어 마지막에 j를 비교하여 낮은 쪽으로 출력
// 시도 2. 6목을 고려하는 방법에서 6목 중 양 옆 두 번째에 위치한 인덱스도 오목으로 출력해버림 => backmovedI와 backmovedJ를 만들어 뒤쪽도 같은 돌이면 출력되지 않도록 함
// 시도 3. 0,0이나 18,18에서 foundI, foundJ를 구할 때 table[backmovedI][backmovedJ]의 값이 없어 값을 못 저장함 (-1,-1로 그대로 나옴) => continue문을 넣어 이 경우를 스킵함		(근데 왜 table[-1][-1]이나 table[19][19]에서 런타임 오류가 나지 않았을까?)
// 시도 4. 값을 저장하기 위해 넣은 continue문이 정답도 스킵해버림 => foundI와 foundJ를 continue문 전에 넣어 따로 값을 저장하도록 함 => 성공! => if문 안에 continue, 다시 if문을 쓰는 것을 if ~ else if문으로 바꿔서 다시 성공!
// 여담: 테스트 케이스 몇개를 통과했던 게 아쉬워서 원래 만들었던 코드를 버리지 못하고 계속 수정, 추가하다 보니 코드가 더러워진 느낌...
