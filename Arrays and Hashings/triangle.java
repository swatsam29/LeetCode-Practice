import java.util.Arrays;

public class triangle {
    class Solution {
    public int triangleNumber(int[] nums) {
        int n= nums.length;
        int count =0;
        Arrays.sort(nums);
        for(int i= n-1; i>=2; i--){
            int j=0, k= i-1;
            while(j<k){
                if(nums[j] + nums[k] > nums[i]){
                    count += k - j;
                    k--;
                }else{
                    j++;
                }
            }
        }
        return count;
    }
}
}
