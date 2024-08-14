package Test0809;
import java.util.*;

public class 활주로건설 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t=1; t<=1; t++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}//입력완료

			
			//활주로 경우의 수
			//활주로는 한줄 전체가 되어야함.
			boolean no = true;
			int sum = 0;
			
			//1. -> 방향으로 확인. 
			for(int r=0; r<n; r++) {
				//그 뒤의 값과 비교해야하니까 n-1해줌
				for(int c=0;c<n-1;c++) {
					//비교할 앞의 값
					int front = arr[r][c];
					//비교할 뒤의 값
					int back = arr[r][c+1];
					//둘 값의 차이를 긹
					int diff = Math.abs(front-back);
					
					//1. 같을 경우 -> 다음의 front와 back을 비교
					if(diff ==0) {
						continue; // 다음의 c+1과 c+2를 비교하러 감
					}
					//둘의 차이가 1보다 클 경우 -> 가능성이 없기에 다른 줄로 이동
					else if(diff>1) {
						break;
					}
					//둘의 차이가 1일때는 이제 경사로가 되는지 확인
					else if(diff==1) {
						//0부터 x-1까지 확인
						//만약 x=2면 back과 그 다음것만 비교 ;  1번만 비교 (x-1)번만 비교
						//1,
						for(int check=1; check< x; check++) {
							//x의 길이만큼 같지 않다면 -> 활주로 못함 다음  r+1 행으로 이동
							
							//인덱스 안의 값
							if((c+1+check)<n & (c+1+check)>=0) {
								
								if(back!=arr[r][c+1+check]) {
									System.out.println("r,c : "+r+", "+c +" 차이로 경사로를 못 지어요");
									no = false;
									break;
								}
								
								if(check==x-1) {
									//마지막까지 경사로 확인을 했다면. 이제 다음 c+1, c+2로 넘어감.
									break; 
									
								}
								
							}
							else {
								//인덱스 아웃으로 경사로를 짓지 못함
								System.out.println("인덱스 아웃으로 경사로를 못 지어요");
								no = false;
								break;
								
							}
							
						}

					}
					else {
						System.out.println("diff의 값이 예상을 벗어납니다.");
					}
					
					//경사로를 짓지 못할 때. 경사로 길이를 충족하지못하는 상황.
					if(no==false) {
						//다음 r+1로 넘어감
						break;
					}
					
					
					
					//끝까지 완주했다면
					if(c==n-2) {
						sum++;
						System.out.println("활주로 생성이 가능합니다.");
					}
					
					
					
				}

			}

			//1. 세로 방향으로 확인. 
			for(int r=0; r<n; r++) {
				//그 뒤의 값과 비교해야하니까 n-1해줌
				for(int c=0;c<n-1;c++) {
					//비교할 앞의 값
					int front = arr[c][r];
					//비교할 뒤의 값
					int back = arr[c+1][r];
					//둘 값의 차이를 긹
					int diff = Math.abs(front-back);
					
					//1. 같을 경우 -> 다음의 front와 back을 비교
					if(diff ==0) {
						continue; // 다음의 c+1과 c+2를 비교하러 감
					}
					//둘의 차이가 1보다 클 경우 -> 가능성이 없기에 다른 줄로 이동
					else if(diff>1) {
						break;
					}
					//둘의 차이가 1일때는 이제 경사로가 되는지 확인
					else if(diff==1) {
						//0부터 x-1까지 확인
						//만약 x=2면 back과 그 다음것만 비교 ;  1번만 비교 (x-1)번만 비교
						//1,
						for(int check=1; check< x; check++) {
							//x의 길이만큼 같지 않다면 -> 활주로 못함 다음  r+1 행으로 이동
							//인덱스 안의 값
							if((c+1+check)<n & (c+1+check)>=0) {
								
								if(back!=arr[c+1+check][r]) {
									System.out.println("차이로 경사로를 못 지어요");
									no = false;
									break;
								}
								if(check==x-1) {
									//마지막까지 경사로 확인을 했다면. 이제 다음 c+1, c+2로 넘어감.
//									sum++;
									break;
								}
								
							}
							else {
								//인덱스 아웃으로 경사로를 짓지 못함
								System.out.println("인덱스 아웃으로 경사로를 못 지어요");
								no = false;
								break;
								
							}
							
						}

					}
					else {
						System.out.println("diff의 값이 예상을 벗어납니다.");
					}
					
					//경사로를 짓지 못할 때. 경사로 길이를 충족하지못하는 상황.
					if(no==false) {
						//다음 r+1로 넘어감
						break;
					}
					
					if(c==n-2) {
						//끝까지 완주했다면
						sum++;
						System.out.println("활주로 생성이 가능합니다.");
					}

				}

			}
			System.out.println("#"+t+" "+sum);

		}
	}
	

}
