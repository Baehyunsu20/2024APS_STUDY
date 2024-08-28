package SWEA_1231_중위순회;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int N = sc.nextInt();
			
			char[] al = new char[N+1];

			int index = 0;
			
			while (al[N] == '\u0000') {
				
				char input = sc.next().charAt(0);
				
				if (input > '9') {
					al[++index] = input;
				}
			}
			
			System.out.print("#" + t + " ");
			inorder(1, al);
			System.out.println();
		}
		
	}
	
	static void inorder(int root, char[] al) {
		
		if (root * 2 < al.length)
			inorder(root * 2, al);

		System.out.print(al[root]);

		if (root * 2 + 1 < al.length)
			inorder(root * 2 + 1, al);
		
	}
	
}
