package B2178;

import java.util.*;

/**
 * 미로 탐색 : Bfs 문제
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸
 *(0, 0)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수 -> 배열의 크기 구하기.
 * distance를 3번째 요소로 따로 저장해줌
 * 
 * bfs가 최단거리를 배출할 수 있는 이유 : return에 제일 처음 접근한 경로가 최단 경로이다.
 */

public class Main {
	private static int n, m, min;
	private static Scanner sc;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
//		min=Integer.MAX_VALUE;
		
		min = bfs();
		System.out.println(min);

	}
	
	//항상 시작점은 (1,1) -> 인덱스로는 (0, 0)이겠지?
	private static int bfs() {
		//테이블을 입력받음
		int[][] table = new int[n][m];
		for(int i=0; i<n; i++) {
			String line = sc.next();
			for(int j=0; j<m; j++) {
				if(line.charAt(j) == '1') {
					table[i][j] = 1;
				}
				else {
					table[i][j] = 0;
				}
			}
		}//테이블 입력 완료
		

		//종료점 (n, m)
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		List<int[]> path = new ArrayList<>();
		
		queue.add(new int[] {0, 0, 1}); //시작점을 일단 넣어둠, 초기 거리 = 1
		
		while(!queue.isEmpty()){
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			int distance = tmp[2];
			visited[x][y] = true;
			
			
			if(x == n-1 && y==m-1) {
				//여기까지의 길이 paths의 길이를 찾음
//				System.out.println(path);
				//**가장 먼저 기저조건에 도달한 조건이 최단거리이기에 최소값 갱신은 필요없다.
				return distance;
			}
			
			//사방 탐색
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				//1인 경우와 방문하지않은 곳만
				if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && table[nx][ny]==1) {
					queue.add(new int[] {nx, ny, distance+1});
					visited[nx][ny] = true;
//					path.add(new int[] {nx, ny}); 
					//-> 해당 방식은 큐에 추가된 모든 노드(탐색된 모든 노드) -> 최단 경로가 아님.
				}
			}
			
		}
		
		return -1; //항상 도착 위치로 이동할 수 있음 -> 그냥 달아둠.

	}

	static String input = "4 6\r\n"
			+ "101111\r\n"
			+ "101010\r\n"
			+ "101011\r\n"
			+ "111011";

}
