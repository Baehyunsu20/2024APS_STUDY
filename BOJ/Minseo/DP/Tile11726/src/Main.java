import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
				
		if(N==1) {
			System.out.println(1);
			return;
		}else if(N==2) {
			System.out.println(2);
			return;
		}else {
			long[] dp = new long[N];
			dp[0]=1;
			dp[1]=2;
			for(int i=2;i<N;i++) {
				dp[i]=dp[i-1]%10007+dp[i-2]%10007;
			}
			System.out.println(dp[N-1]%10007);
			return;
		}
	}
}
