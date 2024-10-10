import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178 {
	
	static int N, M;
    static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();                       // 미로의 높이
        M = sc.nextInt();                       // 미로의 너비
		map = new int[N][M];                    // 미로 배열 초기화

		for(int i = 0; i < N; i++) {
            String lstr = sc.next();
			for(int j = 0; j < M; j++) {
				map[i][j] = lstr.charAt(j) - '0';    // 한줄 입력을 나눠버리면서 미로 입력
			}
		}
		
		visited = new boolean[N][M];            // 방문 배열도 초기화
		visited[0][0] = true;                   // 스타팅은 방문
		bfs(0, 0);                          // bfs 드개재
		System.out.println(map[N-1][M-1]);      // 도착점의 새 배열 출력
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y,x});                 // 큐에 배열 정보 넣어버림
		
		while(!q.isEmpty()) {                   // 큐가 빌 때까지 돌려
			int pick[] = q.poll();               // 뽑아보자
			int nr = pick[0];                    // 미로의 세로 정보
			int nc = pick[1];                    // 미로의 가로 정보
			
			for(int i=0; i<4; i++) {
				int ny = nr + dy[i];            // 델타탐색
				int nx = nc + dx[i];            // 델타탐색
                
                if (nx < 0 || ny < 0 || ny >= N || nx >= M) continue;   // 배열 밖이면 무시
                if (visited[ny][nx] || map[ny][nx] == 0) continue;      // 방문 했거나 길이 아니면 무시
                
                q.add(new int[] {ny, nx});      // 조건에 맞으면 큐에 넣어버림
                map[ny][nx] = map[nr][nc] + 1;  // 그리고 새로운 방향은 이전 위치에 1누적하자. (교차로여도 다 같은 값이다)
                visited[ny][nx] = true;         // 방문처리
			}
		}
	}
}