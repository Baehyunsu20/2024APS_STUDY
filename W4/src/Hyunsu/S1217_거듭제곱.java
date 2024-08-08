package Hyunsu;
import java.util.Scanner;

public class S1217_거듭제곱 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		for(int t=1; t<=10; t++) {
			int T = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int result = fac(n,m);
			System.out.println("#"+t+" "+result);
	
		}
	}
	static int fac(int n, int m) {
		//기저조건 설정
		if(m == 0) {
			return 1;
		}
		
		return n*fac(n, m-1);
	}

}