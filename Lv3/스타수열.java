class Solution {
    public int solution(int[] a) {
        int answer = -1;
        int[] cnt = new int[a.length];
        int[] lastIndex = new int[a.length];
        
        for(int i = 0; i < a.length; i++)
            lastIndex[i] = -1;
            
        for(int i = 0; i < a.length; i++){
            int num = a[i];
            if(i - 1 >= 0 && a[i - 1] != num && lastIndex[num] < i - 1){
                cnt[num]++;
                lastIndex[num] = i;
            }else if(i + 1 < a.length && a[i + 1] != num){
                cnt[num]++;
                lastIndex[num]=i + 1;
            }
            answer=Math.max(answer, cnt[num]);
        }
        answer *= 2;
        return answer;
    }
}
