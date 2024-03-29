import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4698_테네스의특별한소수 {
	static final int MAX_N = 1000001;
	static boolean[] t = new boolean[MAX_N]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		t[1] = true;
		t[0] = true;
		for(int i =2; i<MAX_N;i++) {
			if(!t[i])
			{
				for(int j = i+i;j<MAX_N;j+=i) {
					t[j] = true;
				}				
			}
		}
		for(int test_case=1;test_case<=T;test_case++) {
			StringTokenizer str= new StringTokenizer(br.readLine());
			String n = str.nextToken();
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			int cnt = 0;
			for(int i = x ; i<=y;i++) {
				if(!t[i]) {
					String temp = String.valueOf(i);
					if(temp.indexOf(n)!=-1) {
						cnt++;
					}
				}
			}
			System.out.printf("#%d %d\n",test_case,cnt);
		}
	}
	
}
