package day_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BackJoon_10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> stack = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);

			String cmd = st.nextToken();
			switch (cmd) {
			case "push":
				int num = Integer.valueOf(st.nextToken());
				stack.push(num);
				break;
			case "pop":
				if (!stack.empty()) {
					System.out.println(stack.pop());
				} else {
					System.out.println(-1);
				}
				break;
			case "top":
				if(!stack.empty()) {
					System.out.println(stack.peek());
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.empty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			}
		}
	}
}
