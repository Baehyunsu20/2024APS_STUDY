
import java.util.Scanner;

public class Solution {
    
	/* 설계 : DFS로 지나가는 곳은 check 배열로 흔적을 남긴다.
	무식하게 유사 DFS를 굴려서(N*N회) 덩이 하나하나를 카운트한다.
	한번의 DFS가 끝나면 그 이후 check 되지 않은 영역을 추적해서 다시 DFS.
	그렇게 반복하면 하루치 카운트가 끝.
	*/
	
	static int cnt, N, result, r, k;		
	static int [][] visited;				// dfs에서 방문에 대한 배열
	static int [][] check;					// 지나간 흔적에 대한 배열
	static int [][] map;					// 원래의 치즈 배열
	
	static int [] dx = {1, 0, -1, 0};		// for 델타배열
	static int [] dy = {0, 1, 0, -1};	
	
    public void dfs(int x, int y) {

        if( r == N*N) {						// 무식하게 돌리고 나면
            k++;						// 끝났다고 보고 덩이+1
            return;
        }
        else {								// 흔히 미로 돌듯이 덩이 확인하는 방식
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];			
                int ny = y + dy[i];

                if(nx>=0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 1) {
                    if(visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        check[nx][ny] = 1;	// 백트래킹과 상관없이 지나간 흔적을 남김
                        dfs(nx, ny);
                        visited[nx][ny] = 0;
                        r++;
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int tc = 1; tc <= T; tc++) {
        	
        	int N = sc.nextInt();
        	
        	map = new int[N][N];
        	visited = new int[N][N];
        	check = new int[N][N];
        	
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
          
            int max = 0;
            int sx = 0; 						// 시작지점 [i] 대응
            int sy = 0;							// 시작지점 [j] 대응
            int day = 1;						// 첫날부터 먹방 시작
            while (day <= 100) {
            	cnt = 0;
            	k = 0;
            	r = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == day)		//
                	visited[i][j] = 1;			// 쥐가 먹어서 사실상 방문한곳 됨
                }
            }
            
            while ( cnt < N*N/2) {				// 무식하게 반복 돌리기
            	outer:
            for(int i = sx; i < N; i++) {
                for(int j = sy; j < N; j++) {
                    if( check[i][j] == 0 ) {	// 체크 안된=지나간 적 없는 곳 마주치면
                        sx = i;					// 좌표 기록후 dfs 준비
                        sy = j;
                        break outer;
                    }
                }
            }
            Solution mr = new Solution();
            visited[sx][sy]=1;
            mr.dfs(sx, sy);
            cnt++;
            
            }
            max = Math.max(max, k);					// 지금까지 가장 많은 덩이
            day++;								// 하루 지나감
            	}
            System.out.println("#" + tc + " " + max);
        }
        sc.close();
    }
}
