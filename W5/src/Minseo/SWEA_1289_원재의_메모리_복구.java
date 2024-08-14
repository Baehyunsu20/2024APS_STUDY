package Minseo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SWEA_1289_원재의_메모리_복구 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		// 앞에서부터 1->0으로 바뀌는 부분이 있을 때 2번 바뀜, 1로 끝나면 한번 바뀜
		// ex 1101001 -> 5번 
		
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		
		// 숫자 배열 입력받기
		for(int tc=1;tc<=T;tc++) {
			String str = sc.next();
			String[] token = str.split("");
			int[] arr = new int[str.length()];
			
			for(int i=0;i<str.length();i++) {
				arr[i]=Integer.parseInt(token[i]);
			}
			
			
			// 처음부터 숫자 확인
			int cnt=0; boolean isTrue=false;
			for(int i=0;i<str.length();i++) {
				// 입력값이 1이면서 첫 1(isTrue==false) cnt 증가, isTrue값 바꿈
				if(arr[i]==1&&isTrue==false) {
					cnt++; isTrue=true;
				}
				// 입력값이 0이면서 첫 0이면(isTrue==true) cnt증가, isTrue값 바꿈
				else if(arr[i]==0&&isTrue==true){
					cnt++; isTrue=false;
				}
			}
			
			System.out.printf("#%d %d",tc, cnt);
			System.out.println();
			
			
		}
		
		
		
	}

}
