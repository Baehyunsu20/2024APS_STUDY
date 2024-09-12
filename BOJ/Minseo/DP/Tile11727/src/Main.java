import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[] dp = new long[N];
		if(N==1) {
			System.out.println(1);
		}else if(N==2) {
			System.out.println(3);
		}else if(N==3) {
			System.out.println(5);
		}else {
			dp[0]=1;
			dp[1]=3;
			dp[2]=5;
			for(int i=3;i<N;i++) {
				dp[i]=(dp[i-2]%10007*2+dp[i-1]%10007)%10007;
			}
		}
		System.out.println(dp[N-1]);
		
	}
}
