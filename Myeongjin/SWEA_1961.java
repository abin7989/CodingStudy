package swea;

import java.util.Scanner;

public class swea1961 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1;t<=tc;t++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			System.out.println("#"+t);
			for(int i = 0;i<n;i++) {
				//90도
				for(int j = n-1;j>=0;j--) {
					System.out.print(map[j][i]);
				}
				System.out.print(" ");
				//180도
				for(int j = n-1;j>=0;j--) {
					System.out.print(map[n-1-i][j]);
				}
				System.out.print(" ");
				//270도
				for(int j = n-1;j>=0;j--) {
					System.out.print(map[n-1-j][n-1-i]);
				}
				System.out.println();
			}
		}
	}

}
