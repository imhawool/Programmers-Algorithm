class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {

        recursive(arr, 0, 0, arr.length);
        return answer;
    }
    public void recursive(int arr[][], int a, int b, int len){
        if(len == 1){
            if(arr[a][b] == 0){
                answer[0]++;
            }else{
                answer[1]++;
            }
            return;
        }

        int num = arr[a][b];
        boolean chk = true;
        for(int i = a; i < a + len; i++){

            for(int j = b;j < b + len; j++){
                if(num != arr[i][j]){
                    chk = false;
                    break;
                }
            }
        }

        if(chk){
            if(num == 0){
                answer[0]++;
            }else{
                answer[1]++;
            }
        }else{
            len /= 2;

            recursive(arr, a, b, len);
            recursive(arr, a + len, b, len);
            recursive(arr, a, b + len, len);
            recursive(arr, a + len, b + len, len);
        }
    }
}
