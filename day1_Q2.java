public class day1_Q2 {
 
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
    
        int n = nums.length;

         int k = 0;

        int val = 3;

        for (int i = 0; i < n; i++) {
        
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }

        System.out.println(k);
    }


}

//for leet Code 

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int k = 0;

        for(int i = 0; i < n; i++) {
            if ( nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
