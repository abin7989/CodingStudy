package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� 17070. ������ �ű�� 1
public class Baekjoon_17070 {

	static int N;
	static int cnt = 0;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // ���� ũ��
		
		map = new int[N][N];
		
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �������� �� 3���� ������ ����
		// ���η� 2�� �� (�̵� ��� 2����)
		// ���η� 2��  (�̵� ��� 2����)
		// ���� ���� 2���� �� 4�� �� (�̵� ��� 3����)
		// ȸ���� 45���� ȸ����ų �� ������, �̴� ������ ������, �Ʒ�, �Ǵ� ������ �Ʒ� �밢�� �����̾�� �Ѵ�.
		
		int direction = 1; // �ʱ� ���� ���η� �Ǿ� ������ 1�̶� �Ѵ�. ����, �밢���� ���� 2, 3
		dfs(0, 1, direction);
		
		System.out.println(cnt);

	}

	private static void dfs(int r, int c, int direction) {
		if (r == N-1 && c == N-1) {
			cnt++; // ������ �����ߴٸ� true ����
			return;
		}
		if (direction == 1) { // ���� ���η� �����ִٸ�
			if (c + 1 <= N - 1 && map[r][c + 1] == 0) dfs(r, c + 1, 1); // ��
		} else if (direction == 2) { // ���� ���η� �����ִٸ�
			if (r + 1 <= N - 1 && map[r + 1][c] == 0) dfs(r + 1, c, 2); // ��
		} else { // ���� �밢������ �����ִٸ�
			if (c + 1 <= N - 1 && map[r][c + 1] == 0) dfs(r, c + 1, 1); // ��
			if (r + 1 <= N - 1 && map[r + 1][c] == 0) dfs(r + 1, c, 2); // ��
		}
		
		// � ��쿡������ �밢�� �˻�� �ؾ��ؼ� ���� ����
		if (r + 1 <= N - 1 && c + 1 <= N - 1 && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0)
			dfs(r + 1, c + 1, 3);
	}
	
}
