package com.ssafy.study.Test1;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1493
class Solution {
	static final int MAX_NUM = 350;
	static int map[][] = new int[MAX_NUM][MAX_NUM];
	static int[] vx = new int[61077];
	static int[] vy = new int[61077];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int cnt = 1;
		for(int i = 0 ; i < MAX_NUM ; i++) {
			int x = i;
			int y= 1;
			for(int j = 1; j<=i;j++) {
				map[x][y] = cnt; 
				vx[cnt] = x;
				vy[cnt] = y;
				cnt++;
				x =x-1;
				y = y+1;
				
			}
		}
		for(int test_case =1;test_case<=T;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int x1 = vx[n1];
			int y1 = vy[n1];
			int x2 = vx[n2];
			int y2 = vy[n2];
			int t1 = x1+x2;
			int t2 = y1+y2;
			
			
			System.out.printf("#%d %d\n",test_case,map[t1][t2]);
		}
		
	}
}