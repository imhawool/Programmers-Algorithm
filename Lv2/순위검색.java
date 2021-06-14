import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();    
    static Map<String,List<Integer>> map=new HashMap<>();
    static int[] answer;

    static void dfs(String str,int depth,String[] info){
        if(depth==4){
            if(map.containsKey(str)==false){
                List<Integer> list=new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                map.put(str,list);
            }else{
                map.get(str).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(str+"-",depth+1,info);
        dfs(str+info[depth],depth+1,info);
    }

    static void setInfo(String[] info){
        for(int i=0;i<info.length;i++){
            dfs("",0,info[i].split(" "));
        }

        Iterator<String> it= map.keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            List<Integer> li=map.get(key);
            Collections.sort(li);
        }
    }

    static int counting(String str,int score){
        if(map.containsKey(str)==false) return 0;

        List<Integer> list=map.get(str);
        int start=0,end=list.size()-1;

        while(start<=end){
            int mid=(start+end)/2;
            if(list.get(mid)<score){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return list.size()-start;
    }

    static void makeAnswer(String[] query){
        for(int i=0;i<query.length;i++){
            String str="";
            String[] arr=query[i].split(" ");

            for(int j=0;j<arr.length-1;j++){
                if(arr[j].equals("and")) continue; 
                str+=arr[j];
            }
            answer[i]=counting(str,Integer.parseInt(arr[arr.length-1]));
        }
    }

    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        setInfo(info);
        makeAnswer(query);
        return answer;
    }
}
