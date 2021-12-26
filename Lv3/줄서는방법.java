import java.util.*;

class Solution {    
    public int[] solution(int n, long k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= n ; ++i) list.add(i);
    
        return go(0, 0, n, k, new int[n], list);
    }
 
    private int[] go(long cnt, int idx, int n, long k, int[] answer, ArrayList<Integer> list){
        if(idx == n){
            return answer;
        }
        
        int num = 0;
        long add = fectorial(n - (idx + 1));
        Collections.sort(list);
        
        while(true){
            num = list.remove(0);
            if(cnt + add >= k) break;
            cnt += add;
            list.add(num);
        }
        
        answer[idx] = num;
        return go(cnt, idx + 1, n, k, answer, list);
    }
    
    private long fectorial(int n){
        long result = 1;
        while(n >= 1) result *= n--;
        
        return result;
    }
}
