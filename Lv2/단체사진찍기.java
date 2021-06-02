import java.util.HashMap;

class Solution {
    public int answer = 0;
    public int[] position;
    public HashMap<Character, Integer> hm;

    public int solution(int n, String[] data) {

        position = new int[8];
        boolean[] visited = new boolean[8];     

        hm = new HashMap<>();
        hm.put('A', 0);
        hm.put('C', 1);
        hm.put('F', 2);
        hm.put('J', 3);
        hm.put('M', 4);
        hm.put('N', 5);
        hm.put('R', 6);
        hm.put('T', 7);

        perm(0, visited, data);

        return answer;
    }

    public void perm(int depth, boolean[] visited, String[] data){
        if(depth == 8){
            if(check(data)){
                answer++;
            }

            return;
        }

        for (int i=0; i < 8; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                position[depth] = i;
                perm(depth + 1, visited, data);
                visited[i] = false;
            }
        }
    }

    public boolean check(String[] data){
        for(int i = 0; i < data.length; i++){
            int x = hm.get(data[i].charAt(0));
            int xPos = position[x];

            int y = hm.get(data[i].charAt(2));
            int yPos = position[y];

            char type = data[i].charAt(3);
            int distance = data[i].charAt(4) - '0';

            switch(type){
             case '=' : 
                 if(Math.abs(xPos - yPos) - 1 != distance){
                     return false;
                 }
                 break;
             case '>' : 
                 if(Math.abs(xPos - yPos) - 1 <= distance){
                     return false;
                 }
                 break;
             case '<' : 
                 if(Math.abs(xPos - yPos) - 1 >= distance){
                     return false;
                 }
                 break;
            }           
        }
        return true;
    }
}
