package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� 17281. �߱�
public class Baekjoon_17281 {
	/*
	 * �� �̴׿� 3�ƿ��� �߻��ϸ� �̴��� ����ǰ�, �� ���� ���ݰ� ���� ���� �ٲ۴�.
	 * 9�� Ÿ�ڱ��� ���� �ƴµ� 3�ƿ��� �߻����� ���� ���¸� �̴��� ������ �ʰ�, 1�� Ÿ�ڰ� �ٽ� Ÿ���� ����.
	 * ���� ���, 2�̴׿� 6�� Ÿ�ڰ� ������ Ÿ�ڿ��ٸ�, 3�̴��� 7�� Ÿ�ں��� Ÿ���� ����.
	 * Ÿ�ڰ� ���� �ļ� ���� �� �ִ� ����� ��Ÿ, 2��Ÿ, 3��Ÿ, Ȩ��, �ƿ� �� �ϳ�
	 * ��Ÿ: Ÿ�ڿ� ��� ���ڰ� �� �羿 �����Ѵ�.
	 * 2��Ÿ: Ÿ�ڿ� ��� ���ڰ� �� �羿 �����Ѵ�.
	 * 3��Ÿ: Ÿ�ڿ� ��� ���ڰ� �� �羿 �����Ѵ�.
	 * Ȩ��: Ÿ�ڿ� ��� ���ڰ� Ȩ���� �����Ѵ�.
	 * �ƿ�: ��� ���ڴ� �������� ���ϰ�, ���� ���� �ƿ��� �ϳ� �����Ѵ�.
	 */

	static int N;
	static int maxScore; // �ִ� ����
	static int[][] result;
	static boolean[] selected;
	static int[] lineup;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		result = new int[N][9]; // �̴׿����� Ÿ�� ���
		
		selected = new boolean[9]; // �湮 �迭
		lineup = new int[9]; // Ÿ�� �迭
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());		
			}
		}
		
		// 4�� Ÿ�ڴ� �׻� 1������ �����̱� ������
		selected[3] = true;
		lineup[3] = 0;
		
		maxScore = 0;
		perm(1);
		
		System.out.println(maxScore);

	}
	
	private static void perm(int num) {
		if (num == 9) {
			play();
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (selected[i]) {
				continue;
			}
			selected[i] = true;
			lineup[i] = num;
			perm(num + 1);
			selected[i] = false;
		}
	}
	
	private static void play() {
		int score = 0;
		int start = 0; // ���� Ÿ�� idx
		boolean[] base; // Ȩ, 1��, 2��, 3��
		
		for (int i = 0; i < N; i++) {
			int out = 0;
			base = new boolean[4];
			
			outer: while(true) {
				for (int j = start; j < 9; j++) {
					int hit = result[i][lineup[j]];
					
					switch(hit) {
					case 0: // �ƿ��� ���
						out++;
						break;
					case 1: // 1��Ÿ�� ���
						for (int k = 3; k >= 1; k--) {
							if (base[k]) { // ���̽��� ������ �����ϸ�
								if (k == 3) { // 3���� ��쿣
									score++; // Ȩ���� ���� �� ���� �߰�
									base[k] = false; // ���� ��ġ �ʱ�ȭ
									continue;
								}
								// �̿��� ��쿣
								base[k] = false;
								base[k + 1] = true; // 1�羿 ����
							}
						}
						base[1] = true; // ���� Ÿ�� Ȩ���� 1�� ����
						break;
					case 2: // 2��Ÿ�� ���
						for (int k = 3; k >= 1; k--) {
							if (base[k]) { // ���̽��� ������ �����ϸ�
								if (k == 3 || k == 2) { // 3���� ��쿣
									score++; // Ȩ���� ���� �� ���� �߰�
									base[k] = false; // ���� ��ġ �ʱ�ȭ
									continue;
								}
								// �̿��� ��쿣
								base[k] = false;
								base[k + 2] = true; // 1�羿 ����
							}
						}
						base[2] = true; // ���� Ÿ�� Ȩ���� 2�� ����
						break;
					case 3: // 3��Ÿ�� ���
						for (int k = 3; k >= 1; k--) {
							if (base[k]) { // � �ڸ����� ���� ���� �����ϸ� ������ Ȩ���� ������ ������
								score++; // ���� 1���� �߰�
								base[k] = false;
							}
						}
						base[3] = true;
						break;
					case 4: // Ȩ���� ���
						for (int k = 1; k <= 3; k++) {
							if (base[k]) {
								score++;
								base[k] = false;
							}
						}
						score++; // ���� Ÿ�ڵ� ���� �߰�
						break;
					}
					
					if (out == 3) { // ���� �ƿ��̶��
						start = j + 1;
						if (start == 9) start = 0;
						break outer;
					}
				}
				start = 0;
			}
		}
		
		maxScore = Math.max(maxScore, score);
		
	}

}
