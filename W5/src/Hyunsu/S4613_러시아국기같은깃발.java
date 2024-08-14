package Hyunsu;
import java.util.*;
//import java.io.*;

/**
 * 콩컴활 2급 코드 참고 : 아주 좋은 교보재!
 */


public class S4613_러시아국기같은깃발 {
  
    public static void main(String args[]) {
  
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
  
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] paint_number = new int[N][3];// 흰, 파, 빨
            int answer = Integer.MAX_VALUE;
  
            for (int i = 0; i < N; i++) {
                char[] input = sc.next().toCharArray();
                for (int j = 0; j < M; j++) {
                    if (input[j] == 'W')
                        paint_number[i][0]++;
                    if (input[j] == 'B')
                        paint_number[i][1]++;
                    if (input[j] == 'R')
                        paint_number[i][2]++;
                }
            }
//          System.out.println(paint_number[0][0]+ " "+paint_number[0][1]+ " "+paint_number[0][2]);
            int base = paint_number[0][1] + paint_number[0][2] + paint_number[N - 1][1] + paint_number[N - 1][0];
  
            // i+j+k=N
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    for (int k = 1; k < N - 1; k++) {
  
                        int temp = 0;
  
                        if (i + j + k == N) {
  
                            for (int a = 0; a < i; a++) { // 흰
                                temp = temp + paint_number[a][1] + paint_number[a][2];
                            }
  
                            for (int a = i; a < i + j; a++) { // 파
                                temp = temp + paint_number[a][0] + paint_number[a][2];
  
                            }
  
                            for (int a = i + j; a < N; a++) { // 빨
                                temp = temp + paint_number[a][0] + paint_number[a][1];
                            }
  
                            if (temp < answer) {
                                answer = temp;
                            }
  
                        }
                    }
                }
            }
  
            System.out.printf("#%d %d%n", test_case, answer);
        }
    }
}
