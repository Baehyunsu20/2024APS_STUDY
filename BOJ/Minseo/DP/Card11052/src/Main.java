import java.util.Arrays;
import java.util.Scanner;
// 풀이중 - 완료 근데 이제 다시한번 이해해보기,,,
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] price = new int[N+1];
				
		for(int i=1;i<N+1;i++) {
			price[i]=sc.nextInt();
		}
		
		int[] dp = new int[N+1];
		dp[1]=price[1];
		
		for(int i=2;i<N+1;i++) {
			for(int j=1;j<=i;j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+price[j]);	
			}
		}
		
		System.out.println(dp[N]);
		
	}
}
