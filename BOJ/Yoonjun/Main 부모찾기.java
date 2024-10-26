package Boj_11752_트리부모찾기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V  = sc.nextInt();
		
		List<Integer>[] bumo = new ArrayList[V+1];
		
		for(int i = 0 ; i <= V; i++) {
			bumo[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < V-1; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			bumo[A].add(B);
			bumo[B].add(A);
		}
		int[] dab = new int[V+1];
		
		Queue<Integer> qu = new LinkedList<>();
		qu.add(1);
		dab[1]=1;
		
		while(!qu.isEmpty()) {
			int curr = qu.poll();
			
			for(int i = 0; i < bumo[curr].size(); i++) {				
				if(dab[bumo[curr].get(i)] == 0) {
					dab[bumo[curr].get(i)] = curr;
					qu.add(bumo[curr].get(i));
				}
			}
		}
		
		for(int i = 2; i <= V; i++) {
			System.out.println(dab[i]); 
		}
		

	}

}
