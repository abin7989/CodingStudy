package com.ssafy.study.Test1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char n = br.readLine().charAt(0);
		switch (n) {
		case '1':
			int t = 1;
			for(int i = 0; i<4;i++) {
				for(int j = 0 ; j<=i;j++) {
					System.out.printf("%d ",t++);
				}
				System.out.println();
			}
			break;
		case 'A':
			char a = 'A';
			int index = 1;
			for(int i = 0; i<5;i++) {
				
				for(int j =0;j<5-i-1;j++) {
					System.out.print("  ");
				}
				for(int j = 0; j<index;j++) {
					System.out.printf("%c ",a++);
				}
				index+=2;
				System.out.println();
			}
			break;

		default:
			break;
		}
	}

}
