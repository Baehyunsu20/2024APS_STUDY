import java.io.IOException;
import java.util.Scanner;

public class BOJ_4963 {

	static int w,h;                                 // 너비 높이 입력
	static int[][] map;                             // 맵 배열 선언
	static boolean[][] visited;                     // 체크 배열 선언
    static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};  // 델타 팔방 탐색 위한 배열
    static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};  // 델타 팔방 탐색 위한 배열

	public static void main(String[] args) throws IOException{
		
        Scanner sc = new Scanner(System.in);
        
        while(true) {                   			// 일단 그냥 한무반복
			
			w = sc.nextInt();                       // 너비 입력
			h = sc.nextInt();                       // 높이 입력
			int cnt=0;                              // 섬 개수 초기화

			if (w == 0 && h == 0) break;			// w와 h에 0이 입력되는 순간 끝
			map = new int[h][w];                    // 입력된 너비와 높이로 맵 배열 초기화
			visited = new boolean[h][w];            // 입력된 너비와 높이로 체크 배열 초기화

			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[i][j] = sc.nextInt();       // 맵 구성
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] ==1 && !visited[i][j]) {
						cnt += dfs(j,i);          // 땅이고 방문 안한 곳마다 dfs 굴려서 1씩 추가
					}
				}
			}
			System.out.println(cnt);
			
		}
	}
	
	static int dfs(int x, int y) {
		
		visited[y][x] =true;
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];                     // 팔방탐색을 해서...
			
			if(nx < 0 || ny < 0 || nx > w-1 || ny > h-1) continue;  // 배열 밖이면 무시하고
			if(visited[ny][nx]) continue;           // 해당 위치 방문했다면 무시하고
			
			if(map[ny][nx]==1) {
				dfs(nx,ny);                         // 위의 조건을 제외한 땅은 dfs 반복
			}
		}
		
		return 1;                                   // 땅 사이즈는 무시하고 섬이 있으므로 1 반환
	}
}