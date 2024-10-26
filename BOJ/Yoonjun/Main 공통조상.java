package Boj_3584_가장가까운공통조상;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;	
	static List<Integer>[] tree;
	static int[] parent;
	static boolean[] visited;
	static int[] depth;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			N = sc.nextInt();
			tree = new ArrayList[N+1];
			parent = new int[N + 1];
            depth = new int[N + 1];
            visited = new boolean[N + 1];

		
		for(int i = 0; i <= N; i++) {
			tree[i] = new ArrayList();
		}
		
		for(int i = 0; i < N-1; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			tree[A].add(B);
			tree[B].add(A);
			
			parent[B] = A;
		}
		int root = findRoot();
		
		DFS(root, 0);

		int node1 = sc.nextInt();
        int node2 = sc.nextInt();
		
         
         int dab = josang(node1,node2);
         System.out.println(dab);
			
		}

	}
	static int findRoot() {

        // 자식으로 표시되지 않은 노드가 루트 노드
        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) {
                return i;
            }
        }
        return 1; // 기본적으로 1을 반환 (문제 조건 상 항상 루트가 존재함)
    }
	static void DFS(int current, int dep) {
	    visited[current] = true; // 현재 노드를 방문했음을 표시
	    depth[current] = dep; // 현재 노드의 깊이를 설정

	    // tree[current]의 각 요소를 순회
	    for (int i = 0; i < tree[current].size(); i++) {
	        int next = tree[current].get(i); // 현재 순회 중인 자식 노드

	        if (!visited[next]) { // 자식 노드가 아직 방문되지 않았다면
	            parent[next] = current; // 자식 노드의 부모를 현재 노드로 설정
	            DFS(next, dep + 1); // 자식 노드로 재귀 호출, 깊이를 +1 증가
	        }
	    }
	}
	
	static int josang(int node1, int node2) {
        // 두 노드의 깊이를 맞춤
        while (depth[node1] > depth[node2]) {
            node1 = parent[node1];
        }
        while (depth[node2] > depth[node1]) {
            node2 = parent[node2];
        }

        // 두 노드를 동시에 부모로 거슬러 올라가며 공통 조상을 찾음
        while (node1 != node2) {
            node1 = parent[node1];
            node2 = parent[node2];
        }

        return node1;
    }
}


