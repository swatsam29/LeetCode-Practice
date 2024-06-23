import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class GroupAnagrams {
    class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String current: strs){
            char[] characters= current.toCharArray(); //eat---> "e","a","t"
            Arrays.sort(characters); //"a","e","t"

            String sorted= new String(characters);//aet

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
              map.get(sorted).add(current);
        }
        result.addAll(map.values());
        return result;
        
    }
}

    
}
