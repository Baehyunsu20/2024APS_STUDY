package SWEA_6190_정곤이의_단조_증가하는_수;

import java.util.Scanner;

public class Solution {
	
	// 메인 메소드
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			
			// N개의 정수를 받는 nums 배열 생성
			int[] nums = new int[N];
			
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			// 단조 증가하는 수가 없으면 -1을 출력하기 위해 max를 -1로 설정
			int max = -1;
			
			// nums 배열에서 조건을 만족하는 i, j번째 정수에 대해 곱을 구한 뒤
			// 단조 증가이면 max와 비교하여 큰 값을 max 에 저장
			for (int i = N - 2; i >= 0; i--) {
				for (int j = N - 1; j > i; j--) {
					if (isDanzo(nums[i]*nums[j]) && nums[i]*nums[j] > max) {
						max = nums[i]*nums[j];
					}
				}
			}
			
			// 단조 증가하는 수가 있으면 그 중에서 최댓값을, 없으면 -1을 출력
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	// 단조 증가인지 파악하기 위한 isDanzo 메소드
	static boolean isDanzo(int num) {
		
		// 입력 받은 수를 String으로 변환
		String numStr = String.valueOf(num);
		// String으로 받은 수를 자리수마다 저장하기 위한 numChar 배열 생성
		char[] numChar = new char[numStr.length()];
		
		// 입력 받은 수를 자리수마다 나누어 numChar 배열에 저장함
		for (int i = 0; i < numStr.length(); i++) {
			numChar[i] = numStr.charAt(i);
		}
		// 단조 증가를 파악하여 리턴할 boolean 값 danzo을 true로 설정
		boolean danzo = true;
		
		// numChar 배열에서 수를 비교하여 단조 증가가 아니면 danzo를 false로 설정
		for (int i = 0; i < numChar.length - 1; i++) {
			if (numChar[i] > numChar[i+1]) {
				danzo = false;
				break;
			}
		}
		// 단조 증가 여부 출력
		return danzo;
	}
}
// 처음엔 모든 수를 받아서 모든 곱을 ArrayList 배열에 저장하고 큰 수부터 나열한 뒤 앞부터 단조 증가인지 파악함 -> 시간 초과
// 큰 수부터 나열하는 과정을 지우고 모든 곱 배열을 앞부터 단조 증가인지 파악하여 가장 큰 값을 출력함 -> 시간 초과
// 모든 곱을 ArrayList에 저장하는 과정을 없애고 곱을 구할 때마다 단조 증가인지 파악하여 이전의 단조 증가인 곱보다 크면 max에 저장하여 마지막에 max 출력 -> 통과
// 모든 곱을 구하는 과정이 포함되어 있는 데도 통과된 걸 보면 이전에 시간 초과된 이유는 모든 곱을 ArrayList에 저장하는 과정이 시간을 많이 잡아먹은 듯 함
