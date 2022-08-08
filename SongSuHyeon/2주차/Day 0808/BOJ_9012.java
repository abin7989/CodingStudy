import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());  // T개의 테스트 데이터
		
		for (int i = 0; i < N; i++) {
			Stack<Character> stack1 = new Stack<>();
			Stack<Character> stack2 = new Stack<>();
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				stack1.push(s.charAt(j));
			}
			
			for (int j = 0; j < s.length(); j++) {
				if(!stack2.isEmpty() && stack1.peek() == '(' && stack2.peek() ==')' ) {
					stack1.pop();
					stack2.pop();
				} else {
					stack2.push(stack1.pop());
				}
			}
			
			if(stack2.isEmpty()) {
				System.out.println("YES");
				
			}else {
				System.out.println("NO");
			}

		}
		
	}  // end of main
}  // end of class
