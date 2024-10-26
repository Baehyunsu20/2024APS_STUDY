package BOJ_9934_완전_이진_트리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < (1 << K) - 1; i++) {
			list.add(sc.nextInt());
		}

		Queue<List<Integer>> qu = new LinkedList<>();

		qu.add(list);
		int br = 1;
		int count = 0;
		while (!qu.isEmpty()) {
			List<Integer> curr = qu.poll();
			System.out.print(curr.get(curr.size() / 2) + " ");
			count++;
			if (count == br) {
				System.out.println();
				br = br * 2;
				count = 0;
			}
			if (curr.size() > 1) {
				List<Integer> before = new ArrayList<>();
				for (int i = 0; i < curr.size() / 2; i++) {
					before.add(curr.get(i));
				}
				List<Integer> after = new ArrayList<>();
				for (int i = curr.size() / 2 + 1; i < curr.size(); i++) {
					after.add(curr.get(i));
				}
				qu.add(before);
				qu.add(after);
			}
		}
	}
}
