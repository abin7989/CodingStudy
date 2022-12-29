package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 백준 1966. 프린터 큐
public class Baekjoon_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 idx
			
			LinkedList<int[]> lists = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				lists.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}
						
			int cnt = 0;
			while(!lists.isEmpty()) {
				int[] poll = lists.poll();
				int idx = poll[0];
				int important = poll[1];
				
				boolean flag = true;
				for (int i = 0; i < lists.size(); i++) {
					if (lists.get(i)[1] > important) {
						flag = false;
						
						lists.offer(poll);
						for (int j = 0; j < i; j++) {
							lists.offer(lists.poll());
						}
						
						break;
					}
				}
				
				if(!flag) continue;
				
				cnt++;
				if (idx == M) {
					break;					
				}
				
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);

	}

}
