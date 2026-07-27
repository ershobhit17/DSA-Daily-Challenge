class Solution {

    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1: Pivot dhoondo
        int pivot = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Agar pivot nahi mila to array descending hai
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Pivot se bada element right side se dhoondo
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {

                // Swap
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;

                break;
            }
        }

        // Step 3: Pivot ke baad wala part reverse
        reverse(nums, pivot + 1, n - 1);
    }

    // Reverse Function
    public void reverse(int[] nums, int start, int end) {

        while (start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}