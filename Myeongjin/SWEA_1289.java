package swea;

import java.util.Scanner;

public class swea1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1;t<=tc;t++) {
			String s = sc.next();
			int answer = 0;
			char now = '0';
			for(int i = 0;i<s.length();i++) {
				if(now!=s.charAt(i)) {
					answer++;
					now = s.charAt(i);
				}
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}

}
