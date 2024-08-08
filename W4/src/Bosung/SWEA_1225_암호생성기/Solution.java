package SWEA_1225_암호생성기;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 각 테스트 케이스마다 암호 배열을 저장할 2차원 배열 ans 생성 
		int[][] ans = new int[10][];
		
		for (int i = 0; i < 10; i++) {
			
			int t = sc.nextInt();
			
			// 8개의 숫자를 입력 받을 arr 배열 생성
			int[] arr = new int[8];
			
			// 8개 숫자 입력 받기
			for (int j = 0; j < 8; j++) {
				arr[j] = sc.nextInt();
			}
			
			// 8번째 숫자를 조건에 맞게 바꾸기 위해 move 배열 생성
			int[] move = {1, 2, 3, 4, 5};
			
			// move 배열의 위치를 바꿔주기 위한 k, arr[0]을 저장할 temp 생성
			int k = 0;
			int temp = 0;
			
			// 8번째 숫자가 0 이하가 될 때까지 조건에 맞게 수행
			while (arr[7] > 0) {
				// temp에 arr[0] 저장
				temp = arr[0];
				// 한 자리씩 앞으로 옮기기
				for (int j = 0; j < 7; j++) {
					arr[j] = arr[j+1];
				}
				// 8번째 숫자는 저장한 arr[0]에서 1, 2, 3, 4, 5를 돌아가며 빼기
				arr[7] = temp - move[k];
				k = (k+1)%5;
			}
			// 마지막 숫자가 0보다 낮을 수도 있으니 0으로 바꾸기
			arr[7] = 0;
			
			// arr 배열 저장
			ans[i] = arr;
		}
		
		// 테스트 케이스 번호와 8개의 숫자 출력
		for (int i = 0; i < 10; i++) {
			System.out.print("#" + (i+1) + " ");
			for (int j = 0; j < ans[i].length; j++){
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}