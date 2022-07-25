package com.ssafy.study.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case =1;test_case<=10;test_case++) {
			int n = Integer.parseInt(br.readLine());
			char map[][] = new char[n][n];
			for (int i = 0; i < n; i++) {
				String st = br.readLine();
				for (int j = 0, index = 0; j < n; j++, index += 2) {
					map[i][j] = st.charAt(index);
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]=='0')
						continue;
					
					if(map[i][j]=='1') {
						int x = i;
						while(true) {
							int nx = x+1;
							if(nx<0||nx>=n||map[nx][j]=='1')
								break;
							if(map[nx][j]=='2'){
								cnt++;
								break;
							}
							x =nx;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",test_case,cnt);
		}
		
	}
}