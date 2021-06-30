class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] num = new int[3];

        int round = -1;
        int idx = 0;
        while(dartResult.length() > idx){
            char c = dartResult.charAt(idx);
            if(Character.isDigit(c)){
                if(Character.isDigit(dartResult.charAt(idx + 1))){
                    idx++;
                    round++;
                    num[round] = 10;
                }else{
                    round++;
                    num[round] = c - '0';
                }               
            }else if(Character.isLetter(c)){
                int n = score(c);
                num[round] = (int) Math.pow(num[round], n);
            }else if(c == '*'){
                num[round] *= 2;
                if(round > 0){
                    num[round - 1] *= 2;
                }
            }else if(c == '#'){
                    num[round] *= -1;
            }

            idx++;          
        }

        answer = num[0] + num[1] + num[2];
        return answer;
    }

    public int score(char c){
        int num = 0;
        switch (c) {
        case 'S':  num = 1;
                 break;
        case 'D':  num = 2;
                 break;
        case 'T':  num = 3;
                 break;
        }
        return num;
    }
}
