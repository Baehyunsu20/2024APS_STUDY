package BOJ_10816_숫자_카드_2_LBUB;

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
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			int min = 0;
			int max = N;
			
			// 1. lowerBound: 중복에 대해 왼쪽으로 탐색 (조건 만족하는 가장 왼쪽 인덱스)
			while (min < max) {
				int mid = min/2 + max/2;
				if (pCard[i] <= sCard[mid]) {
					max = mid;
				}
				else {
					min = mid + 1;
				}
			}
			int lb = min;
			
			min = 0;
			max = N;
			
			// 2. upperBound: 조건을 만족하는 인덱스의 바로 다음 위치
			while (min < max) {
				int mid = min/2 + max/2;
				if (pCard[i] < sCard[mid]) {
					max = mid;
				}
				else {
					min = mid + 1;
				}
			}
			int ub = min;
			
			// 2에서 구한 값 - 1에서 구한 값
			sb.append(ub-lb + " ");
		}
		
		System.out.println(sb);
	}
}
// 시간줄이는 방법
// 1. 스캐너 -> 버퍼드 리더
// 2. counting에 중복횟수 저장한 뒤 꺼내기 -> lb, ub 따로 구해서 빼기
// 3. ans라는 str을 ""로 만들어 추가하기 -> 스트링빌더 쓰기
// 3개 다 하니까 시간초과가 안 뜸