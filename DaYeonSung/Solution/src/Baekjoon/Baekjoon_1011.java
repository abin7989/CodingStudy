package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1011. Fly me to the Alpha Centauri
public class Baekjoon_1011 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int dist = y - x;
			
			int max = (int) Math.sqrt(dist);
			
			if (max == Math.sqrt(dist)) {
				sb.append(max * 2 - 1).append('\n');
			}
			else if(dist <= max * max + max) {
				sb.append(max * 2).append('\n');
			}
			else {
				sb.append(max * 2 + 1).append('\n');
			}
		}
		
		System.out.println(sb);
		

	}
	
}
