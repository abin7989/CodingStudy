package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 지도 어느 구역에 있더라도 성우가 피리를 불 때
 * ‘SAFE ZONE’에 들어갈 수 있게 하는
 * ‘SAFE ZONE’의 최소 개수를 출력하는 프로그램
 * 
 * U: 위쪽
 * D: 아래쪽
 * L: 왼쪽
 * R: 오른쪽
 *
 */

public class Baekjoon_16724 {

	static char[][] map;
	static int[][] checkMap;
	static int N, M;
	static int cnt = 1;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 지도 정보 입력 받기
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		checkMap = new int[N][M]; // 처음엔 다 0으로 초기화되어 있음
		
		for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < M ; j++)
                if(checkMap[i][j] == 0) {
                	go(i,j);                	
                }
		
        System.out.println(cnt-1); // cnt는 어쩔 수 없이 비교를 위해 초기값이 1이었기 때문에 결과에선 1 빼줘야 함.
		
	}
	
	private static int go(int r, int c) {
		if(checkMap[r][c] != 0) { // checkMap 값이 0이 아니고
            if(checkMap[r][c] == cnt) // cnt의 값과 같다면
                cnt++; // 새로운 경로라는 의미이기 때문에 cnt에 1 더하기
            return checkMap[r][c]; // cnt의 값과 다르다면 순환되는 구조이므로 cnt는 그대로이고, 그 자리의 값 반환
		}
		// checkMap[r][c] 값이 0이라면 이동해야 한다!
		int nextRow = r;
		int nextCol = c;
		checkMap[r][c] = cnt; // 현재 cnt로 자취 남기기
		
		switch(map[r][c]) { // U, D, L, R에 따라 다음 row, column 변형시켜주기
			case('U'):
				nextRow -= 1;
				break;
			case('D'):
				nextRow += 1;
				break;
			case('L'):
				nextCol -= 1;
				break;
			case('R'):
				nextCol += 1;
				break;
		}
		checkMap[r][c] = go(nextRow, nextCol); // 화살표를 따라 다음 칸으로 go
		
		return checkMap[r][c];
	}
}