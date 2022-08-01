package swea;

import java.util.Scanner;

public class swea1954 {
	static boolean inRange(int n, int a, int b) {
		if(0<=a&&a<n&&0<=b&&b<n)
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1;t<=tc;t++) {
			int n = sc.nextInt();
			int[][] ans = new int[n][n];
			int num = 1;
			int a = 0;
			int b = 0;
			int d = 0;
			
			while(num<=n*n) {
				ans[a][b] = num++;
				int na = a+dx[d];
				int nb = b+dy[d];
				if(inRange(n,na,nb)&&ans[na][nb]==0) {
					a = na;
					b = nb;
					continue;
				}
				d = (d+1)%4;
				a+=dx[d];
				b+=dy[d];
			}
			System.out.printf("#%d\n",t);
			for(int[] row:ans) {
				for(int data:row)
					System.out.print(data+" ");
				System.out.println();
			}
		}
		
		
	}

}
