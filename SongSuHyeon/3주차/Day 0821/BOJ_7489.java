import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7489 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			BigInteger n = new BigInteger(br.readLine());

			BigInteger res = factorial(n);
			String s = res.toString();

			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) != '0') {
					System.out.println(s.charAt(i));
					break;
				}
			}

		}

	}

	private static BigInteger factorial(BigInteger n) {
		// 전달되는 값보다 크면 1, 같으면 0 그리고 작은 경우 -1을 반환
		if (n.compareTo(BigInteger.ONE) == 0)
			return n;
		else
			return factorial(n.subtract(BigInteger.ONE)).multiply(n);
	}
}
