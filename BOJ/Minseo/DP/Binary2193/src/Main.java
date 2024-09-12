import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[] dp = new long[N];
		if(N<=2) {
			System.out.println(1);
			return;
		}else {
			dp[0]=1;
			dp[1]=1;
			dp[2]=2;
			
			for(int i=3;i<N;i++) {
				dp[i] = dp[i-1]+dp[i-2];
			}
			
			System.out.println(dp[N-1]);
		}	
		
	}
}
