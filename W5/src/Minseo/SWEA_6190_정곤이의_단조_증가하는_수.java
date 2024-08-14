package Minseo;
import java.util.Scanner;

public class SWEA_6190_정곤이의_단조_증가하는_수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int n=0; n<N; n++) {
				arr[n] = sc.nextInt();            
			}
			
			int max = -1;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++){
					int product = arr[i] * arr[j];
					if (isDanjo(product)) {
						max = Math.max(max, product);
					}
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n", t, max);
		}
	}
	
	private static boolean isDanjo(int num) {
		int previousDigit = 10; // 모든 숫자는 0-9이므로 초기값을 10으로 설정
		while (num > 0) {
			int currentDigit = num % 10;
			if (currentDigit > previousDigit) {
				return false;
			}
			previousDigit = currentDigit;
			num /= 10;
		}
		return true;
	}
	

}
