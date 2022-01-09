import java.util.*; 
class Solution { 
    public int solution(int[] a) {
        HashSet<Integer> set = new HashSet<Integer>();
 	int min = a[0]; 		
        for (int i = 1; i < a.length; i++){ 
		set.add(min);
 		min = Math.min(a[i], min);
 	} 	
	
        min = a[a.length-1];
 	for (int i = a.length - 2; i >= 0; i--) { 
		set.add(min); 
		min = Math.min(a[i], min); 
	} 
        return set.size(); 
    }
}
