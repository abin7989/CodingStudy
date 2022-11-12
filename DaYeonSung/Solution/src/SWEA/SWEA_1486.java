package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1486. 장훈이의 높은 선반
public class SWEA_1486 {

	static int N, B, S, minDiff;
	static int[] H;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 점원들 수
            B = Integer.parseInt(st.nextToken()); // 선반 높이
        
            H = new int[N]; // 점원들 키 배열
            S = 0; // 점원들 키의 합
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
				S += H[i];
			}
            
            
            minDiff = Integer.MAX_VALUE;
            addH(0, 0);
            
            sb.append(minDiff).append("\n");
        }

        System.out.println(sb);
	}
	
	private static void addH(int idx, int sum) {
		if (sum >= B || idx == N) { // sum이 선반 높이를 넘으면
			if (sum - B >= 0) {
				minDiff = Math.min(sum - B, minDiff);
			}
			return;
		}

		addH(idx + 1, sum + H[idx]); // 현재 idx 점원 키 더하고 넘기거나
		addH(idx + 1, sum); // 안 더하고 넘기기
	}
}
