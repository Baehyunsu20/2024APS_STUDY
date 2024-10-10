import java.util.*;

public class Solution {
	static List<Integer> list;
	static int ans;
	static int cnt=0;
	static boolean[] checked;

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int cnt = sc.nextInt();
			int [] arr = new int [cnt];
			
			for(int i=0;i<cnt;i++) {
				arr[i]=sc.nextInt();
			}// 순열 배열에 받아옴
			ans=0;
			list = new ArrayList<>();
			checked = new boolean [cnt+1];
			list.add(0,1);
			list.add(1,arr[0]);
			checked[1]=true;
			checked[arr[0]]=true;
			ans++;
			for(int j=1;j<cnt;j++) {
				int here =j+1;
				dfs(here, arr[j]);
			}
			System.out.println((ans-1));
			
		
		} // ENDE DES TC
	}// ENDE DES MAIN
	
	static void dfs(int a, int b) {
		//기저
//		System.out.println(list.size());

		//
		if(!list.contains(a)) {
			if(!checked[a-1]) {
				checked[a-1] = true;
				ans++;
			}
		}
		else if (list.contains(b)) {
	
			return;
		}
		else if (checked[a] && checked[b]){
			ans--;
		else {
			list.add(list.indexOf(a)+1, b);
			return;
		}
		
		
	} //ENDE DES DFS
}
