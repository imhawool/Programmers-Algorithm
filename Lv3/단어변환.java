class Solution {
    int answer = 51;
    boolean[] chk;
    public int solution(String begin, String target, String[] words) {
        chk = new boolean[words.length];

        dfs(begin, target, 0, words);
        answer = answer == 51 ? 0 : answer;

        return answer;
    }

    public void dfs(String begin, String target, int count, String[] words){
        if(target.equals(begin)){
            answer =  answer > count ? count : answer;
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(!chk[i] && check(begin, words[i])){
                chk[i] = true;
                dfs(words[i], target, count+1, words);
                chk[i] = false;
            }
        }
    }

    public boolean check(String begin, String target){
        int cnt = 0;
        for(int i = 0 ; i < begin.length(); i++){
            if(begin.charAt(i) != target.charAt(i)){
                cnt++;
            }
        }
        return cnt == 1 ? true : false; 
    }
}
