package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 백준 11557. Yangjojang of The Year
public class Baekjoon_11557 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			Map<Integer, String> schools = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String schoolName = st.nextToken();
				int alcohols = Integer.parseInt(st.nextToken());
				schools.put(alcohols, schoolName);
			}
			
			Integer maxAlcoholIdx = Collections.max(schools.keySet());
			
			sb.append(schools.get(maxAlcoholIdx)).append("\n");
		}
		
		System.out.println(sb);
	}

}
