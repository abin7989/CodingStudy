package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 백준 2668. 숫자고르기
public class Baekjoon_2668 {

	static int N, num;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()) - 1;
		}
		
		ans = new ArrayList<>();
				
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			num = i;
			findSet(i);
			visited[i] = false;
		}
		
		Collections.sort(ans);
		
		sb.append(ans.size()).append("\n");
		
		for (Integer n : ans) {
			sb.append(n + 1).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	
	private static void findSet(int idx) {
		if (arr[idx] == num) ans.add(num);
		
		if (!visited[arr[idx]]) {
			visited[arr[idx]] = true;
			findSet(arr[idx]);
			visited[arr[idx]] = false;
		}
	}

}
