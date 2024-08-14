package Minseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_러시아_국기_같은_깃발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            char[][] arr = new char[N][M];
            for(int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }
            
            int min = Integer.MAX_VALUE;
            
            // 첫번째 색상은 무조건 W, 마지막은 무조건 R이므로 중간만 조절
            for (int i = 1; i < N - 1; i++) { // W가 끝나는 지점
                for (int j = i + 1; j < N; j++) { // B가 끝나는 지점
                    int changes = 0;
                    
                    // W 영역
                    for (int r = 0; r < i; r++) {
                        for (int c = 0; c < M; c++) {
                            if (arr[r][c] != 'W') changes++;
                        }
                    }
                    
                    // B 영역
                    for (int r = i; r < j; r++) {
                        for (int c = 0; c < M; c++) {
                            if (arr[r][c] != 'B') changes++;
                        }
                    }
                    
                    // R 영역
                    for (int r = j; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            if (arr[r][c] != 'R') changes++;
                        }
                    }
                    
                    min = Math.min(min, changes);
                }
            }
            
            System.out.printf("#%d %d\n", t, min);
        }
    }
}
