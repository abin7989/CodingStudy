package day_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine()); // 테스트 케이스의 수 T
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int H = Integer.valueOf(st.nextToken()); // 높이 H
			int W = Integer.valueOf(st.nextToken()); // 너비 W
			char[][] map = new char[H + 2][W + 2];

			for (int i = 0; i < H; i++) {
				String s2 = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i + 1][j + 1] = s2.charAt(j);
				}
			}

			int N = Integer.valueOf(br.readLine()); // 사용자가 넣을 입력의 개수
			String cmd = br.readLine();

			// 0 : 위, 1 : 아래, 2 : 왼쪽, 3: 오른쪽
			int tank_i = 0, tank_j = 0;
			for (int i = 1; i <= H; i++) { // 전차가 가리키는 뱡향 +1칸, 방향 찾기
				for (int j = 1; j <= W; j++) {
					if (map[i][j] == '^' || map[i][j] == '<' || map[i][j] == 'v' || map[i][j] == '>') {
						tank_i = i;
						tank_j = j;
						break;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				String c = Character.toString(cmd.charAt(i));
				if (c.equals("S")) {
					if (map[tank_i][tank_j] == '^') {
						for (int j = tank_i; j > 0; j--) {
							if (map[j][tank_j] == '*') {
								map[j][tank_j] = '.';
								break;
							} else if (map[j][tank_j] == '#') {
								break;
							}
						}
					} else if (map[tank_i][tank_j] == 'v') {
						for (int j = tank_i; j <= H; j++) {
							if (map[j][tank_j] == '*') {
								map[j][tank_j] = '.';
								break;
							} else if (map[j][tank_j] == '#') {
								break;
							}
						}
					} else if (map[tank_i][tank_j] == '<') {
						for (int j = tank_j; j > 0; j--) {
							if (map[tank_i][j] == '*') {
								map[tank_i][j] = '.';
								break;
							} else if (map[tank_i][j] == '#') {
								break;
							}
						}
					} else if (map[tank_i][tank_j] == '>') {
						for (int j = tank_j; j <= W; j++) {
							if (map[tank_i][j] == '*') {
								map[tank_i][j] = '.';
								break;
							} else if (map[tank_i][j] == '#') {
								break;
							}
						}
					}
				} else {
					if (c.equals("U")) {
						map[tank_i][tank_j] = '^';
						if (map[tank_i - 1][tank_j] == '.') {
							map[tank_i][tank_j] = '.';
							tank_i -= 1;
							map[tank_i][tank_j] = '^';
						}
					} else if (c.equals("D")) {
						map[tank_i][tank_j] = 'v';
						if (map[tank_i + 1][tank_j] == '.') {
							map[tank_i][tank_j] = '.';
							tank_i += 1;
							map[tank_i][tank_j] = 'v';
						}
					} else if (c.equals("R")) {
						map[tank_i][tank_j] = '>';
						if (map[tank_i][tank_j + 1] == '.') {
							map[tank_i][tank_j] = '.';
							tank_j += 1;
							map[tank_i][tank_j] = '>';
						}
					} else if (c.equals("L")) {
						map[tank_i][tank_j] = '<';
						if (map[tank_i][tank_j - 1] == '.') {
							map[tank_i][tank_j] = '.';
							tank_j -= 1;
							map[tank_i][tank_j] = '<';
						}
					}
				}
			}

			sb.append("#").append(test_case).append(" ");
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		} // end of test_case
		System.out.println(sb);
	} // end of main
} // end of class
