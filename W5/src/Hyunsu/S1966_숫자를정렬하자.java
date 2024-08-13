package Hyunsu;

import java.util.*;

/**
 * 다시 풀기
 * 카운트 배열을 이용해서 풀자
 */
public class S1966_숫자를정렬하자 {
	static Scanner sc = new Scanner(System.in);
	//최대가 5이상 50이하
	static int[] count = new int[51];
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			count = new int[51];
			int n = sc.nextInt();
			for(int num=0; num < n ; num++) {
				int tmp = sc.nextInt();
				count[tmp]++;
			}
			
			//출력
			System.out.print("#"+t);
			for(int l=0; l<=50; l++) {
				if(count[l] != 0) {
					//카운트 요소가 0이 아니라면
					for(int k=0; k<count[l]; k++) {
						System.out.print(" "+l);
					}
				}
			}
			System.out.println();
			
		}
	}
	

}
