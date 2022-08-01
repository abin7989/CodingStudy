package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1940. 가랏! RC카!

/**
 * 0: 현재 속도 유지
 * 1: 가속
 * 2: 감속
 */

public class SWEA_1940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // Command 수 (몇 초)
			
			int v = 0; // 초기속도는 0
			int dist = 0; // 이동거리
			
			for (int i = 0; i < N; i++) { // N초 동안 1초에 한번씩 Command 입력 받기
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c1 = Integer.parseInt(st.nextToken());
				if (c1 != 0) { // 가속하거나 감속할 경우
					int accel = Integer.parseInt(st.nextToken()); // 가속도 추가로 입력받기
					if (c1 == 1) { // 가속할 경우
						v += accel;
					} else if (c1 == 2) { // 감속할 경우
						if (accel > v) { // 현재 속도보다 감속할 속도가 더 클 경우
							v = 0; // 속도는 0이 된다
						}
						else {
							v -= accel;
						}
					}
				}
				dist += v;
			}
			
			
			
			System.out.printf("#%d %d\n", tc, dist);
		}
	}

}
