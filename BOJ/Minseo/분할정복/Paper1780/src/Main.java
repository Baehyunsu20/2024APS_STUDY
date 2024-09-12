import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] paper;
	
	static int[] cnt = new int[3];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		paper = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				paper[i][j]=sc.nextInt();
			}
		}
		
		// 종이의 모서리 값에서 시작
		// 행/열을 돌면서 다른 값이 있다면 -> break하고 종이 자르기(한변의 길이를 N/3으로)
		// N/3 -> 1이되면 종료
		check(0,0,N);
		
		for(int i=0;i<3;i++) {
			System.out.println(cnt[i]);			
		}
		
		
	}
	static void check(int i, int j, int len) {
		// 시작점이 i, j, 한 변 길이가 len
		boolean isTrue = true;
		for(int r=i;r<i+len;r++) {
			for(int c=j;c<j+len;c++) {
				// 다 돌면서 true 확인
				if(paper[r][c]!=paper[i][j]) isTrue = false;
			}
		}
		// true면 cnt값 업데이트
		if(isTrue) {
			cnt[paper[i][j]+1]++;
		}else {
			// 한변 길이 재설정
			int newlen = len/3;
			for(int r=i;r<i+len;r+=newlen) {
				for(int c=j;c<j+len;c+=newlen) {
					check(r,c,newlen);
				}
			}
		}
	}	
}

//9
//0 1 -1 0 1 -1 0 1 -1
//0 -1 1 0 1 -1 0 1 -1
//0 1 -1 1 0 -1 0 1 -1
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
