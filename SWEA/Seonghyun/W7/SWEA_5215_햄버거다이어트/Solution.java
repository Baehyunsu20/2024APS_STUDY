import java.util.Scanner;

public class Solution {
    static int[] score, calorie;
    static int N, L;
    static boolean[] sel;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();                   // 테스트 케이스 수

        for (int test_case = 1; test_case <= T; test_case++) {
            
            N = sc.nextInt();                   // 재료 수
            L = sc.nextInt();                   // 제한 칼로리
            score = new int[N];                 // 맛점수에 대한 배열 초기화
            calorie = new int[N];               // 칼로리에 대한 배열 초기화
            sel = new boolean[N];               // 선택!
            max = 0;                            // 역대급 맛조합 갱신

            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();        // 맛점수 배열 입력
                calorie[i] = sc.nextInt();      // 해당 칼로리 배열 입력
            }

            powerset(0);                    // 부분집합 스타트

            System.out.println("#" + test_case + " " + max);
        }
        sc.close();
    }

    public static void powerset(int idx) {    // 부분집합
        if (idx == N) {
            int totS = 0;                     // 점수총합 초기화
            int totC = 0;                     // 칼로리총합 초기화

            for (int i = 0; i < N; i++) {
                if (sel[i]) {                 // 기저조건
                    totS += score[i];         // 점수 누적
                    totC += calorie[i];       // 칼로리 누적
                }
            }

            if (totC <= L) {
                max = Math.max(max, totS);    // 역대급 맛인지 체크
            }
            return;
        }

        // 재귀 파트
        sel[idx] = true;                    // 재료 택
        powerset(idx + 1);

        sel[idx] = false;                   // 재료 Not 택
        powerset(idx + 1);
    }
}
