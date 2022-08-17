import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1541 {
	static int sum =0 , res = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, "-");

		List<Integer> list = new ArrayList<Integer>();
		
		while (st.hasMoreTokens()) {
			int num = 0;
			int sub = 0;
			
			String tmp = st.nextToken();
			
			if(!tmp.contains("+")) {
				num = Integer.parseInt(tmp);
				list.add(num);
			}
			else {
				StringTokenizer st2 = new StringTokenizer(tmp, "+");
				while(st2.hasMoreTokens()) {
					int t = Integer.parseInt(st2.nextToken());
					sub += t;
				}
				list.add(sub);
			}
			
		}
		
		res = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			sum -= list.get(i);
		}
		
		System.out.println(res + sum);

	}

}
