package SWEA_1289_원재의_메모리_복구;

import java.util.Scanner;
public class Solution {

public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=1; t<=T; t++) {
		int cnt=0;
		String a = sc.next();
		char [] arr = a.toCharArray();
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i]=='0') {
				continue;
			} else {
				cnt++;
				for(int j = i; j < arr.length; j++) {
                    if(arr[j] == '1') {
                        arr[j] = '0';
                    }
                    else {
                    	arr[j]='1';
                    }
				}	
			}
		}
		System.out.printf("#%d %d",t,cnt);
        System.out.println();
	}
}		
}
