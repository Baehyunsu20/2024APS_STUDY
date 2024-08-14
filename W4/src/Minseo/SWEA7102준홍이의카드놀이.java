package Minseo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA7102준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			// 카운팅 배열 생성
			int[] cntarr = new int[N+M+1];
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					cntarr[i+j]++;
				}
			}
			
			// 최댓값 도출
			int max = cntarr[0];
			List<Integer> index = new ArrayList<Integer>();
			for(int i=1;i<N+M+1;i++) {
				if(cntarr[i]>=max) {
					max=cntarr[i];
				}
			}
			// 최댓값이랑 같은 값을 가지는 인덱스 모두 뽑음
			for(int i=1;i<N+M+1;i++) {
				if(cntarr[i]==max) {
					index.add(i);
				}
			}
			
			// 출력
			System.out.print("#"+t);
			for(int idx : index)
			{
				System.out.print(" "+idx);
			}
			System.out.println();
		}
	}

}