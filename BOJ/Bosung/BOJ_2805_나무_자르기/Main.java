package BOJ_2805_나무_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 버퍼 리더 연습 중
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		
		st = new StringTokenizer(br.readLine());

		long min = 0;
		long mid = 0;
		long max = 0;
		
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (tree[i] > max) {
				max = tree[i];
			}
		}
		max++;
		
		while (min < max) {
			mid = min/2 + max/2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (tree[i] >= mid) {
					sum += tree[i] - mid;
				}
			}
			if (sum < M) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		System.out.println(min-1);
	}
}
