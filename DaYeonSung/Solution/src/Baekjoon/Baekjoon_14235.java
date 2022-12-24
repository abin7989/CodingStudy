package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 14235. 크리스마스 선물
public class Baekjoon_14235 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> gifts = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if (a == 0) {
				if (gifts.size() == 0) sb.append("-1\n");
				else {
					int max = Collections.max(gifts);
					sb.append(max).append("\n");
					for (int j = 0; j < gifts.size(); j++) {
						if (gifts.get(j) == max) {
							gifts.remove(j);
							break;
						}
					}
				}
				continue;
			}
			
			for (int j = 0; j < a; j++) {
				int gift = Integer.parseInt(st.nextToken());
				gifts.add(gift);
			}
		}
		
		System.out.println(sb);
	}

}
