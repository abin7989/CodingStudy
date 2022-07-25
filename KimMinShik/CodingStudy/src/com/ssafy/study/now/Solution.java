package com.ssafy.study.now;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case<=T;test_case++) {
			int n = Integer.parseInt(br.readLine());
			int map[][] = new int [n][n];
			boolean v[][] = new boolean [n][n];
			for(int i = 0 ; i < n ; i++) {
				String st = br.readLine();
				for(int j = 0,index = 0; j< n ; j++,index+=2) {
					map[i][j] = st.charAt(index)-'0';
				}
			}
			
			int dx[] ={1,0,-1,0};
			int dy[] = {0,1,0,-1};
			int cnt = 0;
			int posx[] = {n,}
			for(int i = 0 ;i<4;i++) {
				int x = n/2;
				int y =n/2;
				for(int j = 1;j<=n/2;j++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					v[nx][ny] = true;
					cnt+= map[nx][ny];
				}
			}
			
			System.out.printf("#%d %d\n",test_case);
		}
		
	}
}