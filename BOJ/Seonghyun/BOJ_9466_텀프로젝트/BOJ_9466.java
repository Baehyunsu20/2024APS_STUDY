
import java.io.IOException;
import java.util.Scanner;


public class BOJ_9466 {
    
    static int T, n, postNN;
    static int[] arr;
    static boolean[] visited, comp;    // 방문, 편성 완료 체크 배열
    static int cnt;    // 팀이 완성된 인원 수
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        T = sc.nextInt();                   // 테케 입력
        
        for(int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();               // 학생 수 입력
            arr = new int [n+1];            // 학생 번호 배열 초기화
            for(int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();      // 학생 번호 배열 입력
            }
            visited = new boolean[n+1];     // 방문체크 배열도 초기화
            comp = new boolean[n+1];        // 편성 완료 체크 배열도 초기화
            cnt = 0;                        // 편성된 학생 수 초기화

            for(int i=1; i<= n; i++){
                if(!comp[i]){
                    dfs(i);                 // 모든 학생에 대해서 dfs 시전
                }
            }
            System.out.println( n - cnt);   // 결과

        }
    }
    
    public static void dfs(int NN) {
        if(visited[NN]){              // 방문처리를 해버렸다?
            comp[NN] = true;          // 팀 편성 -완-
            cnt++;                    // 완료 인원 증가
        }else{                        // 방문처리를 하지 않았다?
            visited[NN] = true;       // 방문처리!
        }
        
        postNN = arr[NN];             // 지목받은 대상 고려해야지?
        // 다음 학생이 팀 결성을 아직 못했을 경우
        if(!comp[arr[postNN]]){       // n-1번째 학생이 아직 조에 못들어갔으면
            dfs(arr[postNN]);         // 이녀석으로 dfs
        }
        visited[NN] = false;          // 백트래킹인데 의례적으로 넣으려다 미로도 아니고 뺑뺑이라서 빼도 될거같아서 빼보니 큰 차이 없이 됨. 
        comp[NN] = true;              // 끗
    }
}