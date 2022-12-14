package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 14658. 하늘에서 별똥별이 빗발친다
public class Baekjoon_14658 {

	static int N, M, L, K;
	static ArrayList<int[]> stars;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 별똥별 떨어지는 구역 가로 길이
		M = Integer.parseInt(st.nextToken()); // 별똥별 떨어지는 구역 세로 길이
		L = Integer.parseInt(st.nextToken()); // 트램펄린의 한 변 길이
		K = Integer.parseInt(st.nextToken()); // 별똥별의 수

		stars = new ArrayList<>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			stars.add(new int[] {x, y});
		}
		
		int max = Integer.MIN_VALUE; // 튕겨니는 별의 max 개수
		for (int[] s1: stars) {
			for(int[] s2: stars) {
				max = Integer.max(max, bounceStars(s1[0], s2[1]));
			}
		}
		
		System.out.println(K - max);
	}
	
	private static int bounceStars(int x, int y) {
		int cnt = 0;
		for (int[] s: stars) {
			if (x <= s[0] && s[0] <= x + L && y <= s[1] && s[1] <= y + L)
				cnt++;
		}
		return cnt;
	}

}
