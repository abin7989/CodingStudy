package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1961 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 배열 크기 N
            int[][] arr = new int[N][N]; // N * N 배열 선언
//          N * N 배열 입력 받기
            for (int j = 0; j < N; j++) {
            	st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
//          N줄에 걸쳐 90도, 180도, 270도 회전한 모양 출력
            System.out.println("#" + (i + 1));
            for (int k = 0; k < N; k++) {
                for (int p1 = 0; p1 < N; p1++) {
                    System.out.print(arr[N - 1 - p1 ][k]);
                }
                System.out.print(" ");
                for (int p2 = N - 1; p2 >= 0; p2--) {
                    System.out.print(arr[N - k - 1][p2]);
                }
                System.out.print(" ");
                for (int p3 = 0; p3 < N; p3++) {
                    System.out.print(arr[p3][N - k - 1]);
                }
                System.out.print("\n");
            }
        }
	}

}