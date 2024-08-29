package Minseo;

import java.io.*;
import java.util.*;

public class SWEA_1860_진기의_최고급_붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			
			// 붕어빵 M초당 K개씩 만들어짐
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] arr = new int[N];
			int max=0;
			for(int n=0;n<N;n++) {
				arr[n]=sc.nextInt();
			}
			
			Arrays.sort(arr); //손님이 도착하는 시간 배열 오름차순으로 정렬
			
			int cnt=0, bread=0;// 손님이 도착한 시간을 붕어빵이 처음 만들어진 초로 나눈 몫X붕어빵 개수 -> 붕어빵 개수
			for(int n=0;n<N;n++) {
				bread = arr[n]/M * K - cnt;
				if(bread>=1) {cnt++;}
			}
			
			if(N==cnt) System.out.println("#"+t+" Possible");
			else System.out.println("#"+t+" Impossible");
			
		}
		
	}

}
