import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N=sc.nextInt();
			
			// 중복조합 1*x+2*y+3*z = N
			int cnt=0;
			for(int z=N/3;z>=0;z--) {
				int M = N-3*z;
				for(int y=M/2;y>=0;y--) {
					int x = M-2*y;
					int F = x+y+z;
					cnt+=(fact(F)/(fact(x)*fact(y)*fact(z)));
				}
			}
			
			System.out.println(cnt);
				
		}
				
	}
	static int fact(int i) {
		if(i==1||i==0) {
			return 1;
		}
		return i*fact(i-1);
	}

}
