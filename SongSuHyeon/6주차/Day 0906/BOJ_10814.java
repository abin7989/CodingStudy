import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class P {
        int age;
        String name;

        public P(int age, String name) {
            super();
            this.age = age;
            this.name = name;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(br.readLine());

        ArrayList<P> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new P(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list, new Comparator<P>() {

            @Override
            public int compare(P o1, P o2) {
                return o1.age-o2.age;
            }


        });

        for (P a : list) {
            System.out.println(a.age + " " + a.name);
        }

    }

}