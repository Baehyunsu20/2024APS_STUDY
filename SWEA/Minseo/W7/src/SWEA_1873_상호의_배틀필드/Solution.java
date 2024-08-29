package SWEA_1873_상호의_배틀필드;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Solution {
	
	static int H, W;
	static char[] move = {'U','D','L','R','S'};
	static char[] dir = {'^','v','<','>'};
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int R=0, C=0, d;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			sc.nextLine();
			char[][] map = new char[H][W];
			
			// 배열 입력받기
			for(int h=0;h<H;h++) {
				String str = sc.nextLine();
				for(int w=0;w<W;w++) {
					map[h][w]=str.charAt(w);
					// 전차가 발견되면 시작 위치, 방향 저장
					if(map[h][w]=='^'||map[h][w]=='v'||map[h][w]=='<'||map[h][w]=='>') {
						R = h; C = w;
						for(int i=0;i<dir.length;i++) {
							if(map[h][w]==dir[i]) {
								d=i;
							}
						}
					}
				}
			}
			
			int N = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine();
			
			for(int i=0;i<N;i++) {
				char command = str.charAt(i);
				
				int idx=0;
				for(int j=0;j<move.length;j++) {
					if(command==move[j]) {
						idx=j;
					}
				}
				if(idx!=4) {
					if(R+dr[idx]>=0&&R+dr[idx]<H&&C+dc[idx]>=0&&C+dc[idx]<W) {
						// 범위 안에 들어오고
						if(map[R+dr[idx]][C+dc[idx]]=='.') {
							// 이동할 칸이 비어있다면
							map[R][C]='.';
							R+=dr[idx]; C+=dc[idx];
						}
						map[R][C]=dir[idx];
						d = idx;
					}
				}else {// 발사
					int nr=R, nc=C; // 시작위치
					while(nr+dr[d]>=0&&nr+dr[d]<H&&nc+dc[d]>=0&&nc+dc[d]<W) {
						if(map[nr+dr[d]][nc+dc[d]]=='*') {
							nr+=dr[d]; nc+=dc[d];
							map[nr][nc]='.';
							break;
						}else if(map[nr+dr[d]][nc+dc[d]]=='#') {
							break;
						}else {
							nr+=dr[d]; nc+=dc[d];
						}
					}
				}
			}
			
			// 출력
			System.out.print("#"+t+" ");
			for(int h=0;h<H;h++) {
				for(int w=0;w<W;w++) {
					System.out.print(map[h][w]);
				}
				System.out.println();
			}
		}
	}
}