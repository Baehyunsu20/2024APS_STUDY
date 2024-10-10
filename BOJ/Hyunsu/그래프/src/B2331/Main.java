package B2331;

import java.util.*;

/**
 * 반복 수열(실버4)
 * 
 * 
 [57, 74, 65, 61, (37, 58, 89, 145, 42, 20, 4, 16,) (37, ~]
 
- 반복되는 부분
(37, 58, 89, 145, 42, 20, 4, 16) -> 뒤에서 계속 반복되는 부분을 제외
57, 74, 65, 61 -> 남은 것들의 갯수.

"방법: 싸이클을 찾는 그래프 탐색문제(DFS)" 
- 수열에 다음 숫자를 추가(재귀 이용)할 때 앞서 나온 숫자가 있다면 그 위치 인덱스를 반환 = 답
 [57, 74, 65, 61, ("37", 58, 89, 145, 42, 20, 4, 16,) (37, ~]
 -> 반복의 시작점인 "37" 의 인덱스 =4 ; 그 전까지의 숫자의 갯수.

문제 : 중복되는 부분 수열 안의 동일한 숫자가 있는 경우를 고려해주지 못함. 이 부분은 더 생각해봐야할듯.



 */

public class Main {
	// sequence의 각 숫자(노드)와 그 숫자가 "처음" 등장한 인덱스를 저장하는 해시맵
	// visited(숫자, 숫자의 첫 인덱스)
    static Map<Integer, Integer> visited = new HashMap<>();
    // sequence = 수열
    static List<Integer> sequence = new ArrayList<>();
    static int A, P;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        P = scanner.nextInt();
        
        // 시작 노드 탐색 : A라는 입력 받은 숫자를 index = 0으로 하여 넘김.
        dfs(A, 0);
    }
    
    private static void dfs(int current, int index) {
        // 이미 방문한 노드라면, 사이클의 시작점 발견
    	
    	// 앞에서 이미 나왔던 숫자인 경우.
        if (visited.containsKey(current)) {
            int cycleStartIndex = visited.get(current);
//            System.out.println("시작점 : "+cycleStartIndex);
            //반복되는 부분 수열의 시작 인덱스 = 반복이 나오기 전의 남은 수열의 갯수
            System.out.println(cycleStartIndex);
            return;
        }
        
        // 입력받은 숫자를 수열과 방문체크에 입력.
        visited.put(current, index);
        sequence.add(current);
        
        // 다음 노드 탐색
        int next = getNext(current); //현재 숫자를 쪼개서 p승으로 처리해서 더하는 메서드
        dfs(next, index + 1); //현재 숫자를 쪼개서 만든 새로운 숫자 next를 새롭게 만듬.
    }
    
    private static int getNext(int number) {
        int sum = 0;
        //따로 String을 통해 각 자리를 쪼개지 않는 방식.
        while (number > 0) {
        	//예시 145 _> (digit :5 num:14) -> (digit :4 num:1) -> (digit :1 num:0)
            //5, 4, 1 -> 이렇게 순서대로 쪼개짐.
        	int digit = number % 10; //57%10 = 7
//            System.out.println("나머지 : " + digit);
            sum += Math.pow(digit, P);
            number /= 10; //몫을 남겨서 while문을 반복
//            System.out.println("몫 : " + number);
        }
        return sum;
    }
}

