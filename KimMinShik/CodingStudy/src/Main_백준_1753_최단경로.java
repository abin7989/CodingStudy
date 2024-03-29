import java.io.*;
import java.util.*;

public class Main_백준_1753_최단경로 {
	static BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sBuilder = new StringBuilder(1000);
	static StringTokenizer stringTokenizer;
	static int d[];
	static boolean ch[];
	static List<Node> node[];
	public static void main(String[] args) throws IOException{
		stringTokenizer = new StringTokenizer(bReader.readLine()," ");
		int v = Integer.parseInt(stringTokenizer.nextToken());
		int com = Integer.parseInt(stringTokenizer.nextToken());
		int start = Integer.parseInt(bReader.readLine());

		d = new int[v+1];
		ch = new boolean[v+1];
		for(int i = 1 ; i <= v;i++) {
			d[i] = Integer.MAX_VALUE;
		}
		node = new ArrayList[v+1];
		for(int i = 1 ; i<=v;i++) {
			node[i] = new ArrayList<Main_백준_1753_최단경로.Node>();
		}
		for(int i = 0 ; i < com; i++) {
			stringTokenizer = new StringTokenizer(bReader.readLine()," ");
			node[Integer.parseInt(stringTokenizer.nextToken())]
					.add(new Node(Integer.parseInt(stringTokenizer.nextToken())
							,Integer.parseInt(stringTokenizer.nextToken())));
		}
		
		dij(start);
		
		for(int i = 1 ; i<=v;i++) {
			if(d[i]!=Integer.MAX_VALUE)
				sBuilder.append(d[i]).append("\n");
			else
				sBuilder.append("INF\n");
		}
		System.out.println(sBuilder);
	}
	public static void dij(int start) {
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		pQueue.offer(new Node(start, 0));
		d[start] = 0;
		while(!pQueue.isEmpty()) {
			Node n = pQueue.poll();
			if(ch[n.to])
				continue;
			ch[n.to] = true;
			for(Node var : node[n.to]) {
				if(d[var.to]>d[n.to]+var.w) {
					d[var.to]=d[n.to]+var.w;
					pQueue.offer(new Node(var.to, d[var.to]));
				}
			}
		}
	}
	static class Node implements Comparable<Node>{
		int to ;
		int w;
		
		public Node(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w-o.w;
		}
	}
}
