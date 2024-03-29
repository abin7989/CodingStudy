import java.io.*;
import java.util.*;

public class Main_백준_1339_단어수학 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(3000);
	static StringTokenizer st = null;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		int v[] = new int[26];
		int fin[] = new int[26];
		String srr[] = new String[n];
		for (int i = 0; i < n; i++) {
			srr[i] = br.readLine();

			for (int j = 0, size = srr[i].length(), k = size - 1; j < size; j++, k--) {
				v[srr[i].charAt(j) - 'A'] += Math.pow(10, k);
			}
		}
		List<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < 26; i++) {
			if(v[i]!=0)
				al.add(v[i]);
		}
		Collections.sort(al, Collections.reverseOrder());
		int putnum = 9;
		b: for (int i = 0,size =  al.size(); i <size; i++) {
			for (int j = 0; j < 26; j++) {
				if (al.get(i) == v[j] && fin[j] == 0)
					fin[j] = putnum--;
				if (putnum < 0)
					break b;
			}

		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			String t = "";
			for (int j = 0, size = srr[i].length(); j < size; j++) {
				t += fin[srr[i].charAt(j) - 'A'];
			}
			max += Integer.parseInt(t);
		}
		System.out.println(max);
		return;
	}
}
