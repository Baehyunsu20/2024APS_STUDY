package Hyunsu;
import java.util.*;
import java.io.*;

public class S1859_백만장자프로젝트 {
	
<<<<<<< HEAD
=======
	static double sum = 0;
	static double max = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input_백만장자.txt"));
		
		int T = sc.nextInt();
		for(int t=1; t<=10; t++) {
			
			int size = sc.nextInt();
			double[] list = new double[size];
			for(int i=0; i<size; i++) {
				list[i] = sc.nextInt();
			}
			
			sum = 0;
			max = list[size-1];
			
			//뒤에서부터
			for(int k = size-1; k>0; k--) {
				//최댓값
//				if(max<list[k])max=list[k];
				
				if(max > list[k-1]) {
					//최댓값보다 작을 때.
					sum += (max - list[k-1]);
//					System.out.println("sum : "+sum);
				}
				else if(max < list[k-1]) {
					max = list[k-1];
				}
			}
			
			System.out.println("#"+t+" " +  Math.round(sum));
		}
		
		
	}
>>>>>>> 0b2cc4079bd92976c6e2e2c7a69b331481ef5864

}
