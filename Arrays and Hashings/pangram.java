import java.util.HashSet;
import java.util.Set;

public class pangram {
    class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set= new HashSet<>();
        for(int i='a'; i <= 'z'; i++ ){
            set.add((char)i);
        }
        for(int i=0; i < sentence.length(); i++){
            set.remove(sentence.charAt(i));
            if(set.isEmpty()){
                return true;
            }
        }
        return false;
    }
}
}
