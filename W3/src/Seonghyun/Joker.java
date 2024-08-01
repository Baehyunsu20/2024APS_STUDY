import java.util.*;

public class Joker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드의 갯수
        int[] deck = new int[N]; // 카드의 구성
        
        for(int i = 0; i < N; i++) {
            deck[i] = sc.nextInt();
        }
        
        int maxL = jokerMaximumpush(deck);
        System.out.println(maxL);
    }

    public static int jokerMaximumpush (int [] deck) {
        Arrays.sort(deck); // 오름차순 정렬
        int jcount = 0; // 조커 초기화
        List<Integer> cards = new ArrayList<>(); // 중복 제거한 덱

        for (int card : deck) { // 향상된 for문을 통한 조커 카운트
            if (card == 0) {
                jcount++; // 0이면 조커행
            } else if (cards.isEmpty() || card != cards.get(cards.size() - 1)) {
                cards.add(card); // 중복 제거하며 카드 추가
            }
        }

        if (cards.isEmpty()) return deck.length; // 패가 조커뿐이면 전체 길이 반환

        int[] diff = new int[cards.size() - 1]; // 간격에 대한 배열 전개

        for(int i = 0; i < cards.size() - 1; i++) {
            diff[i] = cards.get(i + 1) - cards.get(i) - 1;
        }

        int maxL = 1; // 최대 사이즈
        int nowL = 1; // 현재 사이즈
        int rjcount = 0; // 사용된 조커

        for (int dif : diff) {
            if ( rjcount + dif <= jcount ) {
                rjcount += dif;
                nowL += dif + 1;
                maxL = Math.max(maxL, nowL);
            } else {
                int rrjcount = jcount - rjcount; // 남은 조커
                maxL = Math.max(maxL, nowL + rrjcount);
                nowL = 1;
                rjcount = 0;
            }
        }
        
        maxL = Math.max(maxL, nowL + (jcount - rjcount));
        return Math.min(maxL, deck.length);
    }
}