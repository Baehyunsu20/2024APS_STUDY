package 요리사_4012;
import java.util.*;
import java.io.*;
/**
 * 각 음식의 맛 = 음식을 구성하는 시너지들의 합.
 * 식재료의 갯수가 N이라면, N/2로 음식을 만들고, 나머지 N/2로 음식을 만든다(N은 무조건 짝수)
 */

public class Solution {
	static int[][] arr;
	static int min;
	static int n;
	static List<Integer> tmpA;
	static List<Integer> tmpB;
	static boolean[] sel;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input_요리사.txt"));
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			
			n=sc.nextInt();
			arr = new int[n][n];
			sel = new boolean[n];
			
			//최솟값으로 갱신될 min값
			min = Integer.MAX_VALUE;
			
			for(int i=0; i< n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}//배열 입력의 완성
			
			//인덱스를 처음부터 돌면서 조합을 다 찾아야함.
			recurr(0);
			System.out.println("#"+t+" "+min);
			
			
		}
		
	}
	private static void recurr(int idx) {
		//n/2인 조합을 하나 만들고, 그 조합의 그룹 A와 나머지 그룹 B를 만든다
		//두 그룹의 맛조합의 차이를 구하고, min을 갱신
		
		//기저 조건 : 모든 조합을 고려해줬을 경우, 4개인 경우를 찾아야함.
		if(idx == n) {
			tmpA = new ArrayList<>();
			tmpB = new ArrayList<>();
			for(int i=0; i<n; i++) {
				if(sel[i]) {
					//true일때는 그 재료가 들어간 것.
					//i=0이면 1번 재료 들어감.
					//tmp = A조합, 나머지 = B조합
					tmpA.add(i);
				}
				else {
					tmpB.add(i);
				}
			}
			//하나의 조합을 만들었을때,
			//조합이 n/2일때만 고려
			if(tmpA.size() == n/2) { 
//				System.out.println("A :"+tmpA+ " B :"+tmpB );
				int pointA=point(tmpA);
				int pointB=point(tmpB);
				//둘의 맛 차이를 구하고 최소값 갱신
				int diff = pointA>=pointB ? pointA-pointB: pointB-pointA;
				if(min>diff)min=diff;
			}
			

			return;
		}
		
		
		
		//재귀 부분
		sel[idx] = true;
		recurr(idx +1);
		sel[idx] = false;
		recurr(idx +1);
		
	} 
	private static int point(List<Integer> tmp) {
		//두개를 뽑아서 점수를 더해야함.
		int point = 0;
		for(int i:tmp) {
			for(int j:tmp) {
				if(i != j) point += arr[i][j];
			}
		}
		return point;
	}

}