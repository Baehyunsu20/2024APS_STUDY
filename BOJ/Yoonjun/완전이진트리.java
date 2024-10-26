package Boj_9934_완전이진트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[] gunmul;
	static List<Integer>[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		int N = (1 << K) - 1;
		
		gunmul = new int[N];
		tree = new ArrayList[(1 << K) - 1];

		for(int i = 0; i < N; i++) {
			gunmul[i] = sc.nextInt();
		}
		
		for(int i = 0; i < K; i++) {
			tree[i] = new ArrayList();
		}
		
		constructTree(0, N-1, 0);
		
		for(int i = 0; i < K; i++) {
			for(int j = 0; j < tree[i].size(); j++) {
			System.out.print(tree[i].get(j)+" "); 
			}
			System.out.println();
		}
		
	}
	static void constructTree(int left, int right, int depth) {
		if (left > right) return;
		
		int mid = (left + right) / 2;
		
		tree[depth].add(gunmul[mid]);
		
		constructTree(left, mid - 1, depth + 1);
        
        
        constructTree(mid + 1, right, depth + 1);
    }

}
