package B4963;

import java.util.*;

/**
 * 섬의 갯수 찾기 : 1은 땅, 0은 바다이다.
 * 입력의 마지막 줄에는 0이 두 개 주어진다.
 */

public class Main {
	//사방탐색을 위해 static으로 설정 
	//대각선도 포함
	private static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	private static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
	
	private static int[][] table;
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		//임의의 N개 처리 -> while(입력이 존재하는 동안 = hasNext() _ boolean으로 판단)
		while(sc.hasNext()) {
			int width = sc.nextInt();
			int height = sc.nextInt();
			if(width ==0 && height ==0) {
				break;
			}
			table = new int[height][width]; //3, 2 -> 2줄. 3열
			
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {table[i][j] = sc.nextInt();}} //입력 완료.
			
//			System.out.println(Arrays.deepToString(table));
//			System.out.println("----");
			
			int cnt  = bfs(height, width);
			System.out.println(cnt);
			
		}
		
	}
	
	private static int bfs(int height, int width) {
		int cnt = 0; //일단 0으로 해두고 계속 더해줌.
//		Queue<int[]> queue = new LinkedList<>();
		// 땅 = 1 / 바다 = 0 
		boolean[][] visited = new boolean[height][width]; //전부 false로 채워져 있고,
		//나는 땅(1인 경우에만 이동을 하고 방문 처리로 false로 만들 것)
		for(int i=0;i<height; i++) {
			for(int j=0; j<width; j++) {
				if(table[i][j] == 1) {
					visited[i][j] = true;
				}
			}
		}// 땅인 경우는 true로 표지. -> 땅인 경우는 true / 바다는 false.
		
		//table,  visited 에서 땅을 찾고, 그것을 기준으로 확장하며 방문을 확인했으면 false로 바ㅣ꿈
		for(int i=0;i<height; i++) {
			for(int j=0; j<width; j++) {
				if(visited[i][j]) {
					//해당(i, j)가 true면 땅이므로 -> 이점을 시작점으로 queue가 빌때까지
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] {i, j}); //해당 시작 점을 큐에 넣어줌
					
					//시작점이 포함된 땅 덩어리를 false로 바꿔줌
					while(!queue.isEmpty()) {
						int[] tmp = queue.poll();
						int x = tmp[0];
						int y = tmp[1];
						visited[x][y] = false; //담아줬으면 false로 바꾸기.
						
						//사방 탐색
						for(int k=0; k<8; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							//true(땅일 경우)
							if(nx>=0 && nx<height && ny>=0 && ny<width && visited[nx][ny]) {
								queue.add(new int[] {nx, ny});
								visited[nx][ny] = false;
							}
						}
					}
					//땅 덩어리 하나가 끝났으면
					cnt++;
				}
			}
		}

		return cnt;
	}

	static String input = "1 1\r\n"
			+ "0\r\n"
			+ "2 2\r\n"
			+ "0 1\r\n"
			+ "1 0\r\n"
			+ "3 2\r\n"
			+ "1 1 1\r\n"
			+ "1 1 1\r\n"
			+ "5 4\r\n"
			+ "1 0 1 0 0\r\n"
			+ "1 0 0 0 0\r\n"
			+ "1 0 1 0 1\r\n"
			+ "1 0 0 1 0\r\n"
			+ "5 4\r\n"
			+ "1 1 1 0 1\r\n"
			+ "1 0 1 0 1\r\n"
			+ "1 0 1 0 1\r\n"
			+ "1 0 1 1 1\r\n"
			+ "5 5\r\n"
			+ "1 0 1 0 1\r\n"
			+ "0 0 0 0 0\r\n"
			+ "1 0 1 0 1\r\n"
			+ "0 0 0 0 0\r\n"
			+ "1 0 1 0 1\r\n"
			+ "0 0";

}
