import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int w,h, island;
	static int [][]arr;
	static boolean [][]arr2;
	static boolean answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		for(int tc=1;tc<=1;tc++) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			
			island=0;
		
			// 미로판 받아오기
			arr = new int [w][h];
			for(int r=0;r<w;r++) {
				for(int c=0;c<h;c++) {
					arr[r][c]=sc.nextInt();
				}
			}
			

//			System.out.println(stc);
			
			// visited 체크할 녀석
			arr2 = new boolean[w][h];
			
			 for (int i = 0; i < w; i++) {
	                for (int j = 0; j < h; j++) {
	                    if (arr[i][j]==0 || arr2[i][j])
	                    continue;
	                    else{
	                        // 새로운 섬 발견
	                    	System.out.print(i);
	                    	System.out.println(j);
	                        dfs(i, j);
	                        island++;
//	                        island++;
	                    }
	                }
	            }		
				System.out.println("#"+tc+" "+island);
			}
		}// ende des tc
	// ende des main
	
	static void dfs(int r, int c) {
		// 기저조건
		if(r<0 || r>=w|| c<0 || c>=h || arr2[r][c] || arr[r][c]==0) {
			return;
		}
		arr2[r][c]=true;
		
		// 재귀부분
		// 완전탐색 하겠다 = 사방 탐색( 으 nr,nc)
		int [] dr = {-1,1,0,0,-1,-1,1,1}; // 상하좌우대각선까지
		int [] dc = {0,0,-1,1,-1,1,1,-1}; // 상하좌우대각선까지
		
		int nr=0;
		int nc=0;
		for(int i=0;i<8;i++) {
			 nr = r+dr[i];
			 nc = c+dc[i];
			// 안가는 경우 constraint // 사방 || visited || 또 하나가뭐였지
			if(nr<0||nr>=w||nc<0||nc>=h ||arr2[nr][nc]||arr[nr][nc]==0) {
				continue; // 가지 않습니다.
			}
			dfs(nr, nc);
		}
	}
	
}
