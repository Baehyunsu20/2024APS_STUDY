package Minseo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1230_암호문3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int N = Integer.parseInt(sc.nextLine());
			String[] code = sc.nextLine().split(" ");
			LinkedList<String> answer = new LinkedList<String>();
			answer.addAll(Arrays.asList(code));
			
			int M = Integer.parseInt(sc.nextLine());
			String[] command = sc.nextLine().split(" ");
			
			int startIdx, length;
			for(int i=0;i<command.length;i++) {
				if(command[i].equals("I")) {
					startIdx = Integer.parseInt(command[i+1]);
					length = Integer.parseInt(command[i+2]);
					for(int j=0;j<length;j++) {
						answer.add(startIdx+j,command[i+3+j]);
					}
				}else if(command[i].equals("D")) {
					startIdx = Integer.parseInt(command[i+1]);
					length = Integer.parseInt(command[i+2]);
					for(int j=0;j<length;j++) {
						answer.remove(startIdx+j);
					}
					
				}else if(command[i].equals("A")) {
					length = Integer.parseInt(command[i+1]);
					for(int j=0;j<length;j++) {
						answer.addLast(command[i+2+j]);
					}
				}
			}
			
			String ans = "";
			for(int i=0;i<10;i++) {
				ans += answer.get(i) +" ";
			}
			System.out.printf("#%d %s\n",t,ans);
			
			
		}
	}

}
