package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 2112. 보호 필름
public class SWEA_2112 {

	static int D, W, K, min;
	static int[][] film;
	static int[][] tmpFilm;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken()); // 세로
			W = Integer.parseInt(st.nextToken()); // 가로
			K = Integer.parseInt(st.nextToken()); // 합격기준
//			특성 A는 0, 특성 B는 1로 표시됨
			
			film = new int[D][W];
			tmpFilm = new int[D][W];
			
//			필름 단면 정보들 입력 받기
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < W; c++) {
					film[r][c] = Integer.parseInt(st.nextToken());
					tmpFilm[r][c] = film[r][c];
				}
			}
			
			min = D;
			
//			약품 투입 없이 검사 통과한다면
			if (pass()) {
				sb.append(0).append("\n");
			} else { // 약품 투입이 필요하다면
				subset(0, 0); // 약품 투입
				sb.append(min).append("\n");
			}
			
		}
		
		System.out.println(sb);
	}
	
	private static void subset(int idx, int cnt) {
		if (cnt >= min) return;
		if (idx == D) {
			if (pass()) {
				min = Math.min(min, cnt);
			}
			return;
		}
		// 아무것도 안넣기
		subset(idx + 1, cnt);
		
		// A 넣기
		for (int c = 0; c < W; c++) {
			tmpFilm[idx][c] = 0;
		}
		subset(idx + 1, cnt + 1);
		
		// B 넣기
		for (int c = 0; c < W; c++) {
			tmpFilm[idx][c] = 1;
		}
		subset(idx + 1, cnt + 1);
		
		// 되돌리기
		for (int c = 0; c < W; c++) {
			tmpFilm[idx][c] = film[idx][c];
		}
		
	}
	
	private static boolean pass() {
		for (int c = 0; c < W; c++) {
			int rCnt = 1;
			int cntMax = 1;
			int pre = tmpFilm[0][c];
			for (int r = 1; r < D; r++) {
				if (tmpFilm[r][c] == pre) rCnt++; // 이전 셀과 같은 특성이라면
				else { // 이전 셀과 다른 특성이라면
					cntMax = Math.max(cntMax, rCnt);
					rCnt = 1; // 카운트 초기화
				}
				pre = tmpFilm[r][c]; // pre 업데이트
			}
			cntMax = Math.max(cntMax, rCnt);
			
			if (cntMax < K) { // 합격기준 검사
				return false;
			}
		}
		return true; // 기준 모두 통과하면 true 리턴
	}

}
