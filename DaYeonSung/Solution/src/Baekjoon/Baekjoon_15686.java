package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 15686. 치킨 배달
public class Baekjoon_15686 {
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static List<int[]> home, chicken;
	static boolean[] combCheck;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 도시 크기
        M = Integer.parseInt(st.nextToken()); // 치킨집의 최소 개수
        
        home = new ArrayList<>();
        chicken = new ArrayList<>();
		
        // 0: 빈칸
        // 1: 집
        // 2: 치킨집
        
        // 집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재
        // 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다
        
		// 도시 정보 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				switch(Integer.parseInt(st.nextToken())) {
					case 1:
						home.add(new int[]{i, j});
                        break;
					case 2:
						chicken.add(new int[] {i, j});
						break;
				}
			}
		}
		combCheck = new boolean[chicken.size()];
		comb(-1, 0);
		
		System.out.println(result);
	}

	static void comb(int idx, int cnt) {
		if (cnt == M) {
			int dist = 0;
			
			for (int[] h: home) {
				int tmp = Integer.MAX_VALUE;
				for (int i = 0; i < combCheck.length; i++) {
					if (combCheck[i]) {
						tmp = Math.min(tmp, Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]));
					}
				}
				dist += tmp;
			}
			if (dist < result) {
				result = dist;
			}
			return;
		}
		
		for (int i = idx + 1; i < combCheck.length; i++) {
			combCheck[i] = true;
			comb(i, cnt + 1);
			combCheck[i] = false;
		}
	}
}
