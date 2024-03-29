import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main_백준_1931_회의실배정{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		List<Point> al = new ArrayList<Point>();
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine()," ");
			al.add(new Point(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()))
					);
		}
		Collections.sort(al,(o1,o2)-> o1.y==o2.y?o1.x-o2.x:o1.y-o2.y);
		int pre = al.get(0).y;
		int cnt = 1;
		for(int i = 1,size = al.size() ; i <size;i++ ) {
			if(al.get(i).x<pre)
				continue;
			pre = al.get(i).y;
			cnt++;
		}
		System.out.println(cnt);
	}

}
