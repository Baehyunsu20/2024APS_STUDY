import java.util.Scanner;

public class Main {
	
	static int ans=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		
		cal(X,0);
		
		System.out.println(ans);
		
	}
	static void cal(int X, int cnt) {
		if(cnt>ans) { // 시간 제한 맞추기 위해 cnt가 ans보다 커지는 경우는 아예 제외
			return;
		}
		if(X==1) {
			ans = Math.min(ans, cnt);
			return;
		}
		if(X%3==0) {
			cal(X/3,cnt+1);
		}
		if(X%2==0) {
			cal(X/2,cnt+1);
		}
		cal(X-1,cnt+1);
	}
	
	// 엥 이게되네
	
}
