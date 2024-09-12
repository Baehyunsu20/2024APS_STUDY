import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] glass = new long[N];
		
		for(int i=0;i<N;i++) {
			glass[i] = sc.nextLong();
		}
		
		if(N==1) {
			System.out.println(glass[0]);
		}else if(N==2) {
			System.out.println(glass[0]+glass[1]);
		}else {
			long[] dp = new long[N];
			dp[0] = glass[0];
			dp[1] = glass[0]+glass[1]; 
			dp[2] = Math.max(Math.max(glass[0]+glass[2],glass[1]+glass[2]),dp[1]);
			for(int i=3;i<N;i++) {
				dp[i]=Math.max(dp[i-2],dp[i-3]+glass[i-1])+glass[i];
				dp[i]=Math.max(dp[i], dp[i-1]);
			}
			System.out.println(dp[N-1]);
		}
	}
}
