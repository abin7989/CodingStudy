package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 15657. N과 M (8)
public class Baekjoon_15657 {
	static int N, M;
	static int[] nums;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		ans = new int[M];
		
//		N개의 수 입력 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums); // 입력받은 수들 오름차순 정렬
		
		dfs(0, 0);
		
		System.out.println(sb);
	}
	public static void dfs(int depth, int idx) {
		if (depth == M) {
			for (int x : ans) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = idx; i < N; i++) {
			ans[depth] = nums[i];
			dfs(depth + 1, i);
		}
	}
}
