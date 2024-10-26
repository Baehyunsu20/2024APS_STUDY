package BOJ_11725_트리의_부모_찾기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] ans = new int[N + 1];

		ArrayList<Integer>[] board = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			board[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			int fir = sc.nextInt();
			int sec = sc.nextInt();
			if (!board[fir].contains(sec)) {
				board[fir].add(sec);
			}
			if (!board[sec].contains(fir)) {
				board[sec].add(fir);
			}
		}

		Queue<Integer> qu = new LinkedList<>();
		qu.add(1);
		while (!qu.isEmpty()) {
			int temp = qu.poll();
			for (int j = 0; j < board[temp].size(); j++) {
				if (ans[board[temp].get(j)] == 0) {
					qu.add(board[temp].get(j));
					ans[board[temp].get(j)] = temp;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			System.out.println(ans[i]);
		}
	}
}
