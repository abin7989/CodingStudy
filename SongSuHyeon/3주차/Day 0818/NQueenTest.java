package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueenTest {

	static int N, cols[], ans;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		cols = new int[N + 1];

		ans = 0;

		setQueen(1);

		System.out.println(ans);

	}

	private static void setQueen(int rowNo) { // 하나의 퀸만 가능한 모든 곳에 놓아보기

		if (!isAvailable(rowNo - 1)) { // 직전까지의 상황이 유망하지 않으면 현재 퀴 놓을 필요 없으니 백트랙!!!
			return;
		}

		if (rowNo > N) { // 놓으려는 칸이 체스판을 벗어나면 = 퀸을 다 놓았으면 = 모든 퀸의 배치에 성공한 상황
			ans++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			cols[rowNo] = i; // 현재 위치에 퀸 두기
			setQueen(rowNo + 1); // 다음 칸으로 가기
		}

	}

	private static boolean isAvailable(int rowNo) {
		for (int j = 1; j < rowNo; j++) {
			if (cols[j] == cols[rowNo] || rowNo - j == Math.abs(cols[rowNo] - cols[j]))
				return false;
		}
		return true;
	}

}
