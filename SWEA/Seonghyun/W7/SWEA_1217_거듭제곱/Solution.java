    package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int [1000000];
        
        for(int n = 0; n < 1000000; n++) {
            arr[i] = sc.nextInt();
        }
            System.out.println("#" + tc + " " + pow(N, M));
        }
    
    }
    
    static int pow(int C, int N) {
        if ( N == 1) return C;
        if ( N % 2 == 0) {
            int temp = pow(C, N/2);
            return temp * temp;
        } else {
            int temp = pow(C, (N-1)/2);
               return temp * temp * C;
        }
    }
}