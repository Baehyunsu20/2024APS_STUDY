package Hyunsu;
import java.util.*;

public class S2805_농작물수확하기{
//	static Scanner sc = new Scanner(new file("./src/SWEA_2805_농작물_수확하기//input (17).txt"));
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=1; t++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for(int r=0;r<n;r++) {
				String line = sc.next();
				for(int c=0; c<n;c++) {
					//아스키 값이므로 0을 뺴줌
					arr[r][c] = line.charAt(c)-'0';
				}
			}//배열 받아오기 완료
			
			int start = n/2;
			int end = n/2;
			
			int sum =0;
			
			for(int row=0; row<n; row++) {
				//5/2 = 2 : 0,1,2번째 줄까지
				for(int i=start; i<=end; i++) {
//					System.out.println("row : "+row+" 넣을 값 : " + arr[row][i]);
					sum += arr[row][i];
				}
				//row < 2 : 0,1까지만
				//인덱스 1까지까지의 3개의 수를 더해주고 증감 연산을 해주기 때문에 n/2는 포함하지 않음.
				if(row < n/2) {
					//늘어나기
					start--;
					end++;
//					System.out.println("s : "+ start+" e : "+end);
				}
				else {
					//다시 줄어들기
					start++;
					end--;
				}
				
				
				
			}
			System.out.println("#"+t+" "+sum);
			
			
			
			
		}
	}

}

