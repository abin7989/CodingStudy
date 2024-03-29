import java.io.*;
import java.util.*;
public class Main_백준_1182_부분순열의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(100);
	static StringTokenizer st ;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		int map[] = new int [n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i< n ; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		int temp = 0 ;
		int cnt = 0;
		for(int i = 1 ; i<(1<<n);i++) {
			temp = 0 ;
			for(int j = 0 ; j< n ; j++) {
				if((i&1<<j)!=0) {
					temp+= map[j];
				}
			}
			if(temp==sum)
				cnt++;
		}
		System.out.println(cnt);
	}
}
