package Hyunsu;
import java.util.*;
import java.io.*;

/**
 * 순차적으로 자릿수가 같거나 증가하는 수 : 단조 증가하는 수
 * 주어진 값을 순차적으로 모두 곱해보고 단조 증가하는 수 중 최대를 찾기
 * 
 * 시간초과 뜸
 * 
 */

public class S6190_정곤이의단조증가하는수 {
//	static List<Integer> list = new ArrayList<>();
	static int max =0;
	static String tmp;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input_정곤이단조.txt"));
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			//초기화
//			int[] list 
//			list = new ArrayList<>();
			max =0;
			
			//입력 받기
			int n = sc.nextInt();
			int[] list = new int[n];
			for(int i=0; i<n; i++) {
				list[i] = sc.nextInt();
			}
			
			for(int i=0; i<n; i++) {
				for(int j=1; j<n; j++) {
					if(i != j) {
						//둘이 같지 않을 경우에만
						int mul = list[i] * list[j];
						//단조 증가하는 수인지 확인
						//valueof : 타입 변형해주는 매서드
						tmp = String.valueOf(mul);
						String[] tmp2 = tmp.split("");
						
						int[] tmpList = new int[tmp.length()];
						
						for(int l=0; l<tmp.length(); l++) {
							tmpList[l]=Integer.parseInt(tmp2[l]);
							
//							System.out.println(Arrays.toString(tmpList));
						}//한글자씩 쪼개서 배열의 요소로 저장. -> [1, 4]
						
						for(int k=1; k<tmpList.length; k++) {
							if(tmpList[k-1] > tmpList[k]) {
								break;
							}
							else {
								if(k== tmp.length()-1) {
									//마지막 인덱스까지 왔으면 단조 증가의 수가 맞음
									//최댓값 비교
									if(max <= mul) max=mul;

								}
							}
							
						}

					}
					
				}
			}
			System.out.println("#"+t+" "+max);
		}

	}

}
