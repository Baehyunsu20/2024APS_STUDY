package SWEA_4613_러시아_국기_같은_깃발;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // T테스트
        for (int t = 1; t <= T; t++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            // 입력값 배열에 담기
            String[][] arr = new String[i][j];
            for (int r = 0; r < i; r++) {
                String a = sc.next();
                String[] arr2 = a.split("");
                for (int c = 0; c < j; c++) {
                    arr[r][c] = arr2[c];
                }
            }
     

            // 바꾸는 숫자 카운트 인데 //어차피 첫줄은 무조건 흰색 && 마지막 줄은 빨간색이니 기본 카운트 갑 정의해놓고 시작
            int cnt = 0;
            for (int x = 0; x < j; x++) { // 첫줄 not 흰칸 카운트
                if (!(arr[0][x].equals("W"))) {
                    cnt++;
                }
            }
         
            for (int y = 0; y < j; y++) { // 마지막줄 not 빨간칸 카운트
                if (!(arr[i - 1][y].equals("R"))) {
                    cnt++;
                }
            }

            // 최소값 구하기
            int min = Integer.MAX_VALUE;
            for (int whiteEnd = 0; whiteEnd < i - 2; whiteEnd++) { // 흰색 구간 끝나는 위치
                for (int blueEnd = whiteEnd + 1; blueEnd < i - 1; blueEnd++) { // 파란색 구간 끝나는 위치 (파란색 최소 1줄 확보)

                    int miniCount = 0;

                    // 흰색 구간 바꿔주기
                    for (int w = 1; w <= whiteEnd; w++) {
                        for (int c = 0; c < j; c++) {
                            if (!(arr[w][c].equals("W"))) {
                                miniCount++;
                            }
                        }
                    }
                  

                    // 파란색 구간 바꿔주기
                    for (int b = whiteEnd + 1; b <= blueEnd; b++) { // 최소 1줄이므로 <= 사용
                        for (int c = 0; c < j; c++) {
                            if (!(arr[b][c].equals("B"))) {
                                miniCount++;
                            }
                        }
                    }

                    // 빨간색 구간 바꿔주기
                    for (int r = blueEnd + 1; r < i - 1; r++) { // 빨간색 구간 시작은 bEnd 다음 줄부터
                        for (int c = 0; c < j; c++) {
                            if (!(arr[r][c].equals("R"))) {
                                miniCount++;
                            }
                        }
                    }

                    if (miniCount < min) {
                        min = miniCount;
                    }
                }
            }

            cnt += min;
            System.out.println("#" + t + " " + cnt);
        }
    }
}
