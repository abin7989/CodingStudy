package com.ssafy.study.Test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


import javax.naming.InterruptedNamingException;

public class Test4 {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new FileReader("Test4.txt"));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int map[] = new int[n];
			double avg = 0 ;
			for(int i =0;i<n;i++) {
				map[i] = Integer.parseInt(st.nextToken());
				avg+=map[i];
			}
			avg/=n;
			double s= 0;
			for(int i = 0 ; i<n; i++) {
				if(map[i]>avg) {
					s++;
				}
			}
			double fin = Math.round((s/n)*100000);
			fin/=1000;
			System.out.printf("#%d %.3f%%\n",test_case,fin);
		}
	}

}
