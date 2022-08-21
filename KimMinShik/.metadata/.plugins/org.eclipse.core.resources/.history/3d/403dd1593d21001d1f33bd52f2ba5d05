package com.ssafy.study.num5356;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T;test_case++) {
			String [] map = new String[5];
			for(int i = 0 ; i < 5;i++) {
				map[i] = br.readLine();
			}
			int pos = 0;
			String temp = "";
			while(true) {
				boolean pass = false;
				for(int i = 0 ; i<5;i++) {
					if(map[i].length()>pos) {
						temp += map[i].charAt(pos);
						pass = true;
					}
				}
				
				if(pass) {
					pos++;
				}else {
					break;
				}
			}
			System.out.printf("#%d %s\n",test_case,temp);
		}
	}
}