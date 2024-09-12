import java.util.Scanner;
// 풀이중
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[] dp = new long[N];
		dp[0]=9;
		for(int i=1;i<N;i++) {
			dp[i]=(dp[i-1]-1)*2+1;
		}
		
		long ans = dp[N-1]%1000000000;
		System.out.println(ans);
		
	}
}
