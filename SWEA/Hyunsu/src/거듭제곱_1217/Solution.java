package 거듭제곱_1217;
import java.util.Scanner;

/**
 * 재귀를 통한 거듭제곱 연산
 */

public class Solution {
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int n = sc.nextInt();
		//c의 n승을 구하고자 함.
		System.out.println(recurr(c, n));
		
	}

	private static int recurr(int c, int n) {
		//2의 5승
		
		if(n == 1) {
			return c; //2의 1승이 들어왔을 경우, c를반환
		}
		
		
		if(n %2 ==0) {
			int tmp = recurr(c, n/2); //2) 2의 1이 들어감 , tmp  2반환
			return tmp*tmp; //2*2
			
		}
		else {
			int tmp = recurr(c, n/2); //1) 2의 2승으로 들어감. // tmp = 4
			return tmp*tmp*c;
			
		}
	}
	
}