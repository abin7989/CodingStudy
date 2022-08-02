package SWEA;

import java.util.Scanner;

class SWEA_1961 {
	public static void main(String args[]) throws Exception {
		
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int i, j, k;
		int N;
		
		for(i = 0; i < T; i++) {
			
			N = s.nextInt();
			int[][] arr = new int[N][N];
			
			/* 입력 */
			for(j = 0; j < N; j++)
				for(k = 0; k < N; k++)
					arr[j][k] = s.nextInt();

			System.out.println("#" + (i + 1));
			
			for(j = 0; j < N; j++) {
				
				for(k = N - 1; k >= 0; k--) 
					System.out.print(arr[k][j]);

				System.out.print(" ");

				for(k = N - 1; k >= 0; k--) 
					System.out.print(arr[N - (j + 1)][k]);
				
				System.out.print(" ");

				for(k = 0; k < N; k++) 
					System.out.print(arr[k][N - (j + 1)]);
				
				System.out.println();
				
			}
		}
	}
}