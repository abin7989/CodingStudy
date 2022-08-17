import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		Stack<Character> stack = new Stack<Character>();

		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '<') {
				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(s.charAt(i));
				flag = true;
				continue;
			} else if (s.charAt(i) == '>') {
				System.out.print(s.charAt(i));
				flag = false;
				continue;
			}

			if (flag == true) {
				System.out.print(s.charAt(i));
				continue;
			}

			if (flag == false) {
				if (s.charAt(i) == ' ') {
					while (!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(s.charAt(i));
				}

				else {
					stack.push(s.charAt(i));
				}

			}

		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}

	}

}
