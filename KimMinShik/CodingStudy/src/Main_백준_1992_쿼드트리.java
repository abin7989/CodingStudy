
import java.io.*;
import java.util.*;

public class Main_백준_1992_쿼드트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st = null;
	static int map[][];
	static String ja(int x,int y,int size) {
		if(size==1) {
			return String.valueOf(map[x][y]);
		}
		String a = ja(x,y,size/2);
		String b = ja(x,y+size/2,size/2);
		String c = ja(x+size/2,y,size/2);
		String d = ja(x+size/2,y+size/2,size/2);
		int temp = a.length()+b.length()+c.length()+d.length();
		if(temp ==4) {
			boolean pass = true;
			int tp = Integer.parseInt(a)+Integer.parseInt(b)+Integer.parseInt(c)+Integer.parseInt(d);
			if(tp==4)
				return "1";
			else if(tp==0)
				return "0";
			else {
				return String.format("(%s%s%s%s)",a,b,c,d);
			}
		}
		else{
			return String.format("(%s%s%s%s)",a,b,c,d);
			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0 ; i < n;i++) {
			String s = br.readLine();
			for(int j = 0 ; j<n;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		System.out.println(ja(0,0,n));
	}
}
