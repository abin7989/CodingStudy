package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_3190 {
	static int map[][]; // 보드
	static String dir[][];
	static int N; // 보드의 크기
	static int K; // 사과의 개수
	
	static int h_row;
	static int h_col;
	
	static int t_row;
	static int t_col;
	
	static int h_idx; // 뱀 머리 초기 방향 idx
	static int t_idx; // 뱀 머리 초기 방향 idx
	
	static int delay; // 머리와 꼬리 움직임 시간 차

	static int dx[] = {1, 0, -1, 0}; // 우 하 좌 상 col
	static int dy[] = {0, 1, 0, -1}; // 우 하 좌 상 row
	
	static int time = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 보드의 크기
		K = Integer.parseInt(br.readLine()); // 사과의 개수
		map = new int[N+2][N+2];
		
//		뱀 시작 위치 : [0][0]
//		길이는 1
//		초기 방향 : 오른쪽
		
//		뱀 이동 규칙
//		먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
//		만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
//		만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
		
		for (int i = 0; i < K; i++) { // 다음 K개의 줄에는 사과의 위치가 주어진다.
			st = new StringTokenizer(br.readLine());
			int app_row = Integer.parseInt(st.nextToken()); // 사과 row
			int app_col = Integer.parseInt(st.nextToken());	// 사과 column
			map[app_row][app_col] = 1; // 사과 위치 표시
		}
		
		int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
		dir = new String[L][2];
		
//		L개의 방향 변환 정보 입력 받기
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i][0] = st.nextToken(); // X초가 끝난 뒤에
			dir[i][1] = st.nextToken(); // 왼쪽(L) 또는 오른쪽(D)으로 90도 방향 회전
		}
		
		h_row = 1;
		h_col = 1;
		t_row = 1;
		t_col = 1;
		
		delay = 0; // 처음엔 머리와 꼬리가 같은 공간에 있음 (그래서 머리 꼬리 시간차 존재 X)
		
		map[1][1] = 2; // 뱀 초기 위치 설정
		
		h_idx = 0;
		t_idx = 0;
		
		int headOrderIdx = 0; // 다음번에 머리가 수행할 방향 인덱스
		int tailOrderIdx = 0; // 다음번에 꼬리가 수행할 방향 인덱스
		
		while(true) {
			time++;
			
			h_row += dy[h_idx]; // 머리 다음 row
			h_col += dx[h_idx]; // 머리 다음 col
			
//			벽이 있거나 자기 몸과 부딛히면
			if (h_row == 0 || h_row == N+1 || h_col == 0 || h_col == N+1 || map[h_row][h_col] == 2) {
				System.out.println(time);
				break;
			}
			
//			그냥 맨 땅이고 사과가 없다면
			if (map[h_row][h_col] == 0) {
				map[t_row][t_col] = 0;
				t_row += dy[t_idx]; // 꼬리 다음 row
				t_col += dx[t_idx]; // 꼬리 다음 col
			}
//			사과가 있다면
			else if (map[h_row][h_col] == 1) {
				delay++;
			}
			
			map[h_row][h_col] = 2; // 현재 머리 위치 뱀 위치 처리
			
//			머리 움직임 남았을 때
			if (headOrderIdx < L) {
				int X = Integer.parseInt(dir[headOrderIdx][0]);
				String C = dir[headOrderIdx][1];
				if (X == time) {
					if (C.equals("D")) {
						h_idx++;
						if (h_idx > 3) h_idx -= 4;
					} else if (C.equals("L")) {
						h_idx--;
						if (h_idx < 0) h_idx += 4;
					}
					headOrderIdx++;
				} 
			}
			
//			꼬리 움직임 남았을 때
			if (tailOrderIdx < L) {
				int X = Integer.parseInt(dir[tailOrderIdx][0]);
				String C = dir[tailOrderIdx][1];
				if (X + delay == time) {
					if (C.equals("D")) {
						t_idx++;
						if (t_idx > 3) t_idx -= 4;
					} else if (C.equals("L")) {
						t_idx--;
						if (t_idx < 0) t_idx += 4;
					}
					tailOrderIdx++;
				}
			}
		}
	}
}
