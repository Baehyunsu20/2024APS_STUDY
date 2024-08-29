package Minseo;

import java.io.*;
import java.util.*;

public class J조커_1205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
			}
		
		Arrays.sort(arr); // 정렬
		
		// 0 개수 세기
		int zerocnt=0;
		for(int i=0;i<N;i++) {
			if(arr[i]==0) zerocnt++;
		}
		
		// 배열이 다 0일때
		if(zerocnt==arr.length) {System.out.println(arr.length);}
		
		// 배열이 다 양수일때
		else if(zerocnt==0) {
			int len=1, max=0;
			// 연속 배열 세기
			for(int i=0;i<N-1;i++) {
				// i번째, i+1번째 값이 연속이면 len++
				if(arr[i+1]==arr[i]+1) len++;
				// 같지 않으면 max 업데이트
				else {
					if(len>max) {
						max=len; 
						}
					len=1;
					}
				// 혹은 배열이 끝나면 max 업데이트
				if(i==N-2) {
					if(len>max) {
						max=len;
						}
					}
				}
			System.out.println(max);
		}
		
		// 배열에 0, 양수 섞여있을 때
		else {
			int len=1, sum=0, max=0, zeroleft=zerocnt;
			for(int i=zerocnt;i<N-1;i++) {
				// i번째, i+1번째 값이 연속이면 len++
				if(arr[i+1]==arr[i]+1) len++;
				// 같지 않으면 sum, max 업데이트 해주고 len=1로 초기화
				else {
					// i번째, i+1번째 값 차이가 0 개수보다 클때
					if(arr[i+1]-arr[i]-1>zeroleft) {
						// 연속인 숫자개수 + 0 개수로 sum값 업데이트
						sum+=len+zeroleft;
						// max값 업데이트 후 sum, len값 초기화
						if(sum>max) {
							max=sum; 
							}
						sum=0;len=1;
						}						
					// i번째, i+1번째 값 차이가 0 개수보다 작거나 같을때
					else{
						// 연속인 숫자개수 + i번째, i+1번째 값 차이로 sum값 업데이트
						sum+=len+(arr[i+1]-arr[i]-1);
						// 남은 0개수, len값 초기화
						zeroleft-=(arr[i+1]-arr[i]-1);
						len=1;
						}
					}
				System.out.println(i+"번째 len:"+len);
				System.out.println(i+"번째 sum:"+sum);
				System.out.println(i+"번째 max:"+max);
				System.out.println(i+"번째 zeroleft:"+zeroleft);
							
				// 배열 다 돌았을 때
				if(i==N-2) {
					sum+=len+zeroleft;
					if(sum>max) {
						max=sum;
						}
					}
				}
			System.out.println(max);
			}
	}
}
			
					
	