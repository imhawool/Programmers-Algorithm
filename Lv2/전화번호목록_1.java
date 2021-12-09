import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++){
			map.put(phone_book[i], phone_book[i].length());
		}

        for(String phone : phone_book){
            for (int i = 0 ; i < phone.length() ; i++){
                if(map.containsKey(phone.substring(0, i))){
                    return false;
                }
            }
        }


        return true;
       
    }
}
