package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 15650. N과 M (2)
public class Baekjoon_15650 {

	static int N, M;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().concat(" "));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[M];
		
		dfs(1, 0);
		
		System.out.println(sb);

	}
	
	private static void dfs(int start, int depth) {
		if (depth == M) {
			for(int num: nums) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {
			nums[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}

}
