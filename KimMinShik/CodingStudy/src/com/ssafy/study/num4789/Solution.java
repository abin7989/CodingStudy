package com.ssafy.study.num4789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T;test_case++) {
			String st = br.readLine();
			int[] p = new int[st.length()];
			int cnt = 0;
			int fin = 0;
			for(int i = 0 ; i<st.length(); i++) {
				if(st.charAt(i)-'0'>1) {
					cnt += st.charAt(i)-'0'-1;
				}else if(st.charAt(i)-'0'==0) {
					if(cnt!=0) {
						cnt--;
					}else {
						fin++;
					}
				}
			}
			cnt = Math.max(0, cnt);
			System.out.printf("#%d %d\n",test_case,fin);
		}
	}
}
