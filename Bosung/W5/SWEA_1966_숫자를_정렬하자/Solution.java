package SWEA_1966_숫자를_정렬하자;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 입력될 숫자의 수 입력
			int N = sc.nextInt();
			
			// 입력 되는 숫자를 넣을 배열 생성
			int[] nums = new int[N];
			
			// 숫자를 입력받아 배열 생성
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			// 오름차순으로 정렬
			Arrays.sort(nums);
			
			// 정렬한 뒤 출력
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
		}
	}
}
