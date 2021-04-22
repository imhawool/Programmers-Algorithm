
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        int len = skill.length();
        int index[] = new int[len];
        int n = 0;
        int k = skill_trees.length;

        while(n < k){

            String str = skill_trees[n];

            for(int i = 0; i < len; i++){
                index[i] =  str.indexOf(skill.charAt(i));
            }

            for(int i =0; i < len-1; i++){
                if((index[i] > index[i+1] && index[i+1] != -1) || (index[i] == -1 && index[i+1] != -1)){
                    answer--;
                    break;
                }
            }
            n++;

        }
        return answer;
    }
}
