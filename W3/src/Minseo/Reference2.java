package Minseo;

import java.util.*;

public class Reference2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 숫자 배열 입력받기
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int n = 0; n < N; n++) {
            arr[n] = sc.nextInt();
        }
        
        // 0 개수 세기
        int zeroCnt = 0;
        for (int num : arr) {
            if (num == 0) zeroCnt++;
        }

        // 배열이 다 0일 때
        if(zeroCnt==arr.length){
            System.out.println(zeroCnt); return;
        }
        
        // 배열 정렬, 중복값 제거
        Arrays.sort(arr);
        arr = Arrays.stream(arr).distinct().toArray();
        
        // 연속 숫자 개수 세기
        int maxLen = 0, currentLen = 0, zeroLeft = zeroCnt;
        
        for (int i = 0; i < arr.length; i++) {
            
            currentLen = 1; // 현재 숫자 포함 초기 길이
            zeroLeft = zeroCnt;
            
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[j - 1] + 1) {
                    currentLen++;
                } else {
                    int gap = arr[j] - arr[j - 1] - 1;
                    if (gap <= zeroLeft) {
                        zeroLeft -= gap;
                        currentLen += gap + 1;
                    } else {
                        break;
                    }
                }
            }
            
            currentLen += zeroLeft; // 남은 조커 사용
            maxLen = Math.max(maxLen, currentLen);
        }
        
        System.out.println(maxLen);
    }
}
