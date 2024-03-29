
import java.io.*;
import java.util.*;

public class Main_10974_모든순열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(1000);
	static int map[];

	static void swap(int a, int b) {
		int temp = map[a];
		map[a] = map[b];
		map[b] = temp;
	}

	static boolean next_Perm() {
		int i,j,k;
		i=j=k=map.length-1;
		while(i>0&&map[i-1]>=map[i])i--;
		if(i==0)
			return false;
		while(map[i-1]>=map[j])j--;
		swap(i-1,j);
		while(i<k)swap(i++,k--);
		
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		map = new int[n];
	
		for (int i = 0; i < n; i++) {
			map[i] = i+1;
		}
		do {
			for(int i = 0 ; i< n ; i++) {
				sb.append(map[i]).append(" ");
			}
			sb.append("\n");
		}while(next_Perm());
		System.out.println(sb);
	}
}
