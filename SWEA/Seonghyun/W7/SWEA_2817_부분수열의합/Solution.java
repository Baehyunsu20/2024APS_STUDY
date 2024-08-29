package SWEA_2817_부분수열의합;

import java.util.Scanner;

public class Solution {

    static int tmp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        for (int tc = 1; tc <= T; tc++) {
            int noc = 0;        // 경우의 수
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] sel = new int[N]; // 해당 인덱스의 재료를 사용했는지의 유무를 저장하는 배열
            int[] num = new int [N]; 
            for (int i = 0; i < N; i++ ) {
                num[i] = sc.nextInt();
            }

		for (int i = 0; i < (1 << N); i++) {
			for(int j = 0 ; j<N; j++) {
				if((i & (1 << j)) > 0) {
					//해당 재료가 있어요~~
					tmp+=num[j];
                    if (tmp == K) {
                        noc++;
                    }
				}
			}//재료 확인 끝
			System.out.println(noc);
		}
	}
}

}