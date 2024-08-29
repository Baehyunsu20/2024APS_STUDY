package SWEA_6808_규영이와_인영이의_카드게임;

import java.util.*;
import java.io.*;

public class Solution {
	
	static int win,lose;
	static int[] kyCard, iyCard, iyCardmix;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			boolean[] card = new boolean[19];
			kyCard = new int[9];
			iyCard = new int[9];
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				kyCard[i]=Integer.parseInt(st.nextToken());
				card[kyCard[i]]=true;
			}
			
			// true>규영이꺼 false>인영이꺼
			int cnt=0;
			for(int i=1;i<=18;i++) {
				if(!card[i]) {
					iyCard[cnt++]=i;
				}
			}
			
			iyCardmix = new int[9];
			check = new boolean[9];
			win=0;lose=0;
			dfs(0);
			
			System.out.println("#"+t+" "+win+" "+lose);
		
			
		}
	}
	static void dfs(int cnt) {
		if(cnt==9) {
			int kysum=0, iysum=0;
			for(int i=0;i<9;i++) {
				if(kyCard[i]>iyCardmix[i]) {
					kysum+=kyCard[i]+iyCardmix[i];
				}else if(kyCard[i]<iyCardmix[i]) {
					iysum+=kyCard[i]+iyCardmix[i];
				}
			}
			if(kysum>iysum) {
				win++;
			}else {
				lose++;
			}
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(!check[i]) {
				check[i]=true;
				iyCardmix[cnt]=iyCard[i];
				dfs(++cnt);
				cnt--;
				check[i]=false;
			}
		}
	}

}