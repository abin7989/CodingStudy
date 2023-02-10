package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 15235. Olympiad Pizza
public class Baekjoon_15235 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] pizzas = new int[N];
		int[] given = new int[N];
		boolean[] done = new boolean[N];
		
		int[] orders = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pizzas[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += pizzas[i];
		}
		
		int idx = 0;
		int cnt = 0;
		while(sum > cnt) {
			if (idx == N) idx = 0;
			if (done[idx]) {
				idx++;
				continue;
			}
			
			
			cnt++;
			given[idx]++;

			if (pizzas[idx] == given[idx]) {
				done[idx] = true;
				orders[idx] = cnt;
				idx++;
				continue;
			}
			
			idx++;
			
			
			
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(orders[i]).append(" ");
		}
		
		System.out.println(sb);

	}

}
