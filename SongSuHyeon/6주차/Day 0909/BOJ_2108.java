import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        System.out.println(Math.round(sum*1.0/N*1.0));  // 산술평균을 출력

        Arrays.sort(arr);

        System.out.println(arr[N/2]);  // 중앙값을 출력

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, (o1, o2) -> {
            if(o1.getValue() == o2.getValue())
                return o1.getKey() - o2.getKey();
            return o2.getValue() - o1.getValue();
        });

        int cnt = 0;
        int max = entryList.get(0).getValue();
        for (Map.Entry<Integer, Integer> t : entryList) {
            if(max == t.getValue() ){
                cnt++;
            }
        }

        // 최빈값이 1개이상이면 최빈값 중 두 번째로 작은 값을 출력
        if(cnt>1){
            System.out.println(entryList.get(1).getKey());
        }else{
            System.out.println(entryList.get(0).getKey());
        }

        System.out.println(Math.abs(arr[0] - arr[N-1]));  // 범위를 출력

    } // end of main

} // end of class
