import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
//		long[] dp = new long[N+1];
//		
//		long sum=0;
//		for(int i=1;i<=10;i++) {
//			sum+=Math.pow(i, N-1);
//		}
		
		long sum=0;
		if(N==1) {
			System.out.println(10);
		}else if(N>=2) {
			sum = (long) (6*Math.pow(2, N-1)+Math.pow(2, N-2)+2+2);
		}
		
		sum = (long) (sum%Math.pow(10, 9));
		System.out.println(sum);
		
	}
}




//// 런타임 에러
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		// nHr
//		// 0~9까지의 10개의 수 중 r개 중복조합
//		int N = sc.nextInt();
//		
//		long ans=0;
//		for(int i=0;i<=9;i++) {
//			ans += fact((N-i+8)%10007)/(fact(9-i)*fact(N-1));// (9-i)H(N-1)
//		}
//		
//		System.out.println(ans);
//		
//	}
//	static long fact(int i) {
//		if(i==1||i==0) {
//			return 1;
//		}
//		return i*fact(i-1);
//	}
//
//}
