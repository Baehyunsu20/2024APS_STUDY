package w3;
import java.util.*;


public class j1205조커 {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		//몇 장의 카드인지 인풋.
		int n = sc.nextInt();
		int[] list_pre = new int[n];
		for(int i=0; i<n; i++) {
			//카드의 숫자 리스트를 받아옴
			list_pre[i] = sc.nextInt();
		}
		
		//1. 오름차순으로 배열 정렬
		//list_pre = 0을 포함한 오름차순 배열
		Arrays.sort(list_pre);
		
		//2. 0이 몇개인지 카운팅
		int cnt=0;
		for(int tmp: list_pre) {
			if(!(tmp==0)) {
				//오름차순이므로 0이 앞에만 존재
				//더 이상 0이 아니면 for문을 빠져나감.
				break;
			}
			//0일 경우에만 0의 갯수를 센다.
			cnt++;
		}
		
		//3. 0을 제외하고 중복되는 숫자를 지운 list 만들기
		//0의 갯수를 제외한 리스트 만들기.
		int[] list = new int[list_pre.length - cnt];
		for(int i=cnt, idx=0; i<list_pre.length; i++) {
			//list[0] = list_pre[0이 아닌 첫번째 인덱스 = cnt]
			list[idx++]=list_pre[i];
		}
		
		//중복되는값을 지워야함 -> 매서드로 만들자
		
		
		 
	}
	
	static int[] list_set(int[] list) {
		
		//동적배열 초기화 방법 까먹지 말기
		List<Integer> res_pre = new ArrayList<>();
//		int idx =0;
		
		//첫 요소는 넣고 시작
		res_pre.add(0, list[0]);
		
		//중복이 존재하는 list
		for(int i=1; i<=list.length; i++) {
			//num은 오름차순이므로 이전에 들어온 숫자와 내가 넣고 싶은 숫자같은 경우에는 다음 차례로 넘김
			if(res_pre.get(i-1) == list[i]) {
				//res_pre안의 직전 인덱스 값과 넣고싶은값(list[i])을 비교했을때, 같으면 continue;
				continue;
			}
			else {
				//직전 값과 넣고싶은 값이 다를 경우에는 중복이 아니니까 동적 배열에 넣어주기
				res_pre.add(i, list[i]);
				
			}
		}//중복이 없는 동적배열 res_pre 완성
		//동적배열은 정적 배열 res로 변환하여 반환하고싶음.
		int[] res = new int[res_pre.size()];
		
		for(int k=0; k<res.length;k++) {
			//하나씩 값 넣기.
			res[k] = res_pre.get(k);
		}
		
//		자바 실습 10에선 되는데 여기서는 왜 안될까. -> 일단 반복문으로 		
//		return res_pre.toArray(res);
		
		return res;
		
	}

}
