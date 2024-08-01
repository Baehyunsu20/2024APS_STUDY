package yoonjun;

import java.util.Scanner;

public class millionaire {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
				int N = sc.nextInt();
				int[] price = new int[N];
				int max = 0;
				long total =0;
				
				for(int i = 0; i < N; i++){
				 price[i] = sc.nextInt();
				}
				for(int i = N -1; i >= 0; i--) {
					if(max < price[i]) {
						max = price[i];
					}
						else if(max > price[i]) {
						total = total +	max - price[i];
						}
					}
				System.out.println("#" + t + " "+total);
	}
		sc.close();
	}
	}

