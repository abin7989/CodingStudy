package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SWEA 1954. 달팽이 숫자
public class SWEA_1954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 크기 N
			
			int[][] arr = new int[N][N];
			
			int num = 1;
			
//			x축과 y축으로 각각 방향 배열 선언
			int dx[] = {1, 0, -1, 0};
			int dy[] = {0, 1, 0, -1};
			
			int x = 0, y = 0; // column, row
			int n = 0; // 방향
			
			while (num <= N * N) {
				arr[y][x] = num++;
				x += dx[n]; // 그 다음 column
				y += dy[n]; // 그 다음 row
				if (x > N - 1 || x < 0 || y > N - 1 || y < 0 || arr[y][x] != 0) { // 배열의 끝을 만나거나 범위를 벗어나면
					x -= dx[n]; // 한 칸 원상복귀
					y -= dy[n]; // 한 칸 원상복귀
					n = (n+1) % 4; // 방향 change
					x += dx[n]; // 방향 바꿔서 그 다음  column
					y += dy[n]; // 방향 바꿔서 그 다음 row
				}
			}
			
			
			System.out.printf("#%d\n", tc);
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr.length; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}
		}

	}

}
