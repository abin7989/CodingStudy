package SWEA;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int i, x, y;
		int cnt;
		int[][] arr;
		boolean flag;
		int tmp;
		
		for(i = 0; i < T; i++) {
			cnt = 0;
			int N = s.nextInt();
			int K = s.nextInt();
			
			arr = new int[N + 2][N + 2];
			
			/* 배열 0으로 패딩 */
			for(x = 0; x < N + 2; x++)
				for(y = 0; y < N + 2; y++)
					arr[x][y] = 0;

			/* 입력 받음 */
			for(x = 1; x < N + 1; x++) 
				for(y = 1; y < N + 1; y++) 
					arr[x][y] = s.nextInt();
			
			for(x = 1; x < N + 1; x++) {
				for(y = 1; y < N + 1; y++) {
					if(arr[x][y] == 1) {
						flag = true;
						tmp = 1;
						
						// 가로로 확인
						if(arr[x][y - 1] == 1)
							flag = false;
						
						while(tmp < K && flag) {
							if(arr[x][y + tmp] == 0) {
								flag = false;
								break;
							}
							
							tmp++;
						}
						
						if(flag) {
							if(arr[x][y + K] == 0)
								cnt++;
						}
						
						flag = true;
						tmp = 1;
						
						// 세로로 확인
						if(arr[x - 1][y] == 1)
							flag = false;
						
						while(tmp < K && flag) {
							if(arr[x + tmp][y] == 0) {
								flag = false;
								break;
							}
							
							tmp++;
						}
						
						if(flag) {
							if(arr[x + K][y] == 0)
								cnt++;
						}
					}
				}
			}
			
			System.out.println("#" + (i + 1) + " " + cnt);
		}
	}
}