
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.valueOf(st.nextToken());
				}
			}

			boolean check = true;

			Loop1: for (int i = 0; i < 9; i++) {
				// 가로 체크
				int[] index = new int[10];
				for (int j = 0; j < 9; j++) {
					if (index[arr[i][j]] == 0) {
						index[arr[i][j]]++;
					} else {
						check = false;
						break Loop1;
					}
				}

				// 세로 체크
				int[] index2 = new int[10];
				for (int j = 0; j < 9; j++) {
					if (index2[arr[j][i]] == 0) {
						index2[arr[j][i]]++;
					} else {
						check = false;
						break Loop1;
					}
				}
			}

			// 사각형 체크
			Loop2: for (int k = 0; k < 9; k = k + 3) {
				for (int l = 0; l < 9; l = l + 3) {
					int[] index = new int[10];
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (index[arr[k + i][l + j]] == 0) {
								index[arr[k + i][l + j]]++;
							} else {
								check = false;
								break Loop2;
							}
						}
					}

				}
			}

			if (check == true) {
				System.out.println("#" + test_case+ " " + 1);
			} else {
				System.out.println("#" + test_case+ " " +0);
			}

		}
	} // end of main
} // end of class


/*
 T = int(input())

for test_case in range(1, 1+T):
    arr = [0 for i in range(9)]
    for i in range(9):
        arr[i] = list(map(int, input().split()))

    flag = 1
    # 가로 확인
    for i in range(9):
        cmp = [0 for i in range(9)]
        for j in range(9):
            cmp[arr[i][j]-1] += 1
        if cmp.count(0) >= 1:
            flag = 0
            break

    # 세로 확인
    for i in range(9):
        cmp = [0 for i in range(9)]
        for j in range(9):
            cmp[arr[j][i]-1] += 1
        if cmp.count(0) >= 1:
            flag = 0
            break

    # 사각형 확인
    for i in range(0,9,3):
        for j in range(0,9,3):
            cmp = [0 for k in range(9)]
            for x in range(3):
                for y in range(3):
                    cmp[arr[x+i][y+j] - 1] += 1
        if cmp.count(0) >= 1:
            flag = 0
            break

    if flag == 1:
        print("#{} 1".format(test_case))
    else:
        print("#{} 0".format(test_case))
 */