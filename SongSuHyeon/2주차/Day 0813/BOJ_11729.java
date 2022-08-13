import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
	/**
	 * 하노이 탑 : n개 원판 움직이는 규칙 동일 => 재귀 1. 위부터 n-1개 원판 들어내기 (임시기둥으로) 2. n원판 목적기둥 옮기기
	 * 3. 임시기둥 n-1개 원판을 목적기둥으로 옭기기
	 * 
	 * 
	 * hanoi(int n, int start, int temp, int end) { 기저 조건 : if(n == 0) return;
	 * 
	 * 위 n-1 이동 : h (n-1, s, e, t); n이동 n-1을 n 위로 이동 : h (n-1, t, s, e); }
	 */

	static int totalCnt = 0;
	static StringBuilder sb = new StringBuilder();
	static void hanoiTop(int n, int start, int temp, int end) {
		if (n == 1) {
			return;
		} else {
			totalCnt++;
			hanoiTop(n - 1, start, end, temp);
			sb.append(start).append(" ").append(end).append("\n");
			hanoiTop(n - 1, temp, start, end);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoiTop(N+1, 1, 2, 3);
		System.out.println(totalCnt);
		System.out.println(sb);
	}
}
