package Minseo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class SWEA_1228_암호문1 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("src/input.txt"));
		
		for(int t=1;t<=10;t++) {
			int N = Integer.parseInt(sc.nextLine());
			String[] code = sc.nextLine().split(" ");
			// 암호문 LinkedList에 담기
			LinkedList<String> codes = new LinkedList<>();
			codes.addAll(Arrays.asList(code));
			
			int M = Integer.parseInt(sc.nextLine());
			String[] command = sc.nextLine().split(" ");
			
			for(int i=0;i<command.length;i++) {
				if(command[i].equals("I")) {		
					int startIdx = Integer.parseInt(command[i+1]);
					int length = Integer.parseInt(command[i+2]);
					for(int j=0;j<length;j++) {
						codes.add(startIdx+j, command[i+3+j]);
						// 배열 중간부터 바꾸는 줄 알았음,,,
//						if(startIdx+j<codes.size()) {
//							codes.set(startIdx+j, command[i+3+j]);															
//						}else {
//							codes.add(command[i+3+j]);
//						}
					}
				}
			}
			
			
			String answer = "";
			for(int i=0;i<10;i++) {
				answer += codes.get(i)+" ";				
			}
			System.out.printf("#%d %s \n",t,answer);
			
		}
	}

}
