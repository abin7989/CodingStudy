package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 7795. 먹을 것인가 먹힐 것인가
public class Baekjoon_7795 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // A의 수
			int M = Integer.parseInt(st.nextToken()); // B의 수
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int cnt = 0;
			
			int top = M - 1;
			int down = M - 1;
			
			for (int i = 0; i < M; i++) {
				if (B[i] < A[N- 1]) {
					top = i;
					break;
				}
			}
			
			for (int i = N - 1; i >= 0; i--) {
				int A_num = A[i];
				for (int j = down; j >= top; j--) {
					int B_num = B[j];
					if (A_num > B_num) cnt++;
					else {
						down--;
						continue;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
		
		
		

	}

}
