import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		
		long[] arr1 = new long[N];
		long[] arr2 = new long[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr1[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr2[i] = Long.parseLong(st.nextToken());
		}
		
		// 병합정렬.
		// 두 정렬 모두 sort하고 시작할 필요 X 이미 정렬되어 있으니까
		// idx=0부터 각각 N, M 전까지 각각 idx 비교해가면서 붙여서 정렬
		StringBuilder sb = new StringBuilder();
		
		int idx1=0, idx2=0;
		while(true) {
			if(idx1<N&&idx2<M&&arr1[idx1]<=arr2[idx2]) {
				sb.append(arr1[idx1]);
				idx1++;
			}else if(idx1<N&&idx2<M&&arr1[idx1]>arr2[idx2]){
				sb.append(arr2[idx2]);
				idx2++;
			}		
			sb.append(" ");				
			
			// 한쪽이 먼저 끝나면(idx 값이 N 또는 M을 벗어나면)
			// 나머지 인덱스가 끝날때까지 갖다 붙이기
			if(idx1>=N) {
				while(idx2<M) {
					sb.append(arr2[idx2]+" ");
					idx2++;
				}
				break;
			}else if(idx2>=M) {
				while(idx1<N) {
					sb.append(arr1[idx1]+" ");
					idx1++;
				}
				break;
			}
		}
		System.out.println(sb);
		
	}
}
