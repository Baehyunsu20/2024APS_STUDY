import java.util.Scanner;

public class Solution {
    
    static int result;
    static int visited[][];
    static int map[][];

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public void dfs(int x, int y) {					// dfs 구현

        if( map[x][y] == 3) {
            result = 1;								// 도착점에 도착하면 결과값을 1 만들면서
            return;									// 리턴
        }
        else {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];					// 행에 대한 델타탐색
                int ny = y + dy[i];					// 열에 대한 델타탐색

                if(nx>=0 && nx < 16 && ny >= 0 && ny < 16 && map[nx][ny] != 1) {
                    if(visited[nx][ny] == 0) {		// 길에서...
                        visited[nx][ny] = 1;
                        dfs(nx, ny);
                        visited[nx][ny] = 0;		// 백트래킹
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            result = 0;
            int T = sc.nextInt();					// 입력에서 매번 테스트케이스를 확인하므로 매번 입력
            map = new int [16][16];					// 16x16의 맵 배열
            visited = new int [16][16];				// 16x16의 방문체크
            for(int i = 0; i < 16; i++) {
                String line = sc.next();			// 매 행마다 한줄씩 읽기
                for(int j = 0; j < 16; j++) {
                    map[i][j] = line.charAt(j) - '0';	// 그거 출력하기
                }
            }
            int sx = 0; 							// 시작점 초기화
            int sy = 0;								// 시작점 초기화
            for(int i = 0; i < 16; i++) {
                for(int j = 0; j < 16; j++) {
                    if(map[i][j] == 2 ) {			// 시작점을 찾은 뒤에...
                        sx = i;						// 시작점에 대한 입력
                        sy = j;						// 시작점에 대한 입력
                    }
                }
            }

            Solution mr = new Solution();
            visited[sx][sy]=1;						
            mr.dfs(sx, sy);							// dfs 시작
            System.out.println("#" + tc + " " + result);
        }
        sc.close();
    }
}
