package Hyunsu;
import java.util.*;
import java.io.*;

/**
 * 순차적으로 자릿수가 같거나 증가하는 수 : 단조 증가하는 수
 * 주어진 값을 순차적으로 모두 곱해보고 단조 증가하는 수 중 최대를 찾기
 * 
 * 시간초과 뜸 -> 어떤 방식으로 해결할까. -> 매서드로 분리하고, 단조 증가 수가 없을 경우는 -1
 * 
 */

public class S6190_정곤이의단조증가하는수 {
//	static List<Integer> list = new ArrayList<>();
	//단조가 증가 수가 없을 경우에는 -1이다....
	static int max =-1;
	static String tmp;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input_정곤이단조.txt"));
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			max =-1;
			//입력 받기
			int n = sc.nextInt();
			int[] list = new int[n];
			for(int i=0; i<n; i++) {
				list[i] = sc.nextInt();
			}
			
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
						int mul = list[i] * list[j];
						//단조 증가하는 수인지 확인 -> 매서드화 시키는 게 좋을듯

						if(!(check(mul))) {
							//해당 매서드가 true일때 -> 단조가 맞을 때 최댓값 갱신
							//false일 경우에는 다음 턴으로 넘어가야함
							
							continue;
						}
						else {
							//true일 경우.
							//최댓값 갱신.
							if(max < mul)max = mul;
							
						}

					}

					
				}System.out.println("#"+t+" "+max);
			}
			
		}

	private static boolean check(int mul) {
		//valueof : 타입 변형해주는 매서드
		String[] tmp = String.valueOf(mul).split("");

		for(int i=1; i<tmp.length; i++) {
			int pre = Integer.parseInt(tmp[i-1]);
			int t = Integer.parseInt(tmp[i]);
			if(pre >t) {
				return false;
			}
		}

		return true;
	}

	}


