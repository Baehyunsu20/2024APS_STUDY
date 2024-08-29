package Minseo;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2805_농작물_수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t=1;t<=T;t++) {
			
			int N = Integer.parseInt(sc.nextLine());
			// 배열 입력받기
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				String str = sc.nextLine();
				for(int j=0;j<N;j++) {
					arr[i][j]=Character.getNumericValue(str.charAt(j));
				}
			}
			
			// System.out.println(Arrays.deepToString(arr));
			
			int num = N/2;
			int left=num-1, right=N-num;
			int sum=0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(c>left&&c<right) {
						sum+=arr[r][c];
					}
				}
				if(r<num) {
					left--;
					right++;
				}else if(r>=num) {
					left++;
					right--;
				}
			}
			
			System.out.println("#"+t+" "+sum);
			
		}
		sc.close();
	}

}
