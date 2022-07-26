package swea;

import java.util.Scanner;

public class swea1220 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = 10;
		for(int t = 1;t<=tc;t++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			
			boolean meetN = false;
			
			for(int j = 0;j<n;j++) {
				meetN = false;
				for(int i = 0;i<n;i++) {
					if(map[i][j] == 1)
						meetN = true;
					else if(map[i][j] == 2 &&meetN) {
						meetN = false;
						cnt++;
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,cnt);
			
		}
	}

}
