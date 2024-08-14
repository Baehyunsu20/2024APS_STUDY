package Hyunsu;


import java.util.Arrays;
import java.util.Scanner;
 
public class S1860_진기의최고급붕어빵 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
 
            int[] client = new int[N];
 
            for (int i = 0; i < N; i++) {
                client[i] = sc.nextInt();
            }
 
            Arrays.sort(client);
 
            String answer = "Possible";
 
            for (int i = 0; i < N; i++) {
                int time = client[i];
                // time / M : 지금까지 붕어빵 만드는 사이클 몇 번 돌았는가?
                // (time / M) * K : 지금까지 만들어진 붕어빵 개수
                if ((time / M) * K < i + 1) {
                    answer = "Impossible";
                }
            }
 
            System.out.println("#" + test_case + " " + answer);
 
        }
    }
 
}
