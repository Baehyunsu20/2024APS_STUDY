package Bosung;

import java.util.Arrays;
import java.util.Scanner;

public class J1205_조커 {
	
	// 오름차순으로 정렬된 배열에서 0을 없애는 메소드
	static int[] xZero(int[] arrWithZero) {
		
		int countZero = 0;
		
		for (int i=0; i<arrWithZero.length; i++) {
			if (arrWithZero[i] == 0)
				countZero++;
			else break;
		}
		
		int arrExceptZero[] = new int[arrWithZero.length-countZero];
		
		for (int i=0; i<arrExceptZero.length; i++) {
			arrExceptZero[i] = arrWithZero[i+countZero];
		}
		
		return arrExceptZero;
	}
	
	// 메인 메소드
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] card = new int[N];
		
		// 첫 입력 카드 배열
		for (int i=0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		
		
		// 오름차순 정렬
		Arrays.sort(card);
		
		int countZero = 0;
		
		for (int i=0; i<card.length; i++) {
			if (card[i] == 0)
				countZero++;
			else break;
		}
		
//		System.out.println("0은 " + countZero + "개");
		
		// xZero 메소드를 사용해 정렬된 card 배열의 0을 빼버림
		int[] cardExceptZero = xZero(card);
		
//		System.out.print("cardExceptZero : ");
//		System.out.println(Arrays.toString(cardExceptZero));
		
		
		// 겹치는 숫자를 뺀 카드 배열 만들기 (배열을 복사한뒤 겹치는 숫자를 0으로 만들고 정렬하여 메소드를 통해 만듦)
		int cardExceptZero1[] = new int[cardExceptZero.length];
		
		// cardExceptZero1에 cardExceptZero 복사하기
		for (int i=0; i<cardExceptZero.length; i++) {
			cardExceptZero1[i] = cardExceptZero[i];
		}
		
		// cardExceptZero[i]와 cardExceptZero[i+1]의 값을 비교하여 같으면 하나를 0으로 만듦 (복사하고 한 이유는 i번째와 i+1번째, i+2번째가 모두 같을 때 i+2번째의 값도 0으로 만들기 위해)
		for (int i=0; i<cardExceptZero.length; i++) {
			for (int j=i+1; j<cardExceptZero.length; j++) {
				if (cardExceptZero[j] == cardExceptZero[i]) {
					cardExceptZero1[j] = 0;
				}
			}
		}
		
		// 정렬해서 0을 빼버리면 겹치지도 않고, 0도 없는 마음에 드는 realCard 배열 생성
		Arrays.sort(cardExceptZero1);
		
		int[] realCard = xZero(cardExceptZero1);
		
//		System.out.print("realCard : ");
//		System.out.println(Arrays.toString(realCard));
		
		// 최대 스트레이트 길이 maxStraight 만들기
		int maxStraight = 0;
		
		// 모든 카드가 0일 때
		if (realCard.length == 0) {
			maxStraight = countZero;
		}
		// 카드 숫자의 종류가 0과 다른 숫자 하나일 때 (3 0 3 0 0) 같은 경우
		else if (realCard.length == 1) {
			maxStraight = 1 + countZero;
		}
		// 다른 모든 일반적인 경우
		else {
			// realCard 배열의 사이사이에 0이 들어갈 수 있는 자리를 저장하기 위한 space 배열 만들기 (길이는 realCard.length-1)
			int[] space = new int[realCard.length-1];
			
			for (int i=0; i<space.length; i++) {
				space[i] = realCard[i+1] - realCard[i] - 1;
				// 겹치는 것을 제외하지 않았을 때 넣었던 코드 (이제는 필요없을 듯해서 주석)
//				if (space[i] == -1) {
//					space[i] = 0;
//				}
			}
			
//			System.out.print("space : ");
//			System.out.println(Arrays.toString(space));
			
			// i 인덱스에서 시작해서 0이 들어갈 수 있는 자리인 space의 합이 countZero를 넘지 않을 때까지 탐색하고 countZero를 넘어버리면 한칸 전의 j를 J 배열에 저장, 안 넘고 끝까지 탐색하면 그 때의 j를 J 배열에 저장
			// 이때 J 배열은 i마다 특정 j값을 저장하기 위한 배열임
			int[] spaceSum = new int[space.length];
			int[] straight = new int[space.length];
			
			for (int i=0; i<space.length; i++) {
				// i마다 space의 합 초기화
				spaceSum[i] = 0;
				int[] J = new int[space.length];
				// i부터 1씩 증가하며 space의 합 탐색
				for (int j=i; j<space.length; j++) {
					spaceSum[i] += space[j];
					// 합이 countZero를 넘어가면 그때의 j를 뺀 전의 j까지 세야하므로 J[i]에 j-1 저장
					if (spaceSum[i] > countZero) {
						J[i] = j-1;
						break;
					}
					// 합이 countZero를 안 넘어가면 그때까지의 j를 J[i]에 저장
					J[i] = j;
				}
				// 스트레이트의 길이는 (주어진 카드 중 0을 제외하고 사용된 개수) + (주어진 카드 사이에 사용된 0의 개수) + (남은 0의 개수) = (J[i] - i + 2) + (spaceSum[i]+a) + (countZero - (spaceSum[i]+a))
				straight[i] = J[i] - i + 2 + countZero;
			}
			
			// 얻은 stright[i] 중 최댓값 찾아서 maxStraight에 넣기
			for (int i=0; i<straight.length; i++) {
				if (straight[i] > maxStraight) {
					maxStraight = straight[i];
				}
			}
		}
		
		// 스트레이트 최대 길이 출력
		System.out.println(maxStraight);
		
	}
}
