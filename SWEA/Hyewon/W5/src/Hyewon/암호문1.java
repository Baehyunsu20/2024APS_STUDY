package SWEA_1228_암호문1;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++)
		{
		    int N = sc.nextInt();
		    LinkedList<String> list = new LinkedList<>();
		    for(int i=0; i<N; i++){
		        list.add(sc.next());
		    }
		    int M = sc.nextInt();
		    for(int i=0; i<M; i++){
		        String open = sc.next();
		        if(open.equals("I")){
		            int p = sc.nextInt();
		            int n = sc.nextInt();
		            for(int j=0; j<n; j++){
		                String num = sc.next();
		                list.add(p + j, num);
		            }
		        }
		    }
		    System.out.print("#" + tc);
		    for(int i=0; i<10 && i<list.size(); i++){
		        System.out.print(" " + list.get(i));
		    }
		    System.out.println();
		}
	}
}

// 배열 버전
// import java.util.Scanner;

// class Solution {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);

//         for (int test_case = 1; test_case <= 10; test_case++) {
//             int N = sc.nextInt();  // 원본 암호문의 길이
//             String[] arr = new String[100];  // 최대 크기를 넉넉하게 설정 (암호문 길이 + 삽입 가능 수 대비)
//             int currentLength = N;

//             // 초기 암호문 입력
//             for (int i = 0; i < N; i++) {
//                 arr[i] = sc.next();
//             }

//             int M = sc.nextInt();  // 명령어의 개수
//             for (int i = 0; i < M; i++) {
//                 String command = sc.next();
//                 if (command.equals("I")) {
//                     int p = sc.nextInt();  // 삽입할 위치
//                     int n = sc.nextInt();  // 삽입할 숫자의 개수

//                     // 삽입 위치 이후의 요소들을 오른쪽으로 이동
//                     for (int j = currentLength - 1; j >= p; j--) {
//                         arr[j + n] = arr[j];
//                     }

//                     // 새로운 숫자들 삽입
//                     for (int j = 0; j < n; j++) {
//                         arr[p + j] = sc.next();
//                     }

//                     // 현재 길이 업데이트
//                     currentLength += n;
//                 }
//             }

//             // 결과 출력 (앞에서 10개의 숫자 출력)
//             System.out.print("#" + test_case);
//             for (int i = 0; i < 10 && i < currentLength; i++) {
//                 System.out.print(" " + arr[i]);
//             }
//             System.out.println();
//         }
//     }
// }

