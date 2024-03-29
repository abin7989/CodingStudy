import java.io.*;
import java.util.*;

public class Main_백준_13251_조약돌꺼내기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st =null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int t = 0; 
		int map[] = new int[m];
		double po[] = new double[m];
		for(int i = 0 ; i < m ; i++) {
			int temp =  Integer.parseInt(st.nextToken());
			map[i] = temp;
			t += temp;
		}
		int k = Integer.parseInt(br.readLine());
		if(m==1||k==1) {
			System.out.println("1.0");
			return;
		}
		Arrays.fill(po, 1.0);
		double ans = 0.0;
		for(int i= 0;i<m;i++) {
			if(map[i]>=k ) {
				for(int j=0;j<k;j++) {
					po[i]*=(double)(map[i]-j)/(t-j);
				}
				ans += po[i];
			}
		}
		System.out.println(ans);
	}
}
