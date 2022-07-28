import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.valueOf(br.readLine());

			int speed = 0, distance = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				int cmd = Integer.valueOf(st.nextToken());
				if (cmd == 1) {
					int car_speed = Integer.valueOf(st.nextToken());
					distance += (speed + car_speed);
					speed = speed + car_speed;
				} else if (cmd == 2) {
					int car_speed = Integer.valueOf(st.nextToken());
					if (speed > car_speed) {
						distance += (speed - car_speed);
						speed = speed - car_speed;
					} else {
						speed = 0;
					}
				} else if (cmd == 0) {
					distance += speed;
				}
				System.out.println(speed + " " + distance);
			}
			System.out.println("#" + test_case + " " + distance);
		} // end of test_case
	} // end of main
} // end of class
