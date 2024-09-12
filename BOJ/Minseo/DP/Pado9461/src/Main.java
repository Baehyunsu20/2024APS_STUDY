import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			
			if(N<=2) {
				int[] P = {1,1,1};
				System.out.println(P[N-1]);
			}else {
				long[] P = new long[N];
				P[0]=1;
				P[1]=1;
				P[2]=1;
				
				for(int i=3;i<N;i++) {
					P[i] = P[i-2]+P[i-3];
				}
				System.out.println(P[N-1]);
			}
		}
		
	}

}
