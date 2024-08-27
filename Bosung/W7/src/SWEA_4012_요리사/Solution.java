package SWEA_4012_요리사;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int t = 1; t <= T; t++) {
            
        	// 각 테스트 케이스의 식재료 수 입력 받기
            int N = sc.nextInt();
            
            // 시너지 값들 입력 받을 N*N의 2차원 배열 board 생성
            int[][] board = new int[N][N];
            
            // 시너지 값 입력 받기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    board[r][c] = sc.nextInt();
                }
            }
            
            // 맛의 차이의 최솟값을 저장할 gap을 Integer의 최댓값으로 설정
            int gap = Integer.MAX_VALUE;
            
            // 비트마스킹을 통해 g1, g2의 두 식재료그룹을 만듦
            for (int i = 0; i < 1<<N; i++) {
                List<Integer> g1 = new ArrayList<>();
                List<Integer> g2 = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    if ((i & 1<<j) > 0) {
                        g1.add(j);
                    }
                    else {
                        g2.add(j);
                    }
                }
                // 만들어진 그룹이 N/2씩 나누어진 경우만 시너지의 차이를 구함
                if (g1.size() == N/2) {
	                int s1 = 0;
	                int s2 = 0;
	                // 각 그룹에 속해있는 모든 식재료들끼리의 시너지를 합하여 차이를 구함
	                for (int j = 0; j < g1.size(); j++) {
	                    for (int k = 0; k < g1.size(); k++) {
	                        s1 += board[g1.get(j)][g1.get(k)];
	                    }
	                }
	                for (int j = 0; j < g2.size(); j++) {
	                    for (int k = 0; k < g2.size(); k++) {
	                        s2 += board[g2.get(j)][g2.get(k)];
	                    }
	                }
	                int temp = Math.abs(s1-s2);
	                // 구한 차이가 gap보다 작으면 gap에 저장하며 최솟값을 저장
	                if (temp < gap) {
	                    gap = temp;
	                }
                }
            }
            
            // 테스트 케이스 번호와 차이의 최솟값 출력
            System.out.println("#" + t + " " + gap);
        }
    }
}