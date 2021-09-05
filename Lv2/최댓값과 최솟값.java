class Solution {
    String min, max;
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        min = arr[0];
        max = arr[0];
        for(int i = 1; i < arr.length; i++){
            res(arr[i]);    
        }
        
        return min + " " + max;
    }
    public void res(String s){
        if(Integer.valueOf(min) >= Integer.valueOf(s))
            min = s;
        if(Integer.valueOf(max) <= Integer.valueOf(s))
            max = s;
    }   
}
