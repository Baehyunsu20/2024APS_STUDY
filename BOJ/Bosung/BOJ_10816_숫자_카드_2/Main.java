package BOJ_10816_숫자_카드_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] sCard = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sCard[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] pCard = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			pCard[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sCard);
		
		int[] counting = new int[20000001];
		for (int i = 0; i < N; i++) {
			counting[sCard[i]+10000000]++;
		}
		
		int ans[] = new int[M];
		
		for (int i = 0; i < M; i++) {
			int min = 0;
			int max = N;
			
			while (min < max) {
				int mid = min/2 + max/2;
				if (pCard[i] == sCard[mid]) {
					ans[i] = counting[sCard[mid]+10000000];
					break;
				}
				else if (pCard[i] < sCard[mid]) {
					max = mid;
				}
				else {
					min = mid + 1;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
