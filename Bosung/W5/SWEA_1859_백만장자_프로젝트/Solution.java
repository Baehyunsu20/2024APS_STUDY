package SWEA_1859_백만장자_프로젝트;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 날의 수 입력
			int N = sc.nextInt();
			
			// 날마다 매매가를 저장하기 위한 price 배열 생성
			int[] price = new int[N];
			
			// 날마다 매매가 price 배열에 저장
			for (int i = 0; i < N; i++) {
				price[i] = sc.nextInt();
			}
			
			// 마지막 날부터 비교하기 위해 maxPrice를 마지막 날 가격으로 설정
			int maxPrice = price[N-1];
			
			// 최대 이익을 저장할 long 타입 변수 money (int의 최댓값을 넘어가는 경우가 생겨 long으로 설정)
			long money = 0;
			
			// 마지막날부터 시작하여 i번째 날의 가격이 maxPrice보다 낮으면 값의 차를 money에 추가
			// i번째 날의 가격이 maxPrice보다 높으면 그날의 가격을 maxPrice로 설정
			for (int i = N-1; i >= 0; i--) {
				if (price[i] <= maxPrice) {
					money += maxPrice - price[i];
				}
				else {
					maxPrice = price[i];
				}
			}
			
			// 테스트 케이스 번호와 최대 이익 출력
			System.out.println("#" + t + " " + money);
		}
	}
}
