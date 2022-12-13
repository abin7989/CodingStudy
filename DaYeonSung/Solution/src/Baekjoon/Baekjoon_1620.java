package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 백준 1620. 나는야 포켓몬 마스터 이다솜
public class Baekjoon_1620 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 도감에 수록돼있는 포켓몬 개수
		int M = Integer.parseInt(st.nextToken()); // 내가 맞춰야 하는 문제 개수
		
		HashMap<String, Integer> monsterMap = new HashMap<>();
		String[] monsters = new String[N + 1];
		
		for (int i = 1; i <= N; i++) {
			monsters[i] = br.readLine();
			monsterMap.put(monsters[i], i);
		}
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
				sb.append(monsterMap.get(str)).append("\n");
			} else {
				sb.append(monsters[Integer.parseInt(str)]).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
