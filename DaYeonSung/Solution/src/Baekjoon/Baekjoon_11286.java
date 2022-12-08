package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 백준 11286. 절댓값 힙
public class Baekjoon_11286 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->
			Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
		);
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				if (!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else {
				pq.offer(x);
			}
		}
		
		System.out.println(sb);

	}
	

}
