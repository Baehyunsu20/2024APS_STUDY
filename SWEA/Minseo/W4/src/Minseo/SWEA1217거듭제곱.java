package Minseo;
import java.util.Scanner;

public class SWEA1217거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		for(int t=1;t<=10;t++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
				
			System.out.println("#"+T+" "+func(N,M));
		}
	}
				
	public static int func(int n, int m) {
		if(m==1) {
			return n;
		}
		return n * func(n,m-1);
	}
}
			
		
