package BOJ_11728_배열_합치기_br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int al = Integer.parseInt(st.nextToken());
		int bl = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[al+bl];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < al; i++) {
			sum[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = al; i < al + bl; i++) {
			sum[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sum);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < sum.length; i++) {
			sb.append(sum[i] + " ");
		}
		
		System.out.println(sb);
	}
}