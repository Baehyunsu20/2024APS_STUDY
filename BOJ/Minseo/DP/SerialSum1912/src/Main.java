import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		long[] dp = new long[N];
		dp[0]=arr[0];
		long max=dp[0];
		for(int i=1;i<N;i++) {
			if(dp[i-1]+arr[i]<arr[i]) {
				dp[i]=arr[i];
			}else {
				dp[i]=dp[i-1]+arr[i];
			}
		}
		for(int i=0;i<N;i++) {
			max = Math.max(max, dp[i]);			
		}
		
		System.out.println(max);
	}
}
