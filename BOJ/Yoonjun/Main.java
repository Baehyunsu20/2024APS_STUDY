package Boj_2178_미로탐색;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] maze;
	static int N, M;
	static int count;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int dist = 1;
	static int[][] distance;
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		maze = new int[N][M];
		visited = new boolean [N][M];
		distance = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}
		distance[0][0] = 1;
		bfs(0,0);
		System.out.println(Arrays.deepToString(distance));
		System.out.println(distance[N - 1][M - 1]);
		

	}
	static void bfs(int x, int y) {
		Queue<int[]> load = new LinkedList<>();
		load.offer(new int[] {x,y});
		visited[x][y] = true;
		
		while(!load.isEmpty()) {
			int[] curr = load.poll();
			int r = curr[0];
			int c = curr[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];
				
				if(nx  >=0 && ny>=0&& nx < N && ny <M) {
					if(maze[nx][ny] == 1 && !visited[nx][ny]) {
						load.offer(new int[] {nx,ny});
						visited[nx][ny] = true;
						distance[nx][ny] = distance[r][c] + 1;
					}
				}
			}
		}
	}

}
