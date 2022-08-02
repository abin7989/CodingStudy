package day_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BackJoon_10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.valueOf(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			int num = Integer.valueOf(br.readLine());
			if(num != 0) {
				stack.push(num);
			} else {
				stack.pop();
			}
		
		}
		
		int sum = 0;
		while(!stack.empty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
