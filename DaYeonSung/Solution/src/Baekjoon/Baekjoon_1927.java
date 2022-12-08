package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 백준 1927. 최소 힙
public class Baekjoon_1927 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
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
