package num1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		for(int test = 1; test <=T; test++) {
			Stack<String> s = new Stack<String>();
			int n = Integer.parseInt(br.readLine());
			String p = br.readLine();
			EXIT:for(int i = 0; i < n; i ++) {
				char temp = p.charAt(i);
				switch (temp) {
				case '(':
				case '[':
				case '{':
				case '<':
					s.push(String.valueOf(temp));
					break;
				case ')':
					if(s.isEmpty())
						break EXIT;
					if(s.peek().charAt(0)=='(') {
						s.pop();
					}else {
						break EXIT;
					}
					break;
				case ']':
					if(s.isEmpty())
						break EXIT;
					if(s.peek().charAt(0)=='[') {
						s.pop();
					}else {
						break EXIT;
					}
					break;
				case '}':
					if(s.isEmpty())
						break EXIT;
					if(s.peek().charAt(0)=='{') {
						s.pop();
					}else {
						break EXIT;
					}
					break;
				case '>':
					if(s.isEmpty())
						break EXIT;
					if(s.peek().charAt(0)=='<') {
						s.pop();
					}else {
						break EXIT;
					}
					break;
				}//switch end
				
			}//문자열 반복
			if(s.isEmpty()) {
				System.out.printf("#%d 1\n",test);
			}else {
				System.out.printf("#%d 0\n",test);
			}
		}
	}
}
