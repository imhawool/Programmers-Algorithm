class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
       String[] answer = new String[n];
        String[][] ansSqr = new String[n][n];

        for(int i = 0; i < n; i++){
            String num1;
            String num2;
            num1 = Integer.toBinaryString(arr1[i]);
            num2 = Integer.toBinaryString(arr2[i]);

            while(num1.length() < n){
                num1 = "0" + num1;
            }


            while(num2.length() < n){
                num2 = "0" + num2;
            }

            for(int k = 0; k < n; k++){
                if(num1.charAt(k) == '1' || num2.charAt(k) == '1' ){
                    ansSqr[i][k] = "#";
                }else{
                    ansSqr[i][k] = " ";
                }
            }
        }

        for(int i = 0; i < n; i++){
            answer[i] = ansSqr[i][0];
        }

        for(int i = 0; i < n; i++){
            for(int k = 1; k < n; k++){
                answer[i] += ansSqr[i][k];              
            }
        }
        return answer;
    }
}
