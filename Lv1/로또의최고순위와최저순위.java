import java.util.HashMap;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int max = 0;
        int cnt = 0;
        HashMap<Integer, Integer> lotto = new HashMap<Integer, Integer>();
        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0){
                max++;
            }else{
                lotto.put(lottos[i], 0);
            }
        }

        for(int i = 0; i < 6; i++){
            if(lotto.containsKey(win_nums[i]))
                cnt++;
        }


        switch (cnt+max) {
        case 0:  answer[0] = 6;
                 break;
        case 1:  answer[0] = 6;
                 break;
        case 2:  answer[0] = 5;
                 break;
        case 3:  answer[0] = 4;
                 break;
        case 4:  answer[0] = 3;
                 break;
        case 5:  answer[0] = 2;
                 break;
        case 6:  answer[0] = 1;
                 break;
        }

        switch (cnt) {
        case 0:  answer[1] = 6;
                 break;
        case 1:  answer[1] = 6;
                 break;
        case 2:  answer[1] = 5;
                 break;
        case 3:  answer[1] = 4;
                 break;
        case 4:  answer[1] = 3;
                 break;
        case 5:  answer[1] = 2;
                 break;
        case 6:  answer[1] = 1;
                 break;
        }
        return answer;
    }
}
