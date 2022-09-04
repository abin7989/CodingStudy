package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 9095. 1, 2, 3 더하기
public class Baekjoon_9095 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
						
			for (int th = n / 3; th >= 0; th--) {
				for (int tw = ((n - 3 * th) / 2); tw >= 0; tw--) {
					for (int on = (n - 3 * th - 2 * tw); on >= 0; on--) {
						if (th * 3 + tw * 2 + on == n) {
							int zeroCnt = 0;
							if (th == 0) zeroCnt++;
							if (tw == 0) zeroCnt++;
							if (on == 0) zeroCnt++;
							// 한 수로만 이루어진 경우(zeroCnt가 2일 때)
							if (zeroCnt == 2) {
								cnt++; // 한 번만 카운트
								continue;
							}
							// 두 수 또는 세 수로 이루어진 경우(zeroCnt가 1 또는 0일 때)
							int tmp = 0;

							tmp = fact(on + tw + th);
							if (on != 0 && on != 1) {
								tmp /= fact(on);
							}
							if (tw != 0 && tw != 1) {
								tmp /= fact(tw);
							}
							if (th != 0 && th != 1) {
								tmp /= fact(th);
							}
							cnt += tmp;
						}
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}
	
	private static int fact (int num) {
		int ans = 1;
		for (int i = 1; i <= num; i++) {
			ans *= i;
		}
		return ans;
	}

}
