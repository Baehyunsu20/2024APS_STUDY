import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;



public class Cook {

	public static int[] twoDto1D (int[][] food) {			// 2차원을 1차원 배열로 압축하는 메소드
        return Arrays.stream(food)
                     .flatMapToInt(Arrays::stream)
                     .toArray();
    }
	
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();							// 배열 규모 지정
//		int[][] ing = new int[N][N];					// 재료의 배열
//		int[][] food = new int[N][N];					// 요리 맛의 배열
//		
//		ArrayList<Integer> foods = new ArrayList<>();
//		for(int i = 0; i<ing.length; i++) {				// 재료 속성 입력
//			for(int j = 0; j < ing[i].length; j++) {
//				ing[i][j] = sc.nextInt();
//				foods.add(ing[i][j]+ing[j][i]);
//				food[i][j]=ing[i][j]+ing[j][i];
//			}
//		}
//		
//        int[] food1D = twoDto1D(food);				// 우리가 다뤄야할 음식의 1차원 배열
//        Collections.sort(food);						// 쉬운 계산을 위한 오름차순 정렬
//        int minsub[] = new int[food1D.length - 1];
//        for (int i = 0; i < food1D.length - 1; i++) {		// 두 인덱스끼리 묶어서 최소값 구하기
//        	int diff = sums.get(i+1) - sums.get(i);
//        	if (diff < minsub) {
//        		minsub sub[i] = food1D[i+1]-food1D[i] ;
//        }
//        Arrays.sort(sub);							// 최소값을 위한 오름차순 정렬
//        System.out.println(sub[0]);					// 최소값
//    }
}
		// 아니 답이 안나오길래 뭔가 해서 검색했더니 예시는 2개재료인데 실제론 n개도 가능하다캄;;
		
		
		
//		int newfood = Arrays.stream(food).distinct().toArray();

}
