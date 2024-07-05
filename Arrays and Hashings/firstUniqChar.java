import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class firstUniqChar {
    class Solution {
    public int firstUniqChar(String s) {
         Map<Character, Integer> map = new LinkedHashMap<>();//stores the frequency of each charcter in the string
        Set<Character> set = new HashSet<>(); //store repeated characters
        for (int i = 0; i < s.length(); i++) { 
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) { //character repeated- remove from the map
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i); // add it to map and set
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();//return 0, -1 or index of the first unique character 
    }
}

}
