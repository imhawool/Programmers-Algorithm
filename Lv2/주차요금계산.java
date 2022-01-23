import java.util.*;

 

class Solution {

 

    public int timeToInt(String time) {

        String temp[] = time.split(":");

        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);

    }

    public int[] solution(int[] fees, String[] records) {

 

        TreeMap<String, Integer> map = new TreeMap<>();

 

        for(String record : records) {

            String temp[] = record.split(" ");

            int time = temp[2].equals("IN") ? -1 : 1;

            time *= timeToInt(temp[0]);

            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);

        }

        int idx = 0, ans[] = new int[map.size()];

        for(int time : map.values()) {

            if(time < 1) time += 1439;

            time -= fees[0];

            int cost = fees[1];

            if(time > 0)

                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

 

            ans[idx++] = cost;

        }

        return ans;

    }

}
