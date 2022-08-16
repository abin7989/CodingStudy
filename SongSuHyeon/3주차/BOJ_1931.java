package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1931 {

	static int N, Cnt = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 2번째 요소를 오른차순 정렬
				if (o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				// 2번째 요소가 같다면 1번재로 요소를 오름차순 정렬
				return Integer.compare(o1[1], o2[1]);
			}
		});

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			queue.add(new int[] { s, e });
		}

		int end = queue.poll()[1];

		while (!queue.isEmpty()) {

			if (queue.peek()[0] >= end) {
				Cnt++;
				end = queue.poll()[1];
			} else {
				queue.poll();
			}
		}

		System.out.println(Cnt);

	}

}
