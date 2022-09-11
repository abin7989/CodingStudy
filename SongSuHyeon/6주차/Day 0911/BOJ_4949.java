import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        loop:
        while (true) {
            Stack<Character> stack = new Stack<>();
            Stack<Character> stack2 = new Stack<>();

            String s = br.readLine();

            if (s.equals("."))
                break;

            boolean flag = true;
            for (int i = s.length() - 1; i >= 0; i--) {

                if (s.charAt(i) == ')' || s.charAt(i) == ']')
                    stack.push(s.charAt(i));
                else if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                    stack2.push(s.charAt(i));

                    if (!stack.isEmpty() && stack2.peek() == '(' && stack.peek() == ')') {
                        stack.pop();
                        stack2.pop();
                    } else if (!stack.isEmpty() && stack2.peek() == '[' && stack.peek() == ']') {
                        stack.pop();
                        stack2.pop();
                    }
                }

            }

            if (stack.isEmpty() && stack2.isEmpty())
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");

        }
        System.out.println(sb);
    } // end of main

} // end of class
