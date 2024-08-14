package Hyunsu;
import java.util.*;

/**
 * 가로 세로를 확인했을때 가장 긴 회문의 길이를 구함.
 * 스택에 넣고 빼기를 반복하면서
 * 넣어졌다가 다 빠지는 경우가 있다면, 그 스택의 최대 (top+1)*2-1 = 
 * 1개가 들어왔었다면 top=0 : (0+1)*2-1= 1 : 문자열의 길이 = max 갱신하는 방식
 * 
 * 
 * C B C 'A' C B C 
 * 인덱스 4의 C가 들어왔을때 TOP-2와 같다면  중간에 있는 A를 pop시키고(이때의 스택 사이즈 = tmp), C도 pop -> 그후 들어오는 값이 top와 같은 경우 pop
 * 스택이 비게 되면 회문 최대값 max =tmp;
 *
 *top과 들어오는 값이 같을 때는 pop(pop하기전에 size 기록)
 *				  다를 때는 top pop하고, 들어오는 값이 다음 top과 같을 때를 비교
 * 
 * 
 *  C B C 'A' 'A' C B C 
 *  
 *  C B C 'A' 'B' C B C 
 * 
 */
public class 회문2 {
	//스택사용
	static Stack<Character> stack = new Stack<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//총 10개의 테스트케이스
		for(int t=1; t<=1;t++) {
			int max = 1;
			//100바이100, ,일단 입력 받아두기
			int tc = sc.nextInt();
			char[][] arr = new char[100][100];
			for(int i=0; i<100; i++) {
				
				String lineTmp = sc.next();
//				System.out.println(i+"줄 "+lineTmp);
				for(int j=0; j<100; j++) {
					//한글자씩 char로 넣기
					arr[i][j] = lineTmp.charAt(j);
//					System.out.println("한글자씩 : "+arr[i][j]); // 한글자씩 들어오는거 확인
				}
			}// 2차원 배열 완성.
			//이제 순회를 통해 stack으로 가장 긴 회문 탐색
			
			//1. 가로 탐색
			//왼쪽 끝=i, 오른끝 인덱스 = j
			for(int row=0; row<100;row++) {
				
				for(int i=0; i<99; i++) {
					for(int j=1; j<100; j++) {
						//각 줄마다 stack 초기화
						//0-1 /0-2/ 0-3 / 0-4/ ...98-99번 인덱스까지 확인
						//i인덱스부터 j인덱스까지 스택 pop, push
						for(int k=i; k<=j; k++) {
							//i부터 j까지 확인
							//0부터 인덱스 4까지라면 : 5개의 문자 3번째 문자까지는 검사 -> 인덱스 2까지는 가야함.
							//0부터 인덱스 5까지라면 : 6개의 문자 3번째 문자 -> 인덱스 2까지는 가야함. -> 버림해도 괜찮
							for(int n=0; n<=(j-i)/2;n++) {
								int left =i;
								int right =i;
								if(arr[row][left++]!=arr[row][right--]) {
									//같지 않으면 
									break;//0-4에서 안맞으면 0-5로 넘어감
								}
								if(n==(j-i)/2) {
									//마지막까지 갔다면
									//최댓값 갱신
									if(max<j-i+1)max=j-i+1;
									
									
									
								}
								
							}
							
						}
						
						
						
					}
				}
				
			}
			
			
			//2. 세로 탐색
			//왼쪽 끝=i, 오른끝 인덱스 = j
			for(int row=0; row<100;row++) {
				
				for(int i=0; i<99; i++) {
					for(int j=1; j<100; j++) {
						//각 줄마다 stack 초기화
						//0-1 /0-2/ 0-3 / 0-4/ ...98-99번 인덱스까지 확인
						//i인덱스부터 j인덱스까지 스택 pop, push
						for(int k=i; k<=j; k++) {
							//i부터 j까지 확인
							//0부터 인덱스 4까지라면 : 5개의 문자 3번째 문자까지는 검사 -> 인덱스 2까지는 가야함.
							//0부터 인덱스 5까지라면 : 6개의 문자 3번째 문자 -> 인덱스 2까지는 가야함. -> 버림해도 괜찮
							for(int n=0; n<=(j-i)/2;n++) {
								int left =i;
								int right =i;
								if(arr[left++][row]!=arr[right--][row]) {
									//같지 않으면 
									break;//0-4에서 안맞으면 0-5로 넘어감
								}
								if(n==(j-i)/2) {
									//마지막까지 갔다면
									//최댓값 갱신
									if(max<j-i+1)max=j-i+1;
									
									
									
								}
								
							}
							
						}
						
						
						
					}
				}
				
			}
			System.out.println("#"+tc+" "+max);

			
		}
		
		
	}
	
	
 	

}
