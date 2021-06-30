import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();

        if(divisor  == 0){
            answer.add(-1);
            return answer.stream().mapToInt(i->i).toArray();
        }
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list);

        for(Integer num : list){
            if(num >= divisor && num % divisor == 0){
                answer.add(num);
            }
        }           
        if(answer.size() == 0){
            answer.add(-1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
