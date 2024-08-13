package Hyunsu;

import java.util.*;
import java.io.*;


/**
 * 000~00에서 주어진 케이스의 값으로 어떻게 바꿀 수 있는지
 */

public class S1289_원재의메모리복구 {
	static int cnt  = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input_메모리.txt"));
//		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			//첫번째 케이스를 고려
			String line = sc.next();
			int[] list = new int[line.length()];
			//tmp안에 인덱스가 글자 숫자대로 있다.
			String [] tmp = line.split("");
			for(int size=0; size<line.length(); size++) {
				list[size] = Integer.parseInt(tmp[size]);
				
			}//배열을 완성해둠 -> 이제 카운트를 시작해야함
			
			//00만으로 초기화 되었을 때 원본으로 바꾸기 위해 얼마나 변화해야하나
			cnt = 0;
			int[] prelist = new int[list.length];
			for(int i=0; i<list.length; i++) {
				if(prelist[i] != list[i]) {
					//같지 않으면 그 뒤를 다 바꿔줘야함.
					reverse(prelist, i);
				}
			}
			
			System.out.println("#"+t+ " " +cnt);


		}
		sc.close();
	
	}
	
	static int[] reverse(int[] list, int idx) {
		for(int i=idx; i<list.length; i++) {
			if(list[i]==0) {
				list[i] = 1;
			}
			else {
				list[i] = 0;
				
			}
		}
		//변형이 몇번 이뤄났는지 카운트
		cnt ++;
		return list;
	}
	

}
