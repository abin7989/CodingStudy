package swea;

import java.awt.Point;
import java.util.Scanner;

public class swea1493 {
	static Point getPoint(int v) {
		int i = 1;
		int sum = 0;
		while(sum<v) {
			sum+=i;
			i++;
		}
		int y = sum-v+1;
		int x = i+v-sum-1;
		return new Point(x,y);
	}
	static int getNum(int x,int y) {
		int n = x+y-1;
		int answer = 0;
		for(int i = 1;i<n;i++) {
			answer+=i;
		}
		answer+=x;
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1;t<=tc;t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			Point p1 = getPoint(p);
			Point p2 = getPoint(q);
			int answer = getNum(p1.x+p2.x,p1.y+p2.y);
			System.out.printf("#%d %d\n",t,answer);
		}
	}

}
