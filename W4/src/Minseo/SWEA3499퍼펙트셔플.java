package Minseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA3499퍼펙트셔플 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] arr1 = new String[(N+1)/2];
			String[] arr2 = new String[N/2];
			
			// 배열 받기
			// arr1에 1~(N+1)/2 까지의 카드를, arr2에 나머지 카드 받음
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<(N+1)/2;i++) {
				arr1[i]=st.nextToken();
			}
			for(int i=0;i<N/2;i++) {
				arr2[i]=st.nextToken();
			}
			
			// 섞기
			// arr배열 생성해서 카드를 처음부터 번갈아가며 추가
			List<String> arr = new ArrayList<>();
			for(int i=0;i<N/2;i++) {
				arr.add(arr1[i]);
				arr.add(arr2[i]);
			}
			// 카드가 N개 다 안들어갔을 경우(N이 홀수일 때) 마지막 카드 추가
			if(arr.size()<N) {
				arr.add(arr1[(N+1)/2-1]);
			}
			
			// 출력
			System.out.print("#"+t);
			for(String str : arr) {
				System.out.print(" "+str);				
			}
			System.out.println();
		}
		
				
	}

}