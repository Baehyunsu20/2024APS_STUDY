package Hyunsu;

import java.util.*;
import java.io.*;

public class 보물상자비밀번호 {
//	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("sample_input_보물상자.txt"));
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			ArrayList<Integer> numset = new ArrayList<>();
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			char[] line = new char[n];
			String one  = sc.next();
			for(int size=0; size<n; size++) {
				line[size] = one.charAt(size);
			}

			int time = n/4;

			//이 반복문을 통해 최대 총 3번의 턴을 통해 나올 수 있는 모든 경우의 수가 나와야함.
			
			for(int turn=0; turn<time; turn++) {
				
//				System.out.println("\n"+turn +"턴의 시작");
				//첫번째 턴에서는
				//시작점 : 0, 3, 6, 9 -> 4개의 시작점 , 4개의 16진수 숫자가 나옴.
				
				//두번째 턴에서는
				//시작점 : 1,4,7,10 (mode idx로 나눠줘야함.)
				
				//세번째 턴에서는
				//시작점 : 2,5,8,11 (mode idx로 나눠줘야함.)
				
				//총 4개의 변
				
				for(int b=0; b<4; b++) {
					//총 4개의 변을 스타트 포인트를 더해가며 숫자 확인
					//0번째 턴의 경우
					// 0 + 3*0 = 0, 0+ 3*1 = 3, 6, 9
//					System.out.println(b + "번째 변의 시작");
					int start = turn+(time*b);
					int num = 0;
					//3자리 수 = time 자리수
					int sq = time ;
					for(int idx = start; idx<start+time; idx++) {
						//한글자를 불러 왔을때
//						int sq = time -1;
						int cnum = 0;
						
						char c1 = line[idx%n];
//						System.out.println("idx : " + idx +" mode 처리 : "+ (idx%n));
						
						if( c1>='0' && c1<='9') {
							//숫자일때는
							cnum = c1-'0';
						}
						else if(c1=='A') {
							cnum = 10;
							
						}
						else if(c1=='B') {
							cnum = 11;
							
						}
						else if(c1=='C') {
							cnum = 12;
							
						}
						else if(c1=='D') {
							cnum = 13;
							
						}
						else if(c1=='E') {
							cnum = 14;
							
						}
						else if(c1=='F') {
							cnum = 15;
						}
						else {
							System.out.println("변형이 안된다.");
						}
//						System.out.println("b : "+b+" 16진수를 만들기 위한 cnum : "+ cnum);
						sq--;
						num += cnum * Math.pow(16, sq);
//						System.out.println("num "+ num+" sq : "+sq);
						

					}
					if(!(numset.contains(num))) {
						//요소가 없을 때 더해줌
						numset.add(num);
					}
					
				}
				
				
			}
			//중복이 없는 리스트 만듦.
			int[] ans = new int[numset.size()];
			
			
			//k번쨰 요소를 추출
			int iidx =0;
			for(int o:numset) {
				ans[iidx++] = o;
			}
			
			Arrays.sort(ans);
			int ansnum = ans[ans.length-k];
			
			System.out.println("#"+t+" "+ansnum);
			

		}
		
	}
	

}

