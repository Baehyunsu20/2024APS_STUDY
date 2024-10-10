package 단지개수_2667;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		List<Integer> house = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					count = 1;
					bfs(i,j);
					house.add(count);
				}
			}
		}
		Collections.sort(house);
		System.out.println(house.size());
		for(int k = 0; k < house.size(); k++) {
			System.out.println(house.get(k));
		}

	}
	static void bfs(int i, int j) {
		Queue<int[]> apart = new LinkedList<>();
		apart.offer(new int[] {i ,j});
		visited[i][j] = true;

		while(!apart.isEmpty()) {
			int[] curr = apart.poll();
			int x = curr[0];
			int y = curr[1];

			for(int a = 0; a < 4; a++) {
				int nx = x + di[a];
				int ny = y + dj[a];

				if(nx >=0 && ny >= 0 && nx < N && ny < N) {
					if(map[nx][ny] == 1 && visited[nx][ny] == false) {						
					apart.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					count++;
					}
				}
			}
		}
	}
}
