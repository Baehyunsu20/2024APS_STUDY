package 햄버거다이어트_5215;
import java.util.*;
/**
 * 
 
1
5 1000
100 200
300 500
250 300
500 1000
400 400

 */

public class Solution {
	static int n;
	static int l;
	static int[][] arr; 
	static boolean[] sel;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			l=sc.nextInt();
			//0: 점수 ; 1: 칼로리
			arr = new int[2][n];
			//재료를 선택했냐 안했냐를 따짐.
			sel = new boolean[n];
			
			max=0;
			for(int i=0; i<n; i++) {
				arr[0][i] = sc.nextInt();
				arr[1][i] = sc.nextInt();
			}
			
			recurr(0);
			
			System.out.println("#"+t+" "+max);
			
		}

	}
	private static void recurr(int idx) {
		
		//기저조건 : n=5이면
		if(idx == n) {
			int sum =0;
			int point =0;
			for(int i=0; i<n; i++) {
				if(sel[i]) {
					//재료가 포함될 경우, 칼로리를 더함
					point += arr[0][i];
					sum += arr[1][i];
				}
			}//하나의 조합 완성
			//칼로리의 합이 입력 이하일때.
			if(sum <= l) {
				//최댓값 갱신
//				System.out.println("갱신");
				if(max<point)max=point;
			}
			return;
		}//기저조건
		
		sel[idx] = true;
		recurr(idx + 1);
		
		sel[idx] = false;
		recurr(idx + 1);
		
	}

}