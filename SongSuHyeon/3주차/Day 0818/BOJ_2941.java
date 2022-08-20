import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String str[] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		for (int i = 0; i < str.length; i++) {
			if (s.contains(str[i]))
				// 특수문자로 변환하는 이유는 알파벳으로 변환했다간 다음 검사때 중복카운트가 되는 경우를 방지, 다른 특수문자도 가능
				s = s.replace(str[i], "!");
		}
		System.out.println(s.length());
	}
}
