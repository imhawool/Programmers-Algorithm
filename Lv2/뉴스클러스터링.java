import java.util.ArrayList;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> multiSet1 = new ArrayList<>();
        ArrayList<String> multiSet2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        for(int i = 0; i < str1.length() - 1; i++){
            if(str1.charAt(i)>= 'a' && str1.charAt(i) <= 'z' 
                    && str1.charAt(i + 1)>= 'a' && str1.charAt(i + 1) <= 'z'){
                multiSet1.add(str1.substring(i, i+2));
            }
        }
        for(int i = 0; i < str2.length() - 1; i++){
            if(str2.charAt(i)>= 'a' && str2.charAt(i) <= 'z' 
                    && str2.charAt(i + 1)>= 'a' && str2.charAt(i + 1) <= 'z'){
                multiSet2.add(str2.substring(i, i+2));
            }
        }

        for(String s : multiSet1){
            if(multiSet2.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }

        for(String s : multiSet2){
            union.add(s);
        }

        if(union.size() == 0) {
              answer = 65536;
        }else{
            answer = (int)(((double)intersection.size() / (double)union.size()) * 65536);
        }
        return answer;
    }
}
