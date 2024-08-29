package Minseo;

import java.io.*;
import java.util.*;

public class S쇠막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt(); // 테스트 케이스 수 T 주어짐
		sc.nextLine();
		
		for(int t=1;t<=T;t++) {
			
			// 문자열 읽어와서 char 배열로 담기
			// String 배열이 아니라 char 배열로 담은 이유는 문자 비교시
			// String은 .equals()를 사용해야 하고 char는 ==로 비교 가능하기 때문
			String str=sc.nextLine();
			char[] strarr = str.toCharArray();
			
			int sum=0;				// 값 초기화
			
			for(int i=0;i<strarr.length;i++) {
				// 레이저 -> L로 표시
				if(strarr[i]=='(' && strarr[i+1]==')') {
					strarr[i]='L'; strarr[i+1]='L';
					i++; 
				}
				// 막대의 시작부분 S로 표시
				else if(strarr[i]=='(') {
					strarr[i]='S';
				}
				// 막대가 끝나는 부분에서 백트래킹으로 S를 찾을 때까지 레이저(L)개수 세기
				else if(strarr[i]==')') {
					strarr[i]='E';
					int cnt=0;
					// 백트래킹으로 S 찾기
					for(int j=i-1;j>=0;j--) {
						if(strarr[j]=='L') cnt++;
						else if(strarr[j]=='S') {
							strarr[j]='E';
							sum+=cnt/2+1;
							break;
						}
					}
				}
			}
			
			
			System.out.printf("#%d %d",t,sum);
			System.out.println();
		
		}
		sc.close();
		
	}

}
