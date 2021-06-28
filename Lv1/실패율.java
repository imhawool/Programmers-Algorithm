import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int N, int[] stages) {
        int users = stages.length;
        List<Double> fail = new ArrayList<>();
        int[] answer = new int[N];

        List<Integer> list = (ArrayList<Integer>) Arrays.stream(stages).boxed().collect(Collectors.toList());
        int idx = 1;
        while(idx <= N){
            double cnt = 0;
            cnt = Collections.frequency(list, idx);
            if(users == 0){
                fail.add((double) 0);
            }else{
                fail.add(cnt/users);
            }
            users -= cnt;
            idx++;
        }

        Map<Integer, Double> map = new HashMap<>();

        for(int i = 1; i <= N; i++){
            map.put(i, fail.get(i-1));
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        int i = 0;
        for (Integer key : keySetList)
        {
            answer[i] = key;
            i++;
        }
        return answer;
    }
}
