package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
	int test_num = sc.nextInt();
	int base = sc.nextInt();
	int index = sc.nextInt();
	int result = power(base, index);
	System.out.println("#" + test_num + " " + result);
		}
		sc.close();
		}

	
	
	
	static int power(int base, int index) {
		if (base == 0 || base == 1)	{				// 기저 조건
			return base; }
		else if (index == 0) {
			return 1;
		} else {
		return base * power(base, index - 1);
		}
	}
}
//	int mPowerResult = mPower(10);
//	System.out.println(mPowerResult);
//	}
//	static int[] dp = new int[500];
//	static {
//		dp[1] = 1;								
//	}
	
//	static int mPower(int N) {					
//		if ( N <= 1)
//			return 2;
//		if (dp[N] > 0)
//			return dp[N];
//		return dp[N] = mPower(N-1) * mPower(N-2);
//	}
// 메모이제이션 임시 폐기