import java.io.*;
import java.util.*;

public class Main_백준_17461_게리맨더링_G4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(1000);
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		Node[] map = new Node[n];
		for (int i = 0; i < n; i++) {
			map[i] = new Node(i,Integer.parseInt(st.nextToken()));

		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < temp; j++) {
				int t = Integer.parseInt(st.nextToken())-1;
				map[i].ch.add(map[t]);
			}
		}

		List<Node> al = new ArrayList<Node>();
		List<Node> bl = new ArrayList<Node>();
		int addA = 0;
		int addB = 0;
		int s = 0;
		boolean v[] = new boolean[n];
		int min = Integer.MAX_VALUE;
		Queue<Node> q= new ArrayDeque<>(); 
		nf: for (int i = 1, size = (1 << n) - 1; i < size; ++i) {
			al.clear();
			bl.clear();
			addA = 0;
			addB = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					al.add(map[j]);
				} else {
					bl.add(map[j]);
				}
			}
			if (al.size() > 1) {
				s = al.size();
				Arrays.fill(v, false);
				q.offer(al.get(0));
				while(!q.isEmpty()) {
					Node nn = q.poll();
					if(v[nn.now])
						continue;
					v[nn.now] = true;
					for(int j = 0,si=nn.ch.size() ; j<si ;j++) {
						for(Node val : al) {
							if(val==nn.ch.get(j))
								q.add(nn.ch.get(j));
						}
					}
				}
				for (int j = 0 ; j<s;j++) {
					if (!v[al.get(j).now]) {
						continue nf;
					}
				}
				for (Node val : al) {
					addA += val.por;
				}

			} else {
				addA += al.get(0).por;
			}

			if (bl.size() > 1) {
				s = bl.size();
				Arrays.fill(v, false);
				q.offer(bl.get(0));
				while(!q.isEmpty()) {
					Node nn = q.poll();
					if(v[nn.now])
						continue;
					v[nn.now] = true;
					for(int j = 0,si=nn.ch.size() ; j<si ;j++) {
						for(Node val : bl) {
							if(val==nn.ch.get(j))
								q.add(nn.ch.get(j));
						}
					}
				}
				for (int j = 0 ; j<s;j++) {
					if (!v[bl.get(j).now]) {
						continue nf;
					}
				}
				for (Node val : bl) {
					addB += val.por;
				}
			} else {
				addB += bl.get(0).por;
			}
			int ab=Math.abs(addB-addA);
			if(addA==0||addB==0)
				continue;
			min = Math.min(min, Math.abs(addB-addA));
		}
		if(min!= Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println(-1);
	}

	static class Node {
		int por;
		int now;
		List<Node> ch = new ArrayList<Node>();

		public Node(int now,int por) {
			this.por = por;
			this.now = now;
		}
	}

}
