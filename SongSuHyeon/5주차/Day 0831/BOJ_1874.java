import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1874 {

	static int N;

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int[] arr = new int[N];
		int[] origin = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		origin = Arrays.copyOf(arr, arr.length);
		Arrays.sort(arr);

		int idx = 0;
		int cnt = 0;
		boolean flag = false;

		stack.push(arr[idx++]);
		sb.append('+').append("\n");

		while (true) {

			if (cnt == N) {
				flag = true;
				break;
			}

			if (!stack.isEmpty() && stack.peek() > origin[cnt]) {
				break;
			}

			if (!stack.isEmpty() && origin[cnt] == stack.peek()) {
				stack.pop();
				cnt++;
				sb.append('-').append("\n");
			} else {
				stack.push(arr[idx]);
				sb.append('+').append("\n");
				idx++;
			}

		}

		if (flag)
			System.out.println(sb);
		else if (flag == false && cnt < N)
			System.out.println("NO");

	}

}
