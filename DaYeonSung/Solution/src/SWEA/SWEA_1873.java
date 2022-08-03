package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  <게임 맵의 구성 요소>
 * . 평지(전차가 들어갈 수 있다.)
 * * 벽돌로 만들어진 벽
 * # 강철로 만들어진 벽
 * - 물(전차는 들어갈 수 없다)
 * ^ 위쪽을 바라보는 전차(아래는 평지이다.)
 * v 아래쪽을 바라보는 전차(아래는 평지이다.)
 * < 왼쪽을 바라보는 전차(아래는 평지이다.)
 * > 오른쪽을 바라보는 전차(아래는 평지이다.)
 * 
 * <사용자가 넣는 입력의 종류>
 * U Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
 * D Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
 * L Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
 * R Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
 * S Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 * 
 */

public class SWEA_1873 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 수 만큼
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 높이 row
			int W = Integer.parseInt(st.nextToken()); // 너비 column
			
			char[][] map = new char[H][W];
			
//			게임 맵 입력 받기
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
				}
			}
		
			int N = Integer.parseInt(br.readLine()); // 사용자가 넣을 입력의 개수
			
//			사용자 입력 입력 받기
			String inputs = br.readLine();
			char[] input = inputs.toCharArray();
			
			int user_x = 0;
			int user_y = 0;
			
			// 상 하 좌 우
			int dirX[] = {0, 0, -1, 1};
			int dirY[] = {-1, 1, 0, 0};
			int dirN = 0;
			
//			사용자 시작 위치 구하기
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					switch(map[r][c]) {
						case '^':
							user_x = c;
							user_y = r;
							dirN = 0;
							break;
						case 'v':
							user_x = c;
							user_y = r;
							dirN = 1;
							break;
						case '<':
							user_x = c;
							user_y = r;
							dirN = 2;
							break;
						case '>':
							user_x = c;
							user_y = r;
							dirN = 3;
							break;
					}					
				}
			}
			map[user_y][user_x] = '.'; // 사용차 초기 위치 평지로 변경
			
			for (int i = 0; i < N; i++) {
				if (input[i] == 'U') { // Up이라면
					dirN = 0; // 방향 변경
					if (user_y != 0) {
						if (map[user_y - 1][user_x] == '.') { // 전방이 평지라면
							user_y -= 1; // 나아가기
						}
					}
				} else if (input[i] == 'D') { // Down이라면
					dirN = 1; // 방향 변경
					if (user_y != H - 1) {
						if (map[user_y + 1][user_x] == '.') { // 전방이 평지라면
							user_y += 1; // 나아가기
						}
					}
				} else if (input[i] == 'L') { // Left라면
					dirN = 2; // 방향 변경
					if (user_x != 0) {
						if (map[user_y][user_x - 1] == '.') { // 전방이 평지라면
							user_x -= 1; // 나아가기
						}
					}
				} else if (input[i] == 'R') { // Right라면
					dirN = 3; // 방향 변경
					if (user_x != W - 1) {
						if (map[user_y][user_x + 1] == '.') { // 전방이 평지라면
							user_x += 1; // 나아가기
						}
					}
				} else if (input[i] == 'S') { // Shoot라면
					int bomb_x = user_x; // 포탄 x위치
					int bomb_y = user_y; // 포탄 y위치
					while (true) {
//						포탄위치가 범위를 벗어나면 break
						if (bomb_x + dirX[dirN] == -1 || bomb_x + dirX[dirN] == W || bomb_y + dirY[dirN] == -1 || bomb_y + dirY[dirN] == H) break;
						bomb_x += dirX[dirN]; // 포탄(x좌표) 한칸씩 쏘는 중
						bomb_y += dirY[dirN]; // 포탄(y좌표) 한칸씩 쏘는 중
						if (map[bomb_y][bomb_x] == '#') break; // 강철로 만든 벽 만나면 break
						else if (map[bomb_y][bomb_x] == '*') { // 벽돌로 만든 벽 만나면
							map[bomb_y][bomb_x] = '.'; // 평지 처리
							break; // 반복문 빠져나오기
						}
					}
				}
			}
			
//			최종 사용자의 방향에 따라 알맞은 방향으로 사용자 배치
			if (dirN == 0) map[user_y][user_x] = '^';
			if (dirN == 1) map[user_y][user_x] = 'v';
			if (dirN == 2) map[user_y][user_x] = '<';
			if (dirN == 3) map[user_y][user_x] = '>';
			
//			최종 결과 맵 출력
			System.out.printf("#%d ", tc);
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}
}