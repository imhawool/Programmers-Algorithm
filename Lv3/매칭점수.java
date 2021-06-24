import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    public int solution(String word, String[] pages) {
        HashMap<String, Double> basicScore = new HashMap<String, Double>();              
        HashMap<String, Double> linkScore = new HashMap<String, Double>();                
        ArrayList<String> names = new ArrayList<String>();                               
        int answer = 0;                                                                    
        word = word.toLowerCase();                                                        
        
        for(int i = 0; i < pages.length; i++) {        
            pages[i] = pages[i].toLowerCase();            
        }
        
        for(int i = 0; i < pages.length; i++) {            
            int basic = 0;                               
            int outlinkCount = 0;                       
            int hit = 0;                                
            ArrayList<String> links = new ArrayList<String>();
            String pName = "";
 
            Pattern pageName = Pattern.compile("<meta property=\"og:url\" content=\\S+/>");
            Matcher pageNameMatcher = pageName.matcher(pages[i].split("</head>")[0]);
            if(pageNameMatcher.find()) {
                pName = pageNameMatcher.group();                                                   
            }
            pName = pName.substring(32);                                                           
            pName = pName.substring(0,pName.length()-2);                                               
            names.add(pName);
            
            String temp = pages[i];
            temp = temp.split("<body>")[1].replaceAll("[0-9]", " ");
            
            Pattern pattern = Pattern.compile("\\b"+word+"\\b");
            Matcher    matcher = pattern.matcher(temp);
            while(matcher.find()) {
                matcher.group();
                hit++;
            }
            basic = hit;                                        
            basicScore.put(pName, (double)basic);                
         
            temp = pages[i];
            temp = temp.split("<body>")[1];                        
            Pattern linkPattern = Pattern.compile("<a href=\\S+>");
            Matcher linkMatcher = linkPattern.matcher(temp);
            
            while(linkMatcher.find()) {
                String tempGroup = linkMatcher.group();                           
                tempGroup = tempGroup.substring(8);
                tempGroup = tempGroup.substring(0, tempGroup.length() -1);         
                if(tempGroup.charAt(tempGroup.length()-1) == 'a') {
                    tempGroup = tempGroup.substring(0, tempGroup.length()-4);
                }
                System.out.println(tempGroup);                                    
                
                links.add(tempGroup);
            }
            outlinkCount = links.size();
            for(int j = 0; j < links.size(); j++) {
                linkScore.put(links.get(j), linkScore.getOrDefault(links.get(j), 0.0) + ((double)basic / outlinkCount));
            }
            
        }
        
        Iterator<String> iter = basicScore.keySet().iterator();
        HashMap<String, Double> result = new HashMap<String, Double>();
        double maxV = 0; 
        while(iter.hasNext()) {
            Double value = 0.0;
            String page = iter.next();
            if(linkScore.containsKey(page)) {
                value = linkScore.get(page);
            }
            if(basicScore.containsKey(page)) {
                value += basicScore.get(page);
            }
            result.put(page,value);
            
            if(value > maxV) {
                maxV = value;
            }
        }
        for(int i = 0; i < names.size(); i++) {                    
            if(result.get(names.get(i)) == maxV) {
                answer =  i;
                break;
            }
        }


        return answer;
    }
}
