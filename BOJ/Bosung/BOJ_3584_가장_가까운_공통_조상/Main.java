package BOJ_3584_가장_가까운_공통_조상;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static List<Integer> Ajo, Bjo;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			arr = new int[N+1];
			Ajo = new ArrayList<>();
			Bjo = new ArrayList<>();
			ans = 0;
			
			// n번째 리스트에 m이 저장됨 -> m이 n의 부모이다.
			for (int i = 1; i < N; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				arr[child] = parent;
			}
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			finding(A, B);
			System.out.println(ans);
		}
	}
	static void finding(int A, int B) {
		Ajo.add(A);
		Bjo.add(B);
		if (Bjo.contains(A)) {
			ans = A;
			return;
		}
		if (Ajo.contains(B)) {
			ans = B;
			return;
		}
		int Ap = arr[A];
		int Bp = arr[B];
		finding(Ap, Bp);
	}
}
