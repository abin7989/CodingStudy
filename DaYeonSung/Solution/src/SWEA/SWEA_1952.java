package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1952. ������
public class SWEA_1952 {
	/*
	 * 1�� �̿��: 1�� �̿� ����
	 * 1�� �̿��: 1�� �̿� ����. �Ŵ� 1�Ϻ��� ����
	 * 3�� �̿��: ���ӵ� 3�� �̿� ����. �Ŵ� 1�Ϻ��� ���� (11, 12���� ����� �����ϳ� �ظ� �Ѿ�°� X)
	 * 1�� �̿��: 1�� �̿� ����. �ų� 1�� 1�� ����
	 */

	static int[] price;
	static int[] plan;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			price = new int[4];
			plan = new int[13];
			// �̿�� ���ݵ� �Է� �ޱ�
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			// 12���� �̿� ��ȹ �Է� �ޱ�
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			min = price[3];
			dfs(1, 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int month, int sum) {
		if (month == 13) {
			if (sum < min)
				min = sum;
			return;
		}
		
		// ������� �ʴ� ����  ���� ��ȭ ����
		if (plan[month] == 0) dfs(month + 1, sum);
		
		// 1�� �������� ä��� dfs
		if (plan[month] > 0) dfs(month + 1, sum + plan[month] * price[0]);
		
		// 1�� �������� ä���
		if (plan[month] > 0) dfs(month + 1, sum + price[1]);
		
		// 3�� �������� ä���
		if (month <= 10) dfs(month + 3, sum + price[2]);
	}

}
