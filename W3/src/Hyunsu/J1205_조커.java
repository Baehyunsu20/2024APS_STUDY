package Hyunsu;
import java.util.*;


public class J1205_조커{

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
		System.out.println("0갯수 : "+ cnt);
		//모두가 0일때.
		int maxLen=0;
		if(n==cnt)maxLen=n;
		else {
			////모든 알고리즘 넣어주기.
			//3. 0을 제외하고 중복되는 숫자를 지운 list 만들기
			//0의 갯수를 제외한 리스트 만들기.
			int[] list = new int[list_pre.length - cnt];
			
			for(int i=cnt, idx=0; i<list_pre.length; i++) {
				//list[0] = list_pre[0이 아닌 첫번째 인덱스 = cnt]
				list[idx++]=list_pre[i];
			}
			//0을 제외한 오름차순 정렬 완료
			System.out.println("0 제거 : "+Arrays.toString(list));
			
			
			
			//중복되는값을 지워야함 -> 매서드로 만들자 -> list_set
			//결과 : [97, 99, 100, 100, 103] -> [97, 99, 100, 103]
			int[] list_final= list_set(list);
			System.out.println("중복 제거 : "+Arrays.toString(list_final));
			
			
			//중복되지않은 자연수의 배열을 가지고 연속의 수 세기 -> method로 빼기
			//0의 갯수 = cnt
			
			maxLen = serialNumcnt(list_final, cnt);
			
//			System.out.println(maxLen);

			
		}
		

//		
		System.out.println(maxLen);
//		
		sc.close();
		 
	}
	

	static int[] list_set(int[] list) {
		
		//들어오는 인풋은 0을 제외한 오름차순 배열이다.
		//[97, 99, 100, 100, 103] -> len = 5
		//list.length = 5
		
		//동적배열 초기화 방법 까먹지 말기
		List<Integer> res_pre = new ArrayList<>();
		
		//첫 요소는 넣고 시작
		res_pre.add(list[0]);
		

		
		//중복이 존재하는 list
		for(int i=1; i<list.length; i++) {
			//i=4일때가 에러남
			
			int tsize = res_pre.size();
//			System.out.println(tsize);
			
			//num은 오름차순이므로 이전에 들어온 숫자와 내가 넣고 싶은 숫자같은 경우에는 다음 차례로 넘김
//			System.out.println(res_pre.get(tsize-1));
//			System.out.println(list[i]);
//			System.out.println();

		
			
			if(res_pre.get(tsize-1) == list[i]) {
				//res_pre안의 직전 인덱스 값(마지막 값)과 넣고싶은값(list[i])을 비교했을때, 같으면 continue;
				//에러 포인트 : 직접 값은 마지막 값이 라는 것을 기억하자
//				System.out.println("같을 경우"+i);
				continue;
			}
			else {
				//직전 값과 넣고싶은 값이 다를 경우에는 중복이 아니니까 동적 배열에 넣어주기
				res_pre.add(list[i]);
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
	
	
	//최대의 연속 길이를 반환하는 serialNumcnt
	
	static int serialNumcnt(int[] list_final, int cnt) {
		//0부터 마지막인덱스-1까지 , 현재 인덱스에서 다음인덱스, 또 다음인덱스 이런식으로 확인하기
		//{3,4,5,10,12}, cnt = 2
		int maxLen = 1;
		for(int i=0; i<list_final.length-1; i++) {
			//0번째 요소에 대해 1,2,3,4th 마지막 인덱스까지 매칭을 해봐야함. 
			for(int j= i+1; j<list_final.length; j++) {
				//필요한 0또는 연속되는 수의 갯수 = needs
				//needs가 0이 아닐 경우는 이미 있는 숫자+0으로 채울 수 있어야 연속되는 수라고 할 수 있음.
				int needs = list_final[j]-list_final[i] - 1;
				//이미 그 사이에 존재하는 숫자
				int already = j-i-1;
				//list[0] = 3, list[3] =10일때, 
				//needs= 6개의 숫자 필요 / already = 3-0-1 = 2개의 숫자가 이미 존재(4,5)
				//needs- al =6-2 = 4 , 4개의 0이 있어야함. 하지만 2개 있음.
				
				// cnt=4이면 그게 최대 길이 / 바로 return;
				//-> cnt >4이면 연속 가능, 다음 인덱스도 확인 
				//cnt < 4 : 필요한만큼의 0이 없을때. -> cnt가 2이면, 이 숫자와 연결할 수 없음. i++ -> 다음 순회로 이동
				
				
				//4개의 숫자나 0이 필요한데, 딱 그정도가 있을 경우
				if(needs== already + cnt) {
					
					//이것이 최댓값 -> 최대갱신
					System.out.println("i: "+i+" j: "+j+" 딱 0이 적절히 있을 때");
					int tmp = list_final[j]-list_final[i]+1;
					if(maxLen<tmp)maxLen = tmp;
					System.out.println("0이 적절히 있을 때 : "+maxLen);
				}
				else if(needs > already + cnt) {
					//4개가 필요한데 1개밖에 없을때, 비교할 인덱스 i를 바꿔야함.
					System.out.println("i: "+i+" j: "+j+" 0부족, maxLen : "+maxLen);
					break;//j 반복문을 벗어남.
				}
				else if(needs < already + cnt) {
					//잉여 0이 존재할 떼 -> 다음 j로 넘어가기
					//근데 j가 끝까지 갔으면 남은 0의 갯수만큼을 길이에 더해줌
					if(j==list_final.length-1) {
						//현재 문자열 길이 j + 남은 0의 갯수.
						System.out.println("i: "+i+" j: "+j+" 잉여 0이 있을 때 : 마지막 인덱스");
						//j-i+1  = 현재 문자열의 길이  + 잉여 0의 갯수
						int tmp = (list_final[j]-list_final[i]+1) + (cnt -(needs-already));
						
						//최댓값 갱신.
						if(maxLen<tmp) maxLen=tmp;
						System.out.println("마지막에 0이 남을 때 : "+maxLen);
						break;
						
					}
					//마지막 j는 아니고, 0이 남을때 -> 다음 j로 넘어감.
					//최대값도 갱신해야함.
//					int tmp = list_final[j]-list_final[i]+1;
					int tmp = (list_final[j]-list_final[i]+1) + (cnt -(needs-already));
					if(maxLen<tmp)maxLen=tmp;
					System.out.println("i: "+i+" j: "+j+" 잉여 0이 있을 때 : 마지막은 아님, maxLen :" +maxLen);
//					System.out.println("잉여 0이 있을 때_마지막은 아님 : "+maxLen);
					
					
					continue;
				}
			}	 
		}
		return maxLen;
	}
	


}


